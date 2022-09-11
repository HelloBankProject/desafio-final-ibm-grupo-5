package br.com.hellobankproject.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "conta")
public class Conta {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo nao informado")
    @Column(name = "tipo", length = 50)
    private String tipo;

    @NotBlank(message = "Campo nao informado")
    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "credito")
    private Double credito;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({ "listaPrimeiroTitular", "listaSegundoTitular" })
    private Cliente primeiroTitular;

    @ManyToOne
    @JoinColumn(name = "id_outro_cliente")
    @JsonIgnoreProperties({ "listaSegundoTitular", "listaPrimeiroTitular" })
    private Cliente segundoTitular;

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

    public Cliente getPrimeiroTitular() {
        return primeiroTitular;
    }

    public void setPrimeiroTitular(Cliente primeiroTitular) {
        this.primeiroTitular = primeiroTitular;
    }

    public Cliente getSegundoTitular() {
        return segundoTitular;
    }

    public void setSegundoTitular(Cliente segundoTitular) {
        this.segundoTitular = segundoTitular;
    }
}
