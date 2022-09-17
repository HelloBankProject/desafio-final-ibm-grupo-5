package br.com.hellobankproject.api.dto.mapper;

import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoDepositoRequest;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoSaqueRequest;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoTransferenciaRequest;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoDepositoResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoSaqueResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoTransferenciaResponse;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.model.Transacao;

public class TransacaoMapper {

    // RESPONSE DO GET POR ID DA TRANSACAO
    public static TransacaoResponse toTransacaoResponse(Transacao transacao) {
        TransacaoResponse response = new TransacaoResponse();
        response.setId(transacao.getId());
        response.setValor(transacao.getValor());
        response.setData(transacao.getData());
        response.setModo(transacao.getModo());
        response.setRecebedor(transacao.getRecebedor().getId());
        response.setFornecedor(transacao.getFornecedor().getId());

        return response;
    }

    // PARSER DO RESQUEST DA TRANSFERENCIA PARA TRANSACAO
    public static Transacao toTransacaoTransferencia(TransacaoTransferenciaRequest request) {
        Conta recebedor = new Conta();
        Conta fornecedor = new Conta();
        recebedor.setId(request.getRecebedor());
        fornecedor.setId(request.getFornecedor());

        Transacao transacao = new Transacao();
        transacao.setValor(request.getValor());
        transacao.setModo(request.getModo());
        transacao.setRecebedor(recebedor);
        transacao.setFornecedor(fornecedor);

        return transacao;
    }

    // RESPONSE DO POST DA TRANSACAO
    public static TransacaoTransferenciaResponse toTransacaoTransferenciaResponse(Transacao transacao) {
        TransacaoTransferenciaResponse response = new TransacaoTransferenciaResponse();
        response.setId(transacao.getId());
        response.setValor(transacao.getValor());
        response.setData(transacao.getData());
        response.setModo(transacao.getModo());
        response.setRecebedor(transacao.getRecebedor().getId());
        response.setFornecedor(transacao.getFornecedor().getId());

        return response;
    }

    // PARSER DO RESQUEST DO DEPOSITO
    public static Transacao toTransacaoDeposito(TransacaoDepositoRequest request) {
        Conta recebedor = new Conta();
        Conta fornecedor = new Conta();
        recebedor.setId(request.getContaId());
        fornecedor.setId(request.getContaId());

        Transacao transacao = new Transacao();
        transacao.setValor(request.getValor());
        transacao.setModo(request.getModo());
        transacao.setRecebedor(recebedor);
        transacao.setFornecedor(fornecedor);

        return transacao;
    }

    // RESPONSE DO POST DO DEPOSITO
    public static TransacaoDepositoResponse toTransacaoDepositoResponse(Transacao transacao) {
        TransacaoDepositoResponse response = new TransacaoDepositoResponse();
        response.setId(transacao.getId());
        response.setValor(transacao.getValor());
        response.setData(transacao.getData());
        response.setModo(transacao.getModo());
        response.setContaId(transacao.getRecebedor().getId());

        return response;
    }

    // PARSER DO RESQUEST DO SAQUE PARA TRANSACAO
    public static Transacao toTransacaoSaque(TransacaoSaqueRequest request) {
        Conta recebedor = new Conta();
        Conta fornecedor = new Conta();
        recebedor.setId(request.getContaId());
        fornecedor.setId(request.getContaId());

        Transacao transacao = new Transacao();
        transacao.setValor(request.getValor());
        transacao.setModo(request.getModo());
        transacao.setRecebedor(recebedor);
        transacao.setFornecedor(fornecedor);

        return transacao;
    }

    public static TransacaoSaqueResponse toTransacaoSaqueResponse(Transacao transacao) {
        TransacaoSaqueResponse response = new TransacaoSaqueResponse();
        response.setId(transacao.getId());
        response.setValor(transacao.getValor());
        response.setData(transacao.getData());
        response.setModo(transacao.getModo());
        response.setContaId(transacao.getFornecedor().getId());

        return response;
    }

}
