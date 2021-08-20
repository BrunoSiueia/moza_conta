package mz.co.brunosiueia.springboot.controller;

import mz.co.brunosiueia.springboot.modelo.Consumo_clienteModel;
import mz.co.brunosiueia.springboot.modelo.Consumo_clienteModel;
import mz.co.brunosiueia.springboot.repository.ConsumoClienteRepository;
import mz.co.brunosiueia.springboot.repository.ConsumoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public class Consumo_clienteController {

    @Autowired
    private ConsumoClienteRepository consumoClienteRepository;

    @RequestMapping(value = "/contasconsumo", method = RequestMethod.GET)
    public List<Consumo_clienteModel> Get(){
        return consumoClienteRepository.findAll();
    }

    @RequestMapping(value = "/contaconsumo/{id}", method = RequestMethod.GET)
    public ResponseEntity<Consumo_clienteModel> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Consumo_clienteModel> consumo = consumoClienteRepository.findById(id);
        if(consumo.isPresent())
            return new ResponseEntity<Consumo_clienteModel>(consumo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/contaconsumo", method =  RequestMethod.POST)
    public Consumo_clienteModel Post(@Valid @RequestBody Consumo_clienteModel consumo)
    {
        return consumoClienteRepository.save(consumo);
    }

    @RequestMapping(value = "/contaconsumo/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Consumo_clienteModel> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Consumo_clienteModel novaconsumo)
    {
        Optional<Consumo_clienteModel> consumoAntiga = consumoClienteRepository.findById(id);
        if(consumoAntiga.isPresent()){
            Consumo_clienteModel consumo = consumoAntiga.get();
            consumo.setCc_data_pagamento(novaconsumo.getCc_data_pagamento());
            consumo.setCc_credito(novaconsumo.getCc_credito());
            consumoClienteRepository.save(consumo);
            return new ResponseEntity<Consumo_clienteModel>(consumo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/contaconsumo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Consumo_clienteModel> consumo = consumoClienteRepository.findById(id);
        if(consumo.isPresent()){
            consumoClienteRepository.delete(consumo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
