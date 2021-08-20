package mz.co.brunosiueia.springboot.controller;

import mz.co.brunosiueia.springboot.modelo.ContaModel;
import mz.co.brunosiueia.springboot.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @RequestMapping(value = "/contas", method = RequestMethod.GET)
    public List<ContaModel> Get(){
        return contaRepository.findAll();
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContaModel> GetById(@PathVariable(value = "id") BigInteger id)
    {
        Optional<ContaModel> conta = contaRepository.findById(id);
        if(conta.isPresent())
            return new ResponseEntity<ContaModel>(conta.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/conta", method =  RequestMethod.POST)
    public ContaModel Post(@Valid @RequestBody ContaModel conta)
    {
        return contaRepository.save(conta);
    }

    @RequestMapping(value = "/conta/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<ContaModel> Put(@PathVariable(value = "id") BigInteger id, @Valid @RequestBody ContaModel novaConta)
    {
        Optional<ContaModel> contaAntiga = contaRepository.findById(id);
        if(contaAntiga.isPresent()){
            ContaModel conta = contaAntiga.get();
            conta.setC_saldo(novaConta.getC_saldo());
            contaRepository.save(conta);
            return new ResponseEntity<ContaModel>(conta, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") BigInteger id)
    {
        Optional<ContaModel> conta = contaRepository.findById(id);
        if(conta.isPresent()){
            contaRepository.delete(conta.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
