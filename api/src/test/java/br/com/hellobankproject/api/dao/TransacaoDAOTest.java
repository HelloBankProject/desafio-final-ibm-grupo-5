package br.com.hellobankproject.api.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.model.Transacao;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TransacaoDAOTest {

  @Autowired
  private TransacaoDAO transacaoDAO;
  @Autowired
  private ContaDAO contaDAO;
  @Autowired
  private ClienteDAO clienteDAO;

  @Test
  void save_Transacao_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));
    Transacao transacaoSaved = transacaoDAO.save(createTransacao(contaSaved, contaSaved, "Deposito"));

    assertThat(transacaoSaved.getId()).isNotNull();
    assertThat(transacaoSaved.getRecebedor()).isEqualTo(contaSaved);
    assertThat(transacaoSaved).isNotNull();
  }

  @Test
  void find_AllTransacao_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));
    Transacao transacaoSaved = transacaoDAO.save(createTransacao(contaSaved, contaSaved, "Deposito"));

    Iterable<Transacao> foundAll = transacaoDAO.findAll();
    assertThat(foundAll).isNotEmpty();
    assertThat(transacaoSaved).isIn(foundAll);
  }

  @Test
  void find_TransacaoById_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));
    Transacao transacaoSaved = transacaoDAO.save(createTransacao(contaSaved, contaSaved, "Deposito"));

    Optional<Transacao> foundById = transacaoDAO.findById(transacaoSaved.getId());
    assertThat(foundById).contains(transacaoSaved).isNotEmpty();

  }

  public Transacao createTransacao(Conta fornecedor, Conta recebedor, String modo) {
    Transacao transacao = new Transacao();
    transacao.setValor(200.0);
    transacao.setData(LocalDateTime.now());
    transacao.setModo(modo);
    transacao.setRecebedor(recebedor);
    transacao.setFornecedor(fornecedor);
    return transacao;
  }

  public Conta createConta(Cliente cliente) {
    Conta conta = new Conta();
    conta.setTipo("corrente");
    conta.setSaldo(2000.0);
    conta.setPrimeiroTitular(cliente);
    return conta;
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
}
