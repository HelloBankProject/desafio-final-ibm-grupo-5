package br.com.hellobankproject.api.service.cliente;

import br.com.hellobankproject.api.model.Cliente;

import java.util.ArrayList;

public interface IClienteService {
    public Cliente criarNovoCliente(Cliente novo);
    public Cliente atualizarDadosCliente(Cliente dados);
    public ArrayList<Cliente> buscarTodosClientes();
    public Cliente buscarPeloIdCliente(Integer id);
    public void excluirCliente(Integer id);
}
