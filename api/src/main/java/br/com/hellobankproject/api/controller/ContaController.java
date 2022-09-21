package br.com.hellobankproject.api.controller;

<<<<<<< HEAD
import br.com.hellobankproject.api.dao.ContaDAO;
=======
import br.com.hellobankproject.api.dto.mapper.ContaMapper;
import br.com.hellobankproject.api.dto.request.contaRequest.ContaRequest;
import br.com.hellobankproject.api.dto.response.contaResponse.ContaResponse;
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.conta.IContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin("http://localhost:3000")
@Api(tags = { "Conta" }, value = "conta", description = "Operações relacionadas a conta do cliente")
public class ContaController {

    @Autowired
    private IContaService service;

    private ContaDAO dao;

    @ApiOperation(value = "Listar todas as contas", nickname = "getConta")
    @GetMapping("/contas")
    public ResponseEntity<List<Conta>> recuperarTodos() {
        return ResponseEntity.ok().body(service.buscarTodasContas());
    }

    @ApiOperation(value = "Listar conta pelo ID", nickname = "getConta")
    @GetMapping("/contas/{id}")
<<<<<<< HEAD
    public ResponseEntity<Conta> buscarPeloId(@PathVariable int id) {
        Conta res = service.buscarPeloIdConta(id);
        if (res != null) {
            return ok(res);
        }
        return ResponseEntity.notFound().build();
=======
    public ResponseEntity<Conta> buscarPeloId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.buscarPeloIdConta(id));
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
    }

    @ApiOperation(value = "Cadastrar uma conta", nickname = "postConta")
    @PostMapping("/contas")
<<<<<<< HEAD
    public ResponseEntity<Conta> incluirNovo(@RequestBody @Valid Conta novo) {
        Conta res = service.criarNovoConta(novo);
        if (res != null) {
            return ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
=======
    public ResponseEntity<ContaResponse> incluirNovo(@RequestBody @Valid ContaRequest request) {
        Conta contaRequest = ContaMapper.toConta(request);
        ContaResponse response = ContaMapper.toContaResponse(service.criarNovoConta(contaRequest));
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429

        return new ResponseEntity<>(response, HttpStatus.CREATED);
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
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirConta(id);
<<<<<<< HEAD
        return ok(null);
=======
        return ResponseEntity.ok().build();
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429
    }

}
