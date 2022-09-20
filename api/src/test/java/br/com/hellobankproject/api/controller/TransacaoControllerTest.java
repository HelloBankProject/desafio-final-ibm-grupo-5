package br.com.hellobankproject.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.transacao.ITransacao;

@WebMvcTest(TransacaoController.class)
public class TransacaoControllerTest {

  @MockBean
  private ITransacao iTransacao;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void buscarPeloId_ShouldReturnTransacao_WhenSuccessful() throws Exception {
    Conta conta = createConta(createCliente());
    when(iTransacao.buscarPeloIdTransacao(anyInt())).thenReturn(createTransacao(conta, conta, "Deposito"));

    mockMvc.perform(get("/transacoes/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.valor").value(200.0));
  }

  @Test
  void recuperarTodos_ShouldReturnAListOfTransacao() throws Exception {
    Conta conta = createConta(createCliente());
    when(iTransacao.buscarTodosTransacao()).thenReturn(List.of(createTransacao(conta, conta, "Deposito")));

    mockMvc.perform(get("/transacoes"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].recebedor").value(1));
  }

  @Test
  void deposito_ShouldReturnTransacao_WhenSuccessful() throws Exception {
    Conta conta = createConta(createCliente());
    when(iTransacao.criarNovoDeposito(any(Transacao.class))).thenReturn(createTransacao(conta, conta, "Deposito"));

    mockMvc.perform(post("/transacoes/deposito")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
              {
                "valor": 200.0,
                "modo": "deposito",
                "contaId": 1
              }
            """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.valor").value(200.0))
        .andExpect(jsonPath("$.modo").value("Deposito"));
  }

  @Test
  void saque_ShouldReturnTransacao_WhenSuccessful() throws Exception {
    Conta conta = createConta(createCliente());
    when(iTransacao.criarNovoSaque(any(Transacao.class))).thenReturn(createTransacao(conta, conta, "Saque"));

    mockMvc.perform(post("/transacoes/saque")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
              {
                "valor": 200.0,
                "modo": "deposito",
                "contaId": 1
              }
            """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.valor").value(200.0))
        .andExpect(jsonPath("$.modo").value("Saque"));
  }

  @Test
  void ttransferencia_ShouldREturnTransacao_WhenSuccessful() throws Exception {
    Conta conta2 = createConta(createCliente());
    conta2.setId(2);
    when(iTransacao.criarNovoTransferencia(any(Transacao.class)))
        .thenReturn(createTransacao(createConta(createCliente()), conta2, "Saque"));

    mockMvc.perform(post("/transacoes/transferencia")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
              "valor": 200.0,
              "modo": "pix",
              "recebedor": 2,
              "fornecedor": 1
            }
            """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.recebedor").value(2))
        .andExpect(jsonPath("$.fornecedor").value(1))
        .andExpect(jsonPath("$.id").value(1));
  }

  public Transacao createTransacao(Conta fornecedor, Conta recebedor, String modo) {
    Transacao transacao = new Transacao();
    transacao.setId(1);
    transacao.setValor(200.0);
    transacao.setData(LocalDateTime.now());
    transacao.setModo(modo);
    transacao.setRecebedor(recebedor);
    transacao.setFornecedor(fornecedor);
    return transacao;
  }

  public Conta createConta(Cliente cliente) {
    Conta conta = new Conta();
    conta.setId(1);
    conta.setTipo("corrente");
    conta.setSaldo(2000.0);
    conta.setPrimeiroTitular(cliente);
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
