package br.com.hellobankproject.api.service.conta;

import br.com.hellobankproject.api.dao.ContaDAO;
import br.com.hellobankproject.api.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IConta implements IContaService {
    @Autowired
    private ContaDAO dao;
    @Override
    public Conta criarNovoConta(Conta novo) {
        if (novo.getTipo() != null && novo.getSaldo() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Conta atualizarDadosConta(Conta dados) {
        if (dados.getId() != null && dados.getTipo() != null && dados.getSaldo() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Conta> buscarTodasContas() {
        return (ArrayList<Conta>)dao.findAll();
    }

    @Override
    public Conta buscarPeloIdConta(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirConta(Integer id) {
        dao.deleteById(id);
    }
}
