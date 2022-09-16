package br.com.hellobankproject.api.dto.response.transacaoResponse;

import java.util.Date;

public class TransacaoResponse {
    private Integer id;
    private Double valor;
    private Date data;
    private String modo;
    private Integer recebedor;
    private Integer fornecedor;

    public TransacaoResponse(Integer id, Double valor, Date data, String modo, Integer recebedor, Integer fornecedor) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.modo = modo;
        this.recebedor = recebedor;
        this.fornecedor = fornecedor;
    }

    public TransacaoResponse() {

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
