package br.com.hellobankproject.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.conta.IConta;

@WebMvcTest(ContaController.class)
public class ContaControllerTest {

  @MockBean
  private IConta iConta;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testIncluirNovo() throws Exception {
    when(iConta.criarNovoConta(any(Conta.class))).thenReturn(createConta());

    mockMvc.perform(post("/contas")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
              "tipo": "corrente",
              "saldo": 2000.0,
              "credito": 0,
              "idPrimeiroTitular": 1,
              "idSegundoTitular": null
            }
            """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.saldo").value(2000.0));

  }

  @Test
  void buscarPeloId_ShouldReturnCliente_WhenSuccessful() throws Exception {
    when(iConta.buscarPeloIdConta(anyInt())).thenReturn(createConta());

    mockMvc.perform(get("/contas/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.tipo").value("corrente"));

  }

  @Test
  void recuperarTodos_ShouldReturnAListOfCliente_WhenSuccessful() throws Exception {
    when(iConta.buscarTodasContas()).thenReturn(List.of(createConta()));
    mockMvc.perform(get("/contas"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].credito").value(0.0));
  }

  @Test
  void testExcluir() throws Exception {
    doNothing().when(iConta).excluirConta(anyInt());
    mockMvc.perform(delete("/contas/1"))
        .andExpect(status().isOk());

  }

  public Conta createConta() {
    Conta conta = new Conta();
    conta.setId(1);
    conta.setTipo("corrente");
    conta.setSaldo(2000.0);
    conta.setCredito(0.0);
    conta.setPrimeiroTitular(createCliente());
    return conta;
  }

  public Cliente createCliente() {
    Cliente cliente = new Cliente();
    cliente.setId(1);
    cliente.setCpf("45363363038");
    cliente.setNome("Andre Silva de Oliveira");
    cliente.setEmail("Andre@email.com");
    cliente.setEndereco("Rua da campo");
    cliente.setCidade("Rio de janeiro");
    cliente.setBairro("Itanhangá");
    cliente.setEstado("Rio de janeiro");
    cliente.setSenha("An231@_311aa");
    cliente.setTelefone("123456789");
    return cliente;
  }
}
