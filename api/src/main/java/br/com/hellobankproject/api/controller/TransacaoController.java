package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.transacao.ITransacaoService;
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

@RestController
@Api(tags = { "Transacão" }, value = "trasancao", description = "Operações relacionadas a Transacões")
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @ApiOperation(value = "Listar todas as transacões", nickname = "getTransacões")
    @GetMapping("/transacoes")
    public ArrayList<Transacao> recuperarTodos() {
        return service.buscarTodosTransacao();
    }

    @ApiOperation(value = "Listar transacão pelo ID", nickname = "getTransacão")
    @GetMapping("/transacoes/{id}")
    public ResponseEntity<Transacao> buscarPeloId(@PathVariable int id) {
        Transacao res = service.buscarPeloIdTransacao(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastrar uma transacão pelo ID", nickname = "postTransacão")
    @PostMapping("/transacoes")
    public ResponseEntity<Transacao> incluirNovo(@RequestBody Transacao novo) {
        Transacao res = service.criarNovoTransacao(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Atualizar uma transacão pelo ID", nickname = "putTransacão")
    @PutMapping("/transacoes")
    public ResponseEntity<Transacao> alterar(@RequestBody Transacao dados) {
        Transacao res = service.atualizarDadosTransacao(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar uma transacão pelo ID", nickname = "deleteTransacão")
    @DeleteMapping("/transacoes/{id}")
    public ResponseEntity<Transacao> excluir(@PathVariable Integer id) {
        service.excluirTransacao(id);
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
