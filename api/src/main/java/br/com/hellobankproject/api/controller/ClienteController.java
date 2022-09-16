package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.service.cliente.IClienteService;
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
@Api(tags = { "Cliente" }, value = "clientes", description = "Operações relacionadas a clientes")
public class ClienteController {
    
    @Autowired
    private IClienteService service;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de clientes"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @ApiOperation(value = "Listar todos os clientes", nickname = "getCliente")
    @RequestMapping(value = "/clientes", method = RequestMethod.GET, produces="application/json")
    public List<Cliente> recuperarTodos() {
        return service.buscarTodosClientes();
    }

    @ApiOperation(value = "Listar cliente pelo ID", nickname = "getCliente")
    //@GetMapping("/clientes/{id}")
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable int id) {
        Cliente res = service.buscarPeloIdCliente(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastrar cliente", nickname = "postCliente")
    //@PostMapping("/clientes")
    @RequestMapping(value = "/clientes", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Cliente> incluirNovo(@RequestBody @Valid Cliente novo) {
        Cliente res = service.criarNovoCliente(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Atualizar cliente", nickname = "putCliente")
    //@PutMapping("/clientes")
    @RequestMapping(value = "/clientes", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Cliente> alterar(@RequestBody @Valid Cliente dados) {
        Cliente res = service.atualizarDadosCliente(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar cliente pelo ID", nickname = "deleteCliente")
    //@DeleteMapping("/clientes/{id}")
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Cliente> excluir(@PathVariable Integer id) {
        service.excluirCliente(id);
        return ResponseEntity.ok(null);
    }

}
