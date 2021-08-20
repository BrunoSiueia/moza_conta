package mz.co.brunosiueia.springboot.repository;

import mz.co.brunosiueia.springboot.modelo.Consumo_clienteModel;
import mz.co.brunosiueia.springboot.modelo.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoModel, Long> {


}
