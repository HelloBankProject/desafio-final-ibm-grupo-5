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
import br.com.hellobankproject.api.service.cliente.ICliente;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

  @MockBean
  private ICliente iCliente;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void IncluirNovo_ShouldReturnCliente_WhenSuccessful() throws Exception {
    when(iCliente.criarNovoCliente(any(Cliente.class))).thenReturn(createClienteSaved());
    mockMvc.perform(post("/clientes").contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
              "cpf": "45363363038",
              "nome": "Andre Silva de Oliveira",
              "email": "Andre@email.com",
              "senha": "An231@_311aa",
              "endereco": "Rua da campo",
              "estado": "Rio de Janeiro",
              "cidade": "Teste Teste",
              "bairro": "Teste Teste",
              "complemento": "Casa",
              "telefone": "123456789"
            }
                """)).andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.cpf").value("45363363038"));
  }

  @Test
  void recuperarTodos_ShouldReturnAListOfCliente_WhenSuccessful() throws Exception {
    when(iCliente.buscarTodosClientes()).thenReturn(List.of(createClienteSaved()));
    mockMvc.perform(get("/clientes"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("[0].nome").value("Andre Silva de Oliveira"));
  }

  @Test
  void buscarPeloId_ShouldReturnCliente_WhenSuccessful() throws Exception {
    when(iCliente.buscarPeloIdCliente(anyInt())).thenReturn(createClienteSaved());
    mockMvc.perform(get("/clientes/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.telefone").value("123456789"));
  }

  @Test
  void excluir_ShouldRemoveCliente_WhenSuccessful() throws Exception {
    doNothing().when(iCliente).excluirCliente(anyInt());
    mockMvc.perform(delete("/clientes/1"))
        .andExpect(status().isOk());
  }

  public Cliente createCliente() {
    Cliente cliente = new Cliente();
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

  public Cliente createClienteSaved() {
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
