package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.service.cliente.IClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@Api(tags = { "Cliente" }, value = "clientes", description = "Operações relacionadas a clientes")
public class ClienteController {
    @Autowired
    private IClienteService service;

    @ApiOperation(value = "Listar todos os clientes", nickname = "getCliente")
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> recuperarTodos() {
        return ResponseEntity.ok().body(service.buscarTodosClientes());
    }

    @ApiOperation(value = "Listar cliente pelo ID", nickname = "getCliente")
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable int id) {
        return ResponseEntity.ok().body(service.buscarPeloIdCliente(id));
    }

    @ApiOperation(value = "Cadastrar cliente", nickname = "postCliente")
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> incluirNovo(@RequestBody @Valid Cliente novo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarNovoCliente(novo));

    }

    @ApiOperation(value = "Atualizar cliente", nickname = "putCliente")
    @PutMapping("/clientes")
    public ResponseEntity<Cliente> alterar(@RequestBody @Valid Cliente dados) {
        return ResponseEntity.ok().body(service.atualizarDadosCliente(dados));
    }

    @ApiOperation(value = "Deletar cliente pelo ID", nickname = "deleteCliente")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirCliente(id);
        return ResponseEntity.ok().build();
    }

}
