package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.conta.IContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@Api(tags = { "Conta" }, value = "conta", description = "Operações relacionadas a conta do cliente")
public class ContaController {

    @Autowired
    private IContaService service;

    @ApiResponses(value ={
        @ApiResponse(code = 200, message = "Retorna a lista de contatos"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Retorna a lista de contato"),
    })

    @ApiOperation(value = "Listar todas as contas", nickname = "getConta")
    //@GetMapping("/contas")
    @RequestMapping(value = "/contas", method = RequestMethod.GET, produces="application/json")
    public List<Conta> recuperarTodos() {
        return service.buscarTodasContas();
    }

    @ApiOperation(value = "Listar conta pelo ID", nickname = "getConta")
    //@GetMapping("/contas/{id}")
    @RequestMapping(value = "/contas/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Conta> buscarPeloId(@PathVariable int id) {
        Conta res = service.buscarPeloIdConta(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastrar uma conta", nickname = "postConta")
    //@PostMapping("/contas")
    @RequestMapping(value = "/contas", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Conta> incluirNovo(@RequestBody @Valid Conta novo) {
        Conta res = service.criarNovoConta(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Atualizar conta pelo ID", nickname = "putConta")
    //@PutMapping("/contas")
    @RequestMapping(value = "/contas", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Conta> alterar(@RequestBody @Valid Conta dados) {
        Conta res = service.atualizarDadosConta(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar conta pelo ID", nickname = "deleteConta")
    //@DeleteMapping("/contas/{id}")
    @RequestMapping(value = "/contas/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Conta> excluir(@PathVariable Integer id) {
        service.excluirConta(id);
        return ResponseEntity.ok(null);
    }

}
