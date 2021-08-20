package mz.co.brunosiueia.springboot.repository;

import mz.co.brunosiueia.springboot.modelo.Consumo_clienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoClienteRepository extends JpaRepository<Consumo_clienteModel, Long>{

   // List<Consumo_clienteModel> findById(long id);

}
