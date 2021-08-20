package mz.co.brunosiueia.springboot.repository;

import mz.co.brunosiueia.springboot.modelo.ContaConsumoJoin;
import mz.co.brunosiueia.springboot.modelo.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, BigInteger> {

    @Query(nativeQuery = true, value="select c.* from c_conta c inner join cc_consumo_cliente cc on c.do_id = cc.do_id  where cc.data_fim > NOW() AND c.c_id = :id")
    public Optional<ContaConsumoJoin> findContaById(@Param("id") long  id);

}
