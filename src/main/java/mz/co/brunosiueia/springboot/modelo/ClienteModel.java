package mz.co.brunosiueia.springboot.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "cl_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cl_id")
    private BigInteger cl_id;

    @Column(name = "cl_nome")
    private String cl_nome;

    @Column(name = "cl_documento")
    private String cl_documento;

    @Column(name = "cl_num_documento")
    private String cl_num_documento;

    @Column(name = "cl_declaracao_rendimento")
    private String cl_declaracao_rendimento;

    @Column(name = "cl_endereco")
    private String cl_endereco;

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

    public BigInteger getCl_id() {
        return cl_id;
    }

    public void setCl_id(BigInteger cl_id) {
        this.cl_id = cl_id;
    }

    public String getCl_nome() {
        return cl_nome;
    }

    public void setCl_nome(String cl_nome) {
        this.cl_nome = cl_nome;
    }

    public String getCl_documento() {
        return cl_documento;
    }

    public void setCl_documento(String cl_documento) {
        this.cl_documento = cl_documento;
    }

    public String getCl_num_documento() {
        return cl_num_documento;
    }

    public void setCl_num_documento(String cl_num_documento) {
        this.cl_num_documento = cl_num_documento;
    }

    public String getCl_declaracao_rendimento() {
        return cl_declaracao_rendimento;
    }

    public void setCl_declaracao_rendimento(String cl_declaracao_rendimento) {
        this.cl_declaracao_rendimento = cl_declaracao_rendimento;
    }

    public String getCl_endereco() {
        return cl_endereco;
    }

    public void setCl_endereco(String cl_endereco) {
        this.cl_endereco = cl_endereco;
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
