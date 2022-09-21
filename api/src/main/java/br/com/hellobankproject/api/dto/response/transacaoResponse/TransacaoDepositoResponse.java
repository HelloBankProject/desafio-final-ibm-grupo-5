package br.com.hellobankproject.api.dto.response.transacaoResponse;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransacaoDepositoResponse {
    private Integer id;
    private Double valor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime data;
    private String modo;
    private Integer contaId;

    public TransacaoDepositoResponse(Integer id, Double valor, LocalDateTime data, String modo, Integer contaId) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.modo = modo;
        this.contaId = contaId;
    }

    public TransacaoDepositoResponse() {

    }

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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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
