package mz.co.brunosiueia.springboot.controller;

import mz.co.brunosiueia.springboot.modelo.Consumo_clienteModel;
import mz.co.brunosiueia.springboot.modelo.ContaConsumoJoin;
import mz.co.brunosiueia.springboot.modelo.ContaModel;
import mz.co.brunosiueia.springboot.modelo.TransacaoModel;
import mz.co.brunosiueia.springboot.repository.ConsumoClienteRepository;
import mz.co.brunosiueia.springboot.repository.ContaRepository;
import mz.co.brunosiueia.springboot.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.math.BigInteger;
//import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private ConsumoClienteRepository consumoClienteRepository;
    private TransacaoRepository transacaorepository;
    private ContaRepository contaRepository;

    private double credito= 0;
    private String resposta;

    @PostMapping(value = "/{dividaId}")
    public String pagar(@PathVariable("dividaId") long creditoId, @PathVariable("valor") int valor_pagar){

        // não criei a sessao, logo estou a inicializar o user logado
        int user_logado = 1;
        int idd;

        LocalDate localDate = LocalDate.now().plusYears(12);
        Date data_fim = convertLocaToDate(localDate);
        Date date_inicio = new Date();


        Optional<Consumo_clienteModel> contaConsumo = consumoClienteRepository.findById(creditoId);
        if(contaConsumo.isPresent()){
            Consumo_clienteModel consumolista = contaConsumo.get();

        //double divida = verificarDivida(creditoId);
            long diferenca = (consumolista.getCc_data_pagamento()).getDay() - (consumolista.getCriado_em()).getDay();
            double divida = taxaJuro(diferenca,consumolista.getCc_credito()) + consumolista.getCc_credito();

        if (valor_pagar == divida){

            // code
            var transacao = new TransacaoModel();
            transacao.setC_numero(consumolista.getCc_id());
            transacao.setC_valor(valor_pagar);
            transacao.setC_valor(valor_pagar);
            transacao.setT_tipo_transacao(1);
            transacao.setCriado_em(date_inicio);
            transacao.setModificado_em(date_inicio);
            transacao.setData_fim(data_fim);
            transacaorepository.save(transacao);

        }else if (valor_pagar > divida){

            resposta= "Nao pode pagar um valor superior a sua divida!";

        }else {
            resposta= "Precisa pagar valor completo!";
        }

        return resposta;
        }else {
            return "Sem dados";
        }
    }

    //consultar divida, setando a conta do cliente
    @RequestMapping(value = "/consultaCredito/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContaModel> GetById(@PathVariable(value = "id") long id){

         double divida = 0;

        Optional<ContaConsumoJoin> contaCliente = contaRepository.findContaById(id);
        if(contaCliente.isPresent()){
            ContaConsumoJoin dadosConta = contaCliente.get();

            dadosConta.getCc_credito();
            Date pagamento= dadosConta.getCc_data_pagamento();
            Date inicio= dadosConta.getCriado_em();

            long diferenca = pagamento.getTime() - inicio.getTime();
            TimeUnit time = TimeUnit.DAYS;
            long dia = time.convert(diferenca, TimeUnit.MILLISECONDS);

            if(dia > 0){
                divida = taxaJuro(dia,dadosConta.getCc_credito()) + dadosConta.getCc_credito();
            }else {
                divida = dadosConta.getCc_credito();
            }
            return new ResponseEntity<Consumo_clienteModel>(dadosConta, HttpStatus.OK);;

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    // metodo para calcular valor da taxa caso passar o dia pagamnto
    public double taxaJuro(long dia, double credito){
        double juros = 0;

        if (dia <= 5){
            juros = credito*0.05;

        }
        else if (dia > 5  && dia <= 10){
            juros = credito*0.2;
        }
        else if (dia > 10 && dia <= 20){
            juros = credito*0.35;

        }
        else if (dia > 20 && dia <= 31){
            juros = credito*0.5;
        }

        return juros;
    }

    public Date convertLocaToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
