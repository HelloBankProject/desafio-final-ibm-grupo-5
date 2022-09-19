package br.com.hellobankproject.api.service.conta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.hellobankproject.api.dao.ClienteDAO;
import br.com.hellobankproject.api.dao.ContaDAO;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.service.cliente.ICliente;

@ExtendWith(MockitoExtension.class)
public class IContaTest {

  @Mock
  private ContaDAO contaDAO;

  @Mock
  private ClienteDAO clienteDAO;

  @InjectMocks
  private IConta iConta;

  @Test
  void criarNovoConta_ShouldReturnsConta_WhenSuccessful() {
    when(contaDAO.save(any(Conta.class))).thenReturn(createConta());
    when(clienteDAO.existsById(anyInt())).thenReturn(true);
    Conta conta = iConta.criarNovoConta(createConta());

    assertThat(conta).isEqualTo(createConta()).isNotNull();
  }

  @Test
  void criarNovoConta_ShouldThrowNotFoundException() {
    when(clienteDAO.existsById(anyInt())).thenReturn(false);
    Conta conta = createConta();

    assertThrows(NotFoundException.class, () -> iConta.criarNovoConta(conta));
  }

  @Test
  void buscarPeloIdConta_ShouldReturnsConta_WhenSuccessful() {
    when(contaDAO.findById(anyInt())).thenReturn(Optional.of(createConta()));

    Conta conta = iConta.buscarPeloIdConta(1);
    assertThat(conta).isEqualTo(createConta()).isNotNull();
  }

  @Test
  void buscarPeloIdConta_ShouldThrowNotFoundException() {
    when(contaDAO.findById(anyInt())).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> iConta.buscarPeloIdConta(1));
  }

  @Test
  void buscarTodasContas_ShouldReturnsAListOfContas_WhenSuccessful() {
    when(contaDAO.findAll()).thenReturn(List.of(createConta()));
    List<Conta> foundAll = iConta.buscarTodasContas();

    assertThat(foundAll).isNotEmpty().isNotNull();
    assertThat(createConta()).isIn(foundAll);
  }

  @Test
  void excluirConta_ShouldRemoveConta_WhenSuccessful() {
    when(contaDAO.existsById(anyInt())).thenReturn(true);

    assertThatCode(() -> iConta.excluirConta(1)).doesNotThrowAnyException();
    verify(contaDAO, times(1)).deleteById(1);
  }

  @Test
  void excluirConta_ShouldThrowNotFoundException_WhenSuccessful() {
    when(contaDAO.existsById(anyInt())).thenReturn(false);

    assertThrows(NotFoundException.class, () -> iConta.excluirConta(1));
  }

  public Conta createConta() {
    Conta conta = new Conta();
    conta.setId(1);
    conta.setTipo("corrente");
    conta.setSaldo(2000.0);
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
