package br.com.hellobankproject.api.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.hellobankproject.api.model.Cliente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClienteDAOTest {

  @Autowired
  private ClienteDAO clienteDAO;

  @Test
  void find_UserByCpf_WhenSuccessful() {
    Cliente result = clienteDAO.findByCpf("174.774.077-29").get();
    assertThat(result).isNotNull();
    assertThat(result.getCpf()).isEqualTo("174.774.077-29");
  }

  @Test
  void save_User_WhenSuccessful() {
    Cliente clienteToBeSaved = createCliente();
    Cliente result = clienteDAO.save(clienteToBeSaved);

    assertThat(clienteToBeSaved).hasSameClassAs(result);
    assertThat(result.getId()).isNotNull();
    assertThat(result.getNome()).isEqualTo(clienteToBeSaved.getNome());
  }

  @Test
  void find_UserById_WheSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Optional<Cliente> foundCliente = clienteDAO.findById(clienteSaved.getId());

    assertThat(foundCliente.get()).hasSameClassAs(clienteSaved);
    assertThat(foundCliente).isNotEmpty();
    assertThat(foundCliente.get().getId()).isEqualTo(clienteSaved.getId());
  }

  @Test
  void find_AllUsers_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    Iterable<Cliente> foundAll = clienteDAO.findAll();

    assertThat(clienteSaved).isIn(foundAll);
    assertThat(foundAll).isNotEmpty().isNotNull();
  }

  @Test
  void delete_User_WhenSuccessful() {
    Cliente clienteSaved = clienteDAO.save(createCliente());
    clienteDAO.delete(clienteSaved);
    Optional<Cliente> foundById = clienteDAO.findById(clienteSaved.getId());

    assertThat(foundById).isEmpty();
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
