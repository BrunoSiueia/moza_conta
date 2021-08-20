package mz.co.brunosiueia.springboot.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "do_deposito_ordem")
public class Deposito_ordemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger do_id;

    @Column(name = "do_moeda")
    private int c_numero;

    @ManyToOne
    @JoinColumn(name = "criado_por")
    private FuncionarioModel criado_por;

    @ManyToOne
    @JoinColumn(name = "modificado_por")
    private FuncionarioModel modificado_por;

    @Column(name = "criado_em")
    private Date criado_em;

    @Column(name = "modificado_em")
    private Date modificado_em;

    @Column(name = "data_fim")
    private Date data_fim;

    public Deposito_ordemModel(BigInteger do_id) {
        this.do_id = do_id;
    }

    public Deposito_ordemModel() {
    }

    public BigInteger getDo_id() {
        return do_id;
    }

    public void setDo_id(BigInteger do_id) {
        this.do_id = do_id;
    }

    public int getC_numero() {
        return c_numero;
    }

    public void setC_numero(int c_numero) {
        this.c_numero = c_numero;
    }

    public FuncionarioModel getCriado_por() {
        return criado_por;
    }

    public void setCriado_por(FuncionarioModel criado_por) {
        this.criado_por = criado_por;
    }

    public FuncionarioModel getModificado_por() {
        return modificado_por;
    }

    public void setModificado_por(FuncionarioModel modificado_por) {
        this.modificado_por = modificado_por;
    }

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    public Date getModificado_em() {
        return modificado_em;
    }

    public void setModificado_em(Date modificado_em) {
        this.modificado_em = modificado_em;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
}
