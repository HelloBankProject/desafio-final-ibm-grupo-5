package br.com.hellobankproject.api.service.transacao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.hellobankproject.api.dao.TransacaoDAO;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.conta.IConta;

@ExtendWith(MockitoExtension.class)
public class ITransacaoTest {

  @Mock
  private IConta Iconta;

  @Mock
  private TransacaoDAO transacaoDAO;

  @InjectMocks
  private ITransacao iTransacao;

  @Test
  void criarNovoDeposito_ShouldReturnTransacao_WhenSuccessful() {
    Conta conta = createConta(createCliente());
    when(Iconta.existsById(anyInt())).thenReturn(true);
    when(Iconta.buscarPeloIdConta(anyInt())).thenReturn(conta);
    when(transacaoDAO.save(any(Transacao.class))).thenReturn(createTransacao(conta, conta, "deposito"));
    double valorAntigo = conta.getSaldo();
    Transacao transacao = iTransacao.criarNovoDeposito(createTransacao(conta, conta, "deposito"));

    assertThat(transacao).isNotNull();
    assertThat(transacao.getRecebedor()).isEqualTo(conta);
    assertThat(conta.getSaldo()).isGreaterThan(valorAntigo);
  }

  @Test
  void criarNovoDeposito_ShouldThrowNotFoundException() {
    when(Iconta.existsById(anyInt())).thenReturn(false);
    Conta conta = createConta(createCliente());
    Transacao transacao = createTransacao(conta, conta, "Deposito");

    assertThrows(NotFoundException.class,
        () -> iTransacao.criarNovoDeposito(transacao));
  }

  @Test
  void criarNovoSaque_ShouldReturnTransacao_WhenSuccessful() {
    Conta conta = createConta(createCliente());
    when(Iconta.existsById(anyInt())).thenReturn(true);
    when(Iconta.buscarPeloIdConta(anyInt())).thenReturn(conta);
    when(transacaoDAO.save(any(Transacao.class))).thenReturn(createTransacao(conta, conta, "saque"));
    double valorAntigo = conta.getSaldo();

    Transacao transacao = iTransacao.criarNovoSaque(createTransacao(conta, conta, "saque"));

    assertThat(transacao).isNotNull();
    assertThat(transacao.getRecebedor()).isEqualTo(conta);
    assertThat(conta.getSaldo()).isLessThan(valorAntigo);
  }

  @Test
  void criarNovoSaque_ShouldThrowNotFoundException() {
    when(Iconta.existsById(anyInt())).thenReturn(false);
    Conta conta = createConta(createCliente());
    Transacao transacao = createTransacao(conta, conta, "Saque");

    assertThrows(NotFoundException.class,
        () -> iTransacao.criarNovoSaque(transacao));
  }

  @Test
  void criarNovaTransferencia_ShouldReturnTransacao_WhenSuccessful() {
    Conta conta2 = createConta(createCliente2());
    conta2.setId(2);
    when(Iconta.existsById(anyInt())).thenReturn(true);
    when(Iconta.buscarPeloIdConta(1)).thenReturn(createConta(createCliente()));
    when(Iconta.buscarPeloIdConta(2)).thenReturn(conta2);
    when(transacaoDAO.save(any(Transacao.class)))
        .thenReturn(createTransacao(createConta(createCliente()), conta2, "transferencia"));

    double valorAntigo = conta2.getSaldo();

    Transacao transacao = iTransacao
        .criarNovoTransferencia(createTransacao(createConta(createCliente()), conta2, "transferencia"));

    assertThat(transacao).isNotNull();
    assertThat(transacao.getRecebedor()).isEqualTo(conta2);
    assertThat(transacao.getFornecedor()).isEqualTo(createConta(createCliente()));
    assertThat(conta2.getSaldo()).isGreaterThan(valorAntigo);
  }

  @Test
  void criarNovaTransferencia_ShouldThrowNotFoundException() {
    when(Iconta.existsById(anyInt())).thenReturn(false);
    Conta conta = createConta(createCliente());
    Conta conta2 = createConta(createCliente2());
    Transacao transacao = createTransacao(conta, conta2, "Transferencia");

    assertThrows(NotFoundException.class,
        () -> iTransacao.criarNovoTransferencia(transacao));
  }

  @Test
  void buscarPeloIdTransacao_ShouldReturnTransacao_WhenSuccessful() {
    Conta conta = createConta(createCliente());
    when(transacaoDAO.findById(anyInt())).thenReturn(Optional.of(createTransacao(conta, conta, "Saque")));
    Transacao transacao = iTransacao.buscarPeloIdTransacao(1);

    assertThat(transacao).isNotNull();
    assertThat(transacao.getRecebedor()).isEqualTo(conta);
  }

  @Test
  void buscarPeloIdTransacao_ShouldThrowNotFoundException() {
    when(transacaoDAO.findById(anyInt())).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class,
        () -> iTransacao.buscarPeloIdTransacao(1));
  }

  @Test
  void buscarTodosTransacao_ShouldReturnAListOfTransacao_WhenSuccessful() {
    Conta conta = createConta(createCliente());
    when(transacaoDAO.findAll()).thenReturn(List.of(createTransacao(conta, conta, "Saque")));

    List<Transacao> foundAll = iTransacao.buscarTodosTransacao();
    assertThat(foundAll).isNotEmpty().isNotNull();
    assertThat(createTransacao(conta, conta, "saque")).isIn(foundAll);
  }

  @Test
  void excluirTransacao_ShouldRemoveTransacao_WhenSuccessful() {
    when(transacaoDAO.existsById(anyInt())).thenReturn(true);

    Assertions.assertThatCode(() -> iTransacao.excluirTransacao(1)).doesNotThrowAnyException();
    verify(transacaoDAO, times(1)).deleteById(1);
  }

  @Test
  void excluirTransacao_ShouldThrowNotFoundException() {
    when(transacaoDAO.existsById(anyInt())).thenReturn(false);

    assertThrows(NotFoundException.class, () -> iTransacao.excluirTransacao(1));
    verify(transacaoDAO, times(0)).deleteById(1);
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

  public Cliente createCliente2() {
    Cliente cliente = new Cliente();
    cliente.setId(2);
    cliente.setCpf("33564594221");
    cliente.setNome("Oliveira");
    cliente.setEmail("Oliveira@email.com");
    cliente.setEndereco("Rua da campo");
    cliente.setCidade("Rio de janeiro");
    cliente.setBairro("Itanhangá");
    cliente.setEstado("Rio de janeiro");
    cliente.setSenha("An231@_311aa");
    cliente.setTelefone("123456789");
    return cliente;
  }
}
