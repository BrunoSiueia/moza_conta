package mz.co.brunosiueia.springboot.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "cc_consumo_cliente")
public class Consumo_clienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cc_id")
    private BigInteger cc_id;

    @ManyToOne
    @JoinColumn(name = "do_id")
    private Deposito_ordemModel do_id;

    @Column(name = "cc_credito")
    private double cc_credito;

    @Column(name = "cc_data_pagamento")
    private Date cc_data_pagamento;

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

    public BigInteger getCc_id() {
        return cc_id;
    }

    public void setCc_id(BigInteger cc_id) {
        this.cc_id = cc_id;
    }

    public Deposito_ordemModel getDo_id() {
        return do_id;
    }

    public void setDo_id(Deposito_ordemModel do_id) {
        this.do_id = do_id;
    }

    public double getCc_credito() {
        return cc_credito;
    }

    public void setCc_credito(double cc_credito) {
        this.cc_credito = cc_credito;
    }

    public Date getCc_data_pagamento() {
        return cc_data_pagamento;
    }

    public void setCc_data_pagamento(Date cc_data_pagamento) {
        this.cc_data_pagamento = cc_data_pagamento;
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
