package br.com.hellobankproject.api.service.cliente;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.hellobankproject.api.dao.ClienteDAO;
import br.com.hellobankproject.api.exception.AlreadyCreatedException;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Cliente;

@ExtendWith(MockitoExtension.class)
public class IClienteTest {

  @Mock
  private ClienteDAO clienteDAO;

  @InjectMocks
  private ICliente iCliente;

  @Test
  void createCliente_ShouldReturnsCliente_WhenSuccessful() {
    when(clienteDAO.save(any(Cliente.class))).thenReturn(createCliente());
    Cliente clienteSaved = iCliente.criarNovoCliente(createCliente());

    assertThat(clienteSaved).isEqualTo(createCliente()).isNotNull();
  }

  @Test
  void createCliente_ShouldThrowAlreadyCreatedException() {
    when(clienteDAO.findByCpf(anyString())).thenReturn(Optional.of(createCliente()));
    Cliente cliente = createCliente();

    assertThrows(AlreadyCreatedException.class, () -> iCliente.criarNovoCliente(cliente));
  }

  @Test
  void buscarPeloIdCliente_ShouldReturnsCliente_WhenSuccessful() {
    when(clienteDAO.findById(anyInt())).thenReturn(Optional.of(createCliente()));
    Cliente clienteSaved = iCliente.buscarPeloIdCliente(1);

    assertThat(clienteSaved).isEqualTo(createCliente()).isNotNull();
  }

  @Test
  void buscarPeloIdCliente_ShouldThrowNotFoundException() {
    when(clienteDAO.findById(anyInt())).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> iCliente.buscarPeloIdCliente(1));
  }

  @Test
  void buscarTodosClientes_ShouldReturnsAListOfClientes_WhenSuccessful() {
    when(clienteDAO.findAll()).thenReturn((List.of(createCliente())));
    List<Cliente> foundAll = iCliente.buscarTodosClientes();

    assertThat(foundAll).isNotEmpty().isNotNull();
    assertThat(createCliente()).isIn(foundAll);
  }

  @Test
  void excluirCliente_ShouldRemoveCliente_WhenSuccessful() {
    when(clienteDAO.findById(anyInt())).thenReturn(Optional.of(createCliente()));

    assertThatCode(() -> iCliente.excluirCliente(1)).doesNotThrowAnyException();
    verify(clienteDAO, times(1)).deleteById(1);
  }

  @Test
  void excluirCliente_ShouldThrowNotFoundException() {
    when(clienteDAO.findById(anyInt())).thenReturn(Optional.empty());
    assertThrows(NotFoundException.class, () -> iCliente.excluirCliente(1));
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
