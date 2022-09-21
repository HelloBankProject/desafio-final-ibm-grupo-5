package br.com.hellobankproject.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Transacao")
public class Transacao {
    @ApiModelProperty(value = "Código da transação")
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo nao informado")
    @ApiModelProperty(value = "Valor da transação")
    @Column(name = "valor")
    private Double valor;

    @NotBlank(message = "Campo nao informado")
    @ApiModelProperty(value = "Data da transação")
    @Column(name = "data_transacao")
    private LocalDateTime data = LocalDateTime.now();

    @NotBlank(message = "Campo nao informado")
    @ApiModelProperty(value = "Mode de envio")
    @Column(name = "modo_envio", length = 50)
    private String modo;

    @ManyToOne
    @JoinColumn(name = "id_recebedor")
    @JsonIgnoreProperties({ "primeiroTitular", "segundoTitular", "tipo" })
    private Conta recebedor;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    @JsonIgnoreProperties({ "primeiroTitular", "segundoTitular", "tipo" })
    private Conta fornecedor;

    public Conta getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Conta recebedor) {
        this.recebedor = recebedor;
    }

    public Conta getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Conta fornecedor) {
        this.fornecedor = fornecedor;
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
        Transacao other = (Transacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
