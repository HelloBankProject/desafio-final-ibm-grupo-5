package br.com.hellobank.api.service.transacao;

import br.com.hellobank.api.dao.TransacaoDAO;
import br.com.hellobank.api.model.Conta;
import br.com.hellobank.api.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ITransacao implements ITransacaoService{

    @Autowired
    private TransacaoDAO dao;

    @Override
    public Transacao criarNovoTransacao(Transacao novo) {
        if (novo.getValor() != null && novo.getModo() != null && novo.getData() != null && novo.getConta() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Transacao atualizarDadosTransacao(Transacao dados) {
        if (dados.getId() != null && dados.getValor() != null && dados.getModo() != null && dados.getData() != null && dados.getConta() != null) {
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
