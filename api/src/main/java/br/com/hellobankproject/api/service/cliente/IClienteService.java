package br.com.hellobankproject.api.service.cliente;

import br.com.hellobankproject.api.exception.ClienteNotFoundException;
import br.com.hellobankproject.api.model.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente criarNovoCliente(Cliente novo);

    public Cliente atualizarDadosCliente(Cliente dados) throws ClienteNotFoundException;

    public List<Cliente> buscarTodosClientes();

    public Cliente buscarPeloIdCliente(Integer id) throws ClienteNotFoundException;

    public void excluirCliente(Integer id);
}
