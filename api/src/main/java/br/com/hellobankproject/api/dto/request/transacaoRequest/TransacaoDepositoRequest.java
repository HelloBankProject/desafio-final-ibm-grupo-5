package br.com.hellobankproject.api.dto.request.transacaoRequest;

public class TransacaoDepositoRequest {
    private Double valor;
    private String modo;
    private Integer contaId;

    public TransacaoDepositoRequest(Double valor, String modo, Integer contaId) {
        this.valor = valor;
        this.modo = modo;
        this.contaId = contaId;
    }

    public TransacaoDepositoRequest() {

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

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }

}
