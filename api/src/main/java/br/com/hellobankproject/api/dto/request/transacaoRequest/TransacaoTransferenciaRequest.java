package br.com.hellobankproject.api.dto.request.transacaoRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransacaoTransferenciaRequest {
    @NotNull(message = "Valor não informado")
    private Double valor;
    @NotBlank(message = "Modo não informado")
    private String modo;
    @NotNull(message = "Recebador não informado")
    private Integer recebedor;
    @NotNull(message = "Fornecedor não informado")
    private Integer fornecedor;

    public TransacaoTransferenciaRequest(Double valor, String modo, Integer recebedor, Integer fornecedor) {
        this.valor = valor;
        this.modo = modo;
        this.recebedor = recebedor;
        this.fornecedor = fornecedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Integer getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Integer recebedor) {
        this.recebedor = recebedor;
    }

    public Integer getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Integer fornecedor) {
        this.fornecedor = fornecedor;
    }

}
