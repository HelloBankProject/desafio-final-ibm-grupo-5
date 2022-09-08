package br.com.hellobank.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conta")
public class Conta {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "credito", nullable = true)
    private Double credito;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    //@JsonIgnoreProperties("listaConta")
    private Cliente cliente;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("conta")
    private List<Transacao> listaTransacao;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public List<Transacao> getListaTransacao() {
        return listaTransacao;
    }

    public void setListaTransacao(List<Transacao> listaTransacao) {
        this.listaTransacao = listaTransacao;
    }

}
