package br.com.hellobankproject.api.service.cliente;

import br.com.hellobankproject.api.dao.ClienteDAO;
import br.com.hellobankproject.api.exception.ClienteAlreadyCreatedException;
import br.com.hellobankproject.api.exception.ClienteNotFoundException;
import br.com.hellobankproject.api.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICliente implements IClienteService {
    @Autowired
    private ClienteDAO dao;
    private static final String msg = "Cliente nao cadastrado";

    @Override
    public Cliente criarNovoCliente(Cliente novo) {
        if (dao.findByCpf(novo.getCpf()).isPresent()) {
            throw new ClienteAlreadyCreatedException("Cliente ja cadastrado");
        }
        return dao.save(novo);
    }

    @Override
    public Cliente atualizarDadosCliente(Cliente dados) {
        return dao.findById(dados.getId()).orElseThrow(() -> new ClienteNotFoundException(msg));
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return (List<Cliente>) dao.findAll();
    }

    @Override
    public Cliente buscarPeloIdCliente(Integer id) {
        return dao.findById(id).orElseThrow(() -> new ClienteNotFoundException(msg));
    }

    @Override
    public void excluirCliente(Integer id) {
        if (!dao.findById(id).isPresent()) {
            throw new ClienteNotFoundException(msg);
        } else {
            dao.deleteById(id);
        }
    }
}
