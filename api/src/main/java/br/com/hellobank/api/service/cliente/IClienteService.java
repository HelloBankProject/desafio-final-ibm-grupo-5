package br.com.hellobank.api.service.cliente;

import br.com.hellobank.api.model.Cliente;

import java.util.ArrayList;

public interface IClienteService {
    public Cliente criarNovoCliente(Cliente novo);
    public Cliente atualizarDadosCliente(Cliente dados);
    public ArrayList<Cliente> buscarTodosClientes();
    public Cliente buscarPeloIdCliente(Integer id);
    public void excluirCliente(Integer id);
}
