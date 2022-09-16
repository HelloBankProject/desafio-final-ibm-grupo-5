package br.com.hellobankproject.api.dto.request.transacaoRequest;

public class TransacaoTransferenciaRequest {
    private Double valor;
    private String modo;
    private Integer recebedor;
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
