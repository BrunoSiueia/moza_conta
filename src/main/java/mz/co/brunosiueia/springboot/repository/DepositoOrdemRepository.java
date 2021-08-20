package mz.co.brunosiueia.springboot.repository;

import mz.co.brunosiueia.springboot.modelo.Deposito_ordemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoOrdemRepository extends JpaRepository<Deposito_ordemModel, Long> {

}
