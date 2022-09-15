package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.dto.mapper.TransacaoMapper;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoDepositoRequest;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoSaqueRequest;
import br.com.hellobankproject.api.dto.request.transacaoRequest.TransacaoTransferenciaRequest;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoDepositoResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoSaqueResponse;
import br.com.hellobankproject.api.dto.response.transacaoResponse.TransacaoTransferenciaResponse;
import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.transacao.ITransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;<<<<<<<HEAD
import java.util.stream.Collectors;

import javax.validation.Valid;=======>>>>>>>ce91f81(fix dependencias)

@RestController
@Api(tags = { "Transacão" }, value = "trasancao", description = "Operações relacionadas a Transacões")
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @ApiOperation(value = "Listar todas as transacões", nickname = "getTransacões")
    @GetMapping("/transacoes")
<<<<<<< HEAD
    public List<TransacaoResponse> recuperarTodos() {
        return service.buscarTodosTransacao().stream().map(TransacaoMapper::toTransacaoResponse)
                .collect(Collectors.toList());
=======
    public ResponseEntity<List<Transacao>> recuperarTodos() {
        return ResponseEntity.ok().body(service.buscarTodosTransacao());
>>>>>>> a630457 (add transacao exceptions)
    }

    @ApiOperation(value = "Listar transacão pelo ID", nickname = "getTransacão")
    @GetMapping("/transacoes/{id}")
<<<<<<< HEAD
    public ResponseEntity<TransacaoResponse> buscarPeloId(@PathVariable int id) {

        Transacao transacao = service.buscarPeloIdTransacao(id);
        TransacaoResponse response = TransacaoMapper.toTransacaoResponse(transacao);
        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "Fazer uma nova transferencia e registra-la", nickname = "postTransferencia")
    @PostMapping("/transacoes/transferencia")
    public ResponseEntity<TransacaoTransferenciaResponse> transferencia(
            @RequestBody @Valid TransacaoTransferenciaRequest request) {

        Transacao transferenciaResquest = TransacaoMapper.toTransacaoTransferencia(request);
        TransacaoTransferenciaResponse response = TransacaoMapper
                .toTransacaoTransferenciaResponse(service.criarNovoTransferencia(transferenciaResquest));
        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "Fazer uma novo deposito e registra-la", nickname = "postDeposito")
    @PostMapping("/transacoes/deposito")
    public ResponseEntity<TransacaoDepositoResponse> deposito(@RequestBody @Valid TransacaoDepositoRequest request) {

        Transacao depositoRequest = TransacaoMapper.toTransacaoDeposito(request);
        TransacaoDepositoResponse response = TransacaoMapper
                .toTransacaoDepositoResponse(service.criarNovoDeposito(depositoRequest));

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "Fazer uma novo saque e registra-la", nickname = "postSaque")
    @PostMapping("/transacoes/saque")
    public ResponseEntity<TransacaoSaqueResponse> saque(@RequestBody @Valid TransacaoSaqueRequest request) {

        Transacao saqueRequest = TransacaoMapper.toTransacaoSaque(request);
        TransacaoSaqueResponse response = TransacaoMapper
                .toTransacaoSaqueResponse(service.criarNovoSaque(saqueRequest));
        return ResponseEntity.ok().body(response);
=======
    public ResponseEntity<Transacao> buscarPeloId(@PathVariable int id) {

        return ResponseEntity.ok().body(service.buscarPeloIdTransacao(id));
    }

    @ApiOperation(value = "Cadastrar uma transacão pelo ID", nickname = "postTransacão")
    @PostMapping("/transacoes")
    public ResponseEntity<Transacao> incluirNovo(@RequestBody Transacao novo) {

        return new ResponseEntity<>(service.criarNovoTransacao(novo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualizar uma transacão pelo ID", nickname = "putTransacão")
    @PutMapping("/transacoes")
    public ResponseEntity<Transacao> alterar(@RequestBody Transacao dados) {

        return ResponseEntity.ok().body(service.atualizarDadosTransacao(dados));
    }

    @ApiOperation(value = "Deletar uma transacão pelo ID", nickname = "deleteTransacão")
    @DeleteMapping("/transacoes/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirTransacao(id);
        return ResponseEntity.ok(null);
>>>>>>> a630457 (add transacao exceptions)
    }

}
