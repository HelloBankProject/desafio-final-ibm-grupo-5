package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.transacao.ITransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = { "Transacão" }, value = "trasancao", description = "Operações relacionadas a Transacões")
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @ApiOperation(value = "Listar todas as transacões", nickname = "getTransacões")
    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> recuperarTodos() {
        return ResponseEntity.ok().body(service.buscarTodosTransacao());
    }

    @ApiOperation(value = "Listar transacão pelo ID", nickname = "getTransacão")
    @GetMapping("/transacoes/{id}")
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
    }

}
