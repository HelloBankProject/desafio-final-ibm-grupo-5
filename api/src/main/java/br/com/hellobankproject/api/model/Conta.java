package br.com.hellobankproject.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.hellobankproject.api.exception.SaldoException;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conta")
public class Conta {

    @Column(name = "id")
    @ApiModelProperty(value = "Código da conta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tipo nao informado")
    @ApiModelProperty(value = "Tipo da conta")
    @Column(name = "tipo", length = 50)
    private String tipo;

    @NotNull(message = "valor nao informado")
    @ApiModelProperty(value = "Saldo na conta")
    @Column(name = "saldo")
    private Double saldo;

    @ApiModelProperty(value = "Credito da conta")
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
