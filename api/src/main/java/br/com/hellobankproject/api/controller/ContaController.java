package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.dto.mapper.ContaMapper;
import br.com.hellobankproject.api.dto.request.contaRequest.ContaRequest;
import br.com.hellobankproject.api.dto.response.contaResponse.ContaResponse;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.conta.IContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import javax.validation.Valid;

@RestController
@Api(tags = { "Conta" }, value = "conta", description = "Operações relacionadas a conta do cliente")
public class ContaController {

    @Autowired
    private IContaService service;

    @ApiOperation(value = "Listar todas as contas", nickname = "getConta")
    @GetMapping("/contas")
    public ArrayList<Conta> recuperarTodos() {
        return service.buscarTodasContas();
    }

    @ApiOperation(value = "Listar conta pelo ID", nickname = "getConta")
    @GetMapping("/contas/{id}")
    public ResponseEntity<Conta> buscarPeloId(@PathVariable int id) {
        Conta res = service.buscarPeloIdConta(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cadastrar uma conta", nickname = "postConta")
    @PostMapping("/contas")
    public ResponseEntity<ContaResponse> incluirNovo(@RequestBody @Valid ContaRequest request) {
        Conta contaRequest = ContaMapper.toConta(request);
        Conta conta = service.criarNovoConta(contaRequest);

        if (conta != null) {

            ContaResponse response = ContaMapper.toContaResponse(conta);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar conta pelo ID", nickname = "deleteConta")
    @DeleteMapping("/contas/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirConta(id);
        return ResponseEntity.ok().build();
    }

}
