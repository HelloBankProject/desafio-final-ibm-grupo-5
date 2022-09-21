package br.com.hellobankproject.api.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ContaDAOTest {

  @Autowired
  private ClienteDAO clienteDAO;

  @Autowired
  private ContaDAO contaDAO;

  @Test
  void save_Conta_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));

    assertThat(contaSaved).isNotNull();
    assertThat(contaSaved.getPrimeiroTitular().getId()).isEqualTo(clienteSaved.getId());
  }

  @Test
  void find_AllContas_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));

    Iterable<Conta> foundAll = contaDAO.findAll();

    assertThat(contaSaved).isIn(foundAll);
    assertThat(foundAll).isNotEmpty();
  }

  @Test
  void find_Conta_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));

    Optional<Conta> foundById = contaDAO.findById(contaSaved.getId());

    assertThat(foundById).contains(contaSaved).isNotEmpty();

  }

  @Test
  void delete_Conta_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Conta contaSaved = contaDAO.save(createConta(clienteSaved));
    contaDAO.delete(contaSaved);
    Optional<Conta> foundById1 = contaDAO.findById(contaSaved.getId());
    assertThat(foundById1).isEmpty();
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
