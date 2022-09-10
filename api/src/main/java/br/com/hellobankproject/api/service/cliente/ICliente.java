package br.com.hellobankproject.api.service.cliente;

import br.com.hellobankproject.api.dao.ClienteDAO;
import br.com.hellobankproject.api.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ICliente implements IClienteService {
    @Autowired
    private ClienteDAO dao;

    @Override
    public Cliente criarNovoCliente(Cliente novo) {
        if (novo.getCpf() != null && novo.getNome() != null && novo.getEmail() != null && novo.getSenha() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Cliente atualizarDadosCliente(Cliente dados) {
        if (dados.getId() != null && dados.getCpf() != null && dados.getNome() != null && dados.getEmail() != null && dados.getSenha() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarTodosClientes() {
        return (ArrayList<Cliente>)dao.findAll();
    }

    @Override
    public Cliente buscarPeloIdCliente(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirCliente(Integer id) {
        dao.deleteById(id);
    }
}
