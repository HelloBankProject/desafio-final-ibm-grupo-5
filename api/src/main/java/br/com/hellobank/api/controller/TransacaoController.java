package br.com.hellobank.api.controller;

import br.com.hellobank.api.model.Transacao;
import br.com.hellobank.api.service.transacao.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @GetMapping("/transacoes")
    public ArrayList<Transacao> recuperarTodos() {
        return service.buscarTodosTransacao();
    }

    @GetMapping("/transacoes/{id}")
    public ResponseEntity<Transacao> buscarPeloId(@PathVariable int id) {
        Transacao res = service.buscarPeloIdTransacao(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/transacoes")
    public ResponseEntity<Transacao> incluirNovo(@RequestBody Transacao novo) {
        Transacao res = service.criarNovoTransacao(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/transacoes")
    public ResponseEntity<Transacao> alterar(@RequestBody Transacao dados) {
        Transacao res = service.atualizarDadosTransacao(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/transacoes/{id}")
    public ResponseEntity<Transacao> excluir(@PathVariable Integer id) {
        service.excluirTransacao(id);
        return ResponseEntity.ok(null);
    }
}
