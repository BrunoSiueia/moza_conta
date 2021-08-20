package mz.co.brunosiueia.springboot.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "f_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "f_id")
    private BigInteger f_id;

    @Column(name = "f_nome")
    private String f_nome;

    @Column(name = "f_email")
    private String f_email;

    @Column(name = "f_contacto")
    private Integer f_contacto;

    @Column(name = "f_endereco")
    private String f_endereco;

    @Column(name = "f_username")
    private String f_username;

    @Column(name = "f_senha")
    private String f_senha;

    @Column(name = "last_login_em")
    private Date last_login_em;

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

    public BigInteger getF_id() {
        return f_id;
    }

    public void setF_id(BigInteger f_id) {
        this.f_id = f_id;
    }

    public String getF_nome() {
        return f_nome;
    }

    public void setF_nome(String f_nome) {
        this.f_nome = f_nome;
    }

    public String getF_email() {
        return f_email;
    }

    public void setF_email(String f_email) {
        this.f_email = f_email;
    }

    public Integer getF_contacto() {
        return f_contacto;
    }

    public void setF_contacto(Integer f_contacto) {
        this.f_contacto = f_contacto;
    }

    public String getF_endereco() {
        return f_endereco;
    }

    public void setF_endereco(String f_endereco) {
        this.f_endereco = f_endereco;
    }

    public String getF_username() {
        return f_username;
    }

    public void setF_username(String f_username) {
        this.f_username = f_username;
    }

    public String getF_senha() {
        return f_senha;
    }

    public void setF_senha(String f_senha) {
        this.f_senha = f_senha;
    }

    public Date getLast_login_em() {
        return last_login_em;
    }

    public void setLast_login_em(Date last_login_em) {
        this.last_login_em = last_login_em;
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
