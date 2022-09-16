package br.com.hellobankproject.api.controller;

import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.conta.IContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
@Api(tags = { "Conta" }, value = "conta", description = "Operações relacionadas a conta do cliente")
public class ContaController {

    @Autowired
    private IContaService service;

    @ApiOperation(value = "Listar todas as contas", nickname = "getConta")
    @GetMapping("/contas")
    public List<Conta> recuperarTodos() {
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
    public ResponseEntity<Conta> incluirNovo(@RequestBody @Valid Conta novo) {
        Conta res = service.criarNovoConta(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Atualizar conta pelo ID", nickname = "putConta")
    @PutMapping("/contas")
    public ResponseEntity<Conta> alterar(@RequestBody @Valid Conta dados) {
        Conta res = service.atualizarDadosConta(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    /*
    *@PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
    * */
    @ApiOperation(value = "Deletar conta pelo ID", nickname = "deleteConta")
    @DeleteMapping("/contas/{id}")
    public ResponseEntity<Conta> excluir(@PathVariable Integer id) {
        service.excluirConta(id);
        return ResponseEntity.ok(null);
    }

}
