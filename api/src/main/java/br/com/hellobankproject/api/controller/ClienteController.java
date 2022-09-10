package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public ArrayList<Cliente> recuperarTodos() {
        return service.buscarTodosClientes();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable int id) {
        Cliente res = service.buscarPeloIdCliente(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> incluirNovo(@RequestBody Cliente novo) {
        Cliente res = service.criarNovoCliente(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente dados) {
        Cliente res = service.atualizarDadosCliente(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluir(@PathVariable Integer id) {
        service.excluirCliente(id);
        return ResponseEntity.ok(null);
    }
}
