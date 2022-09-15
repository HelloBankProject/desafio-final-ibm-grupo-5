package br.com.hellobankproject.api.service.cliente;

import br.com.hellobankproject.api.dao.ClienteDAO;
import br.com.hellobankproject.api.exception.AlreadyCreatedException;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICliente implements IClienteService {
    @Autowired
    private ClienteDAO dao;
    private static final String MSG = "Cliente não cadastrado";

    @Override
    public Cliente criarNovoCliente(Cliente novo) {
        if (dao.findByCpf(novo.getCpf()).isPresent()) {
            throw new AlreadyCreatedException("Cliente já cadastrado");
        }
        return dao.save(novo);
    }

    @Override
    public Cliente atualizarDadosCliente(Cliente dados) {
        if (dao.existsById(dados.getId())) {
            return dao.save(dados);
        } else {
            throw new NotFoundException(MSG);
        }
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return (List<Cliente>) dao.findAll();
    }

    @Override
    public Cliente buscarPeloIdCliente(Integer id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException(MSG));
    }

    @Override
    public void excluirCliente(Integer id) {
        if (!dao.findById(id).isPresent()) {
            throw new NotFoundException(MSG);
        } else {
            dao.deleteById(id);
        }
    }
}
