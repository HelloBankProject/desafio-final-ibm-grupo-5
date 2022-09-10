package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.conta.IContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContaController {
    @Autowired
    private IContaService service;

    @GetMapping("/contas")
    public ArrayList<Conta> recuperarTodos() {
        return service.buscarTodasContas();
    }

    @GetMapping("/contas/{id}")
    public ResponseEntity<Conta> buscarPeloId(@PathVariable int id) {
        Conta res = service.buscarPeloIdConta(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/contas")
    public ResponseEntity<Conta> incluirNovo(@RequestBody Conta novo) {
        Conta res = service.criarNovoConta(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/contas")
    public ResponseEntity<Conta> alterar(@RequestBody Conta dados) {
        Conta res = service.atualizarDadosConta(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/contas/{id}")
    public ResponseEntity<Conta> excluir(@PathVariable Integer id) {
        service.excluirConta(id);
        return ResponseEntity.ok(null);
    }
}
