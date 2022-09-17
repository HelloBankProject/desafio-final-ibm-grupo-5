package br.com.hellobankproject.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.hellobankproject.api.exception.SaldoException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conta")
public class Conta {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tipo não informado")
    @Column(name = "tipo", length = 50)
    private String tipo;

    @NotNull(message = "Campo não informado")
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

    public void deposito(Double valor) {
        this.saldo = this.saldo + valor;

    }

    public void saque(Double valor) {
        if (valor <= this.saldo) {
            this.saldo = this.saldo - valor;
        } else {
            throw new SaldoException("Saldo indisponivel");
        }

    }

    public Double receberTransferencia(Double valor) {
        this.saldo = this.saldo + valor;
        return this.saldo;
    }

    public Double enviarTransferencia(Double valor) {
        if (valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            return this.saldo;
        }

        return null;
    }

}
