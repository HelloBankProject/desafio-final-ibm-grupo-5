package br.com.hellobankproject.api.service.transacao;

import br.com.hellobankproject.api.dao.TransacaoDAO;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITransacao implements ITransacaoService {
    @Autowired
    private TransacaoDAO dao;
    private static final String MSG = "Transacão não registrada";

    @Override
    public Transacao criarNovoTransacao(Transacao novo) {
        return dao.save(novo);
    }

    @Override
    public Transacao atualizarDadosTransacao(Transacao dados) {
        if (dao.existsById(dados.getId())) {
            return dao.save(dados);
        }
        throw new NotFoundException(MSG);
    }

    @Override
    public List<Transacao> buscarTodosTransacao() {
        return (List<Transacao>) dao.findAll();
    }

    @Override
    public Transacao buscarPeloIdTransacao(Integer id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException(MSG));
    }

    @Override
    public void excluirTransacao(Integer id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
        } else {
            throw new NotFoundException(MSG);
        }
    }
}
