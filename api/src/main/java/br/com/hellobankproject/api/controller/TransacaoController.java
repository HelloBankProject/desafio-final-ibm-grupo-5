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

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
@Api(tags = { "Transacão" }, value = "trasancao", description = "Operações relacionadas a Transacões")
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @ApiOperation(value = "Listar todas as transacões", nickname = "getTransacões")
    @GetMapping("/transacoes")
    public List<TransacaoResponse> recuperarTodos() {
        return service.buscarTodosTransacao().stream().map(TransacaoMapper::toTransacaoResponse)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Listar transacão pelo ID", nickname = "getTransacão")
    @GetMapping("/transacoes/{id}")
    public ResponseEntity<TransacaoResponse> buscarPeloId(@PathVariable Integer id) {

        Transacao transacao = service.buscarPeloIdTransacao(id);
        TransacaoResponse response = TransacaoMapper.toTransacaoResponse(transacao);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Fazer uma nova transferencia e registra-la", nickname = "postTransferencia")
    @PostMapping("/transacoes/transferencia")
    public ResponseEntity<TransacaoTransferenciaResponse> transferencia(
            @RequestBody @Valid TransacaoTransferenciaRequest request) {

        Transacao transferenciaResquest = TransacaoMapper.toTransacaoTransferencia(request);
        TransacaoTransferenciaResponse response = TransacaoMapper
                .toTransacaoTransferenciaResponse(service.criarNovoTransferencia(transferenciaResquest));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Fazer uma novo deposito e registra-la", nickname = "postDeposito")
    @PostMapping("/transacoes/deposito")
    public ResponseEntity<TransacaoDepositoResponse> deposito(@RequestBody @Valid TransacaoDepositoRequest request) {

        Transacao depositoRequest = TransacaoMapper.toTransacaoDeposito(request);
        TransacaoDepositoResponse response = TransacaoMapper
                .toTransacaoDepositoResponse(service.criarNovoDeposito(depositoRequest));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Fazer uma novo saque e registra-la", nickname = "postSaque")
    @PostMapping("/transacoes/saque")
    public ResponseEntity<TransacaoSaqueResponse> saque(@RequestBody @Valid TransacaoSaqueRequest request) {

        Transacao saqueRequest = TransacaoMapper.toTransacaoSaque(request);
        TransacaoSaqueResponse response = TransacaoMapper
                .toTransacaoSaqueResponse(service.criarNovoSaque(saqueRequest));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
