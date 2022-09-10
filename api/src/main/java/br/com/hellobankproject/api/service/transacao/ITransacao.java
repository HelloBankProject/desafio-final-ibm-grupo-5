package br.com.hellobankproject.api.service.transacao;

import br.com.hellobankproject.api.dao.TransacaoDAO;
import br.com.hellobankproject.api.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ITransacao implements ITransacaoService {
    @Autowired
    private TransacaoDAO dao;

    @Override
    public Transacao criarNovoTransacao(Transacao novo) {
        if (novo.getValor() != null && novo.getModo() != null && novo.getData() != null && novo.getRecebedor() != null && novo.getFornecedor() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Transacao atualizarDadosTransacao(Transacao dados) {
        if (dados.getId() != null && dados.getValor() != null && dados.getModo() != null && dados.getData() != null && dados.getRecebedor() != null && dados.getFornecedor() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Transacao> buscarTodosTransacao() {
        return (ArrayList<Transacao>)dao.findAll();
    }

    @Override
    public Transacao buscarPeloIdTransacao(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirTransacao(Integer id) {
        dao.deleteById(id);
    }
}
