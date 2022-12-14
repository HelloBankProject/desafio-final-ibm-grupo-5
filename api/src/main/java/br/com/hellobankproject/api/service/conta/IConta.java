package br.com.hellobankproject.api.service.conta;

import br.com.hellobankproject.api.dao.ClienteDAO;
import br.com.hellobankproject.api.dao.ContaDAO;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IConta implements IContaService {
    @Autowired
    private ContaDAO dao;
    @Autowired
    private ClienteDAO clienteDAO;
    private static final String MSG = "Conta não cadastrada";

    @Override
    public Conta criarNovoConta(Conta novo) {
        if (clienteDAO.existsById(novo.getPrimeiroTitular().getId())) {
            return dao.save(novo);
        } else {
            throw new NotFoundException("Cliente não cadastrado");
        }
    }

    @Override
    public Conta atualizarDadosConta(Conta dados) {
        if (dao.existsById(dados.getId())) {
            return dao.save(dados);
        }
        throw new NotFoundException(MSG);
    }

    @Override
    public List<Conta> buscarTodasContas() {
        return (List<Conta>) dao.findAll();
    }

    @Override
    public Conta buscarPeloIdConta(Integer id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException(MSG));
    }

    @Override
    public void excluirConta(Integer id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
        } else {
            throw new NotFoundException(MSG);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return dao.existsById(id);
    }

}
