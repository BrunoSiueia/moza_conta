package mz.co.brunosiueia.springboot.modelo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class ContaConsumoJoin {


    @Column(name = "cc_credito")
    private double cc_credito;

    @Column(name = "cc_data_pagamento")
    private Date cc_data_pagamento;

    @Column(name = "criado_em")
    private Date criado_em;

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

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }
}
