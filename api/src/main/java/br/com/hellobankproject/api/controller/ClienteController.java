package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.service.cliente.IClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

@RestController
@Api(tags = { "Cliente" }, value = "clientes", description = "Operações relacionadas a clientes")
public class ClienteController {
    @Autowired
    private IClienteService service;

    @ApiOperation(value = "Listar todos os clientes", nickname = "getCliente")
    @GetMapping("/clientes")
    public ArrayList<Cliente> recuperarTodos() {
        return service.buscarTodosClientes();
    }

    @ApiOperation(value = "Listar cliente pelo ID", nickname = "getCliente")
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable int id) {
        Cliente res = service.buscarPeloIdCliente(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastrar cliente", nickname = "postCliente")
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> incluirNovo(@RequestBody @Valid Cliente novo) {
        Cliente res = service.criarNovoCliente(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Atualizar cliente", nickname = "putCliente")
    @PutMapping("/clientes")
    public ResponseEntity<Cliente> alterar(@RequestBody @Valid Cliente dados) {
        Cliente res = service.atualizarDadosCliente(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar cliente pelo ID", nickname = "deleteCliente")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluir(@PathVariable Integer id) {
        service.excluirCliente(id);
        return ResponseEntity.ok(null);
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public Map<String, String>
    // handleValidationException(MethodArgumentNotValidException ex) {
    // Map<String, String> errors = new HashMap<>();

    // ex.getBindingResult().getAllErrors().forEach((error) -> {
    // String fieldName = ((FieldError) error).getField();
    // String errorMessage = error.getDefaultMessage();
    // errors.put(fieldName, errorMessage);

    // });

    // return errors;

    // }
}
