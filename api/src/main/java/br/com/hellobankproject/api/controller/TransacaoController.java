package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.transacao.ITransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = { "Transacão" }, value = "trasancao", description = "Operações relacionadas a Transacões")
public class TransacaoController {
    
    @Autowired
    private ITransacaoService service;

    @ApiResponses(value ={
        @ApiResponse(code = 200, message = "Retorna a lista de transacões"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Retorna a lista de contato"),
    })

    @ApiOperation(value = "Listar todas as transacões", nickname = "getTransacões")
    //@GetMapping("/transacoes")
    @RequestMapping(value = "/transacoes", method = RequestMethod.GET, produces="application/json")
    public List<Transacao> recuperarTodos() {
        return service.buscarTodosTransacao();
    }

    @ApiOperation(value = "Listar transacão pelo ID", nickname = "getTransacão")
    //@GetMapping("/transacoes/{id}")
    @RequestMapping(value = "/transacoes/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Transacao> buscarPeloId(@PathVariable int id) {
        Transacao res = service.buscarPeloIdTransacao(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastrar uma transacão pelo ID", nickname = "postTransacão")
    //@PostMapping("/transacoes")
    @RequestMapping(value = "/transacoes", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Transacao> incluirNovo(@RequestBody Transacao novo) {
        Transacao res = service.criarNovoTransacao(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Atualizar uma transacão pelo ID", nickname = "putTransacão")
    //@PutMapping("/transacoes")
    @RequestMapping(value = "/transacoes", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Transacao> alterar(@RequestBody Transacao dados) {
        Transacao res = service.atualizarDadosTransacao(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar uma transacão pelo ID", nickname = "deleteTransacão")
    //@DeleteMapping("/transacoes/{id}")
    @RequestMapping(value = "/transacoes/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Transacao> excluir(@PathVariable Integer id) {
        service.excluirTransacao(id);
        return ResponseEntity.ok(null);
    }

}
