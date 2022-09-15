package br.com.hellobankproject.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "Transacao")
public class Transacao {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Campo nao informado")
    @Column(name = "valor")
    private Double valor;

    @NotBlank(message = "Campo nao informado")
    @Column(name = "data_transacao")
    private Date data;

    @NotBlank(message = "Campo nao informado")
    @Column(name = "modo_envio", length = 50)
    private String modo;

    public Conta getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Conta recebedor) {
        this.recebedor = recebedor;
    }

    public Conta getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Conta fornecedor) {
        this.fornecedor = fornecedor;
    }

    @ManyToOne
    @JoinColumn(name = "id_recebedor", nullable = false)
    private Conta recebedor;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Conta fornecedor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

}
