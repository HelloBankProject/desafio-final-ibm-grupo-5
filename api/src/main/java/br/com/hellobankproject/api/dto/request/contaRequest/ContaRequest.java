package br.com.hellobankproject.api.dto.request.contaRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContaRequest {
    @NotBlank(message = "Tipo não informado")
    private String tipo;
    @NotNull(message = "Saldo não informado")
    private Double saldo;
    private Double credito;
    @NotNull(message = "Cliente não informado")
    private Integer idPrimeiroTitular;
    private Integer idSegundoTitular;

    public ContaRequest(String tipo, Double saldo, Double credito, Integer idPrimeiroTitular,
            Integer idSegundoTitular) {
        this.tipo = tipo;
        this.saldo = saldo;
        this.credito = credito;
        this.idPrimeiroTitular = idPrimeiroTitular;
        this.idSegundoTitular = idSegundoTitular;
    }

    public ContaRequest() {

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

    public Integer getIdPrimeiroTitular() {
        return idPrimeiroTitular;
    }

    public void setIdPrimeiroTitular(Integer idPrimeiroTitular) {
        this.idPrimeiroTitular = idPrimeiroTitular;
    }

    public Integer getIdSegundoTitular() {
        return idSegundoTitular;
    }

    public void setIdSegundoTitular(Integer idSegundoTitular) {
        this.idSegundoTitular = idSegundoTitular;
    }

}
