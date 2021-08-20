package mz.co.brunosiueia.springboot.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="transacao")
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger t_id;

    @Column(name = "cc_id")
    public BigInteger cc_id;

    @Column(name = "c_valor")
    private int c_valor;

    @Column(name = "t_tipo_transacao")
    private int t_tipo_transacao;

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

    public TransacaoModel(){

    }

    public BigInteger getT_id() {
        return t_id;
    }

    public void setT_id(BigInteger t_id) {
        this.t_id = t_id;
    }

    public BigInteger getC_numero() {
        return cc_id;
    }

    public void setC_numero(BigInteger cc_id) {
        this.cc_id = cc_id;
    }

    public int getC_valor() {
        return c_valor;
    }

    public void setC_valor(int c_valor) {
        this.c_valor = c_valor;
    }

    public int getT_tipo_transacao() {
        return t_tipo_transacao;
    }

    public void setT_tipo_transacao(int t_tipo_transacao) {
        this.t_tipo_transacao = t_tipo_transacao;
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
