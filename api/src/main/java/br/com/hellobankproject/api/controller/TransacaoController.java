package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.dto.mapper.TransacaoMapper;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoDepositoRequest;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoSaqueRequest;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoTransferenciaRequest;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoDepositoResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoSaqueResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoTransferenciaResponse;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.conta.IContaService;
import br.com.hellobankproject.api.service.transacao.ITransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@Api(tags = { "Transacão" }, value = "trasancao", description = "Operações relacionadas a Transacões")
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @ApiOperation(value = "Listar todas as transacões", nickname = "getTransacões")
    @GetMapping("/transacoes")
    public List<Transacao> recuperarTodos() {
        return service.buscarTodosTransacao();
    }

    @ApiOperation(value = "Listar transacão pelo ID", nickname = "getTransacão")
    @GetMapping("/transacoes/{id}")
    public ResponseEntity<TransacaoResponse> buscarPeloId(@PathVariable int id) {
        Transacao transacao = service.buscarPeloIdTransacao(id);

        if (transacao != null) {
            TransacaoResponse response = TransacaoMapper.toTransacaoResponse(transacao);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Fazer uma nova transferencia e registra-la", nickname = "postTransferencia")
    @PostMapping("/transacoes/transferencia")
    public ResponseEntity<TransacaoTransferenciaResponse> transferencia(
            @RequestBody @Valid TransacaoTransferenciaRequest request) {

        Transacao transferenciaResquest = TransacaoMapper.toTransacaoTransferencia(request);
        Transacao transacao = service.criarNovoTransferencia(transferenciaResquest);

        if (transacao != null) {
            TransacaoTransferenciaResponse response = TransacaoMapper
                    .toTransacaoTransferenciaResponse(transacao);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Fazer uma novo deposito e registra-la", nickname = "postDeposito")
    @PostMapping("/transacoes/deposito")
    public ResponseEntity<TransacaoDepositoResponse> deposito(@RequestBody @Valid TransacaoDepositoRequest request) {

        Transacao depositoRequest = TransacaoMapper.toTransacaoDeposito(request);
        Transacao transacao = service.criarNovoDeposito(depositoRequest);

        if (transacao != null) {
            TransacaoDepositoResponse response = TransacaoMapper.toTransacaoDepositoResponse(transacao);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Fazer uma novo saque e registra-la", nickname = "postSaque")
    @PostMapping("/transacoes/saque")
    public ResponseEntity<TransacaoSaqueResponse> deposito(@RequestBody @Valid TransacaoSaqueRequest request) {

        Transacao saqueRequest = TransacaoMapper.toTransacaoSaque(request);
        Transacao transacao = service.criarNovoSaque(saqueRequest);

        if (transacao != null) {
            TransacaoSaqueResponse response = TransacaoMapper.toTransacaoSaqueResponse(transacao);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }

}
