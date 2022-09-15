package br.com.hellobankproject.api.service.transacao;

import br.com.hellobankproject.api.dao.TransacaoDAO;
import br.com.hellobankproject.api.exception.NotFoundException;
import br.com.hellobankproject.api.model.Conta;
import br.com.hellobankproject.api.model.Transacao;
import br.com.hellobankproject.api.service.conta.IContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITransacao implements ITransacaoService {
    @Autowired
    private IContaService conta;

    @Autowired
    private TransacaoDAO dao;
    private static final String MSG = "Transacão não registrada";

    @Override
    public Transacao criarNovoTransferencia(Transacao novo) {
        Conta recebedor = conta.buscarPeloIdConta(novo.getRecebedor().getId());
        Conta fornecedor = conta.buscarPeloIdConta(novo.getFornecedor().getId());

        if (recebedor != null && fornecedor != null) {

            Double res = fornecedor.saque(novo.getValor());

            if (res != null) {
                recebedor.deposito(novo.getValor());
                conta.atualizarDadosConta(recebedor);
                conta.atualizarDadosConta(fornecedor);

                return dao.save(novo);
            }
        }

        return null;
    }

    @Override
    public Transacao criarNovoDeposito(Transacao novo) {
        Conta recebedor = conta.buscarPeloIdConta(novo.getRecebedor().getId());
        if (recebedor != null) {
            Double deposito = recebedor.deposito(novo.getValor());

            if (deposito != null) {
                conta.atualizarDadosConta(recebedor);
            }
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Transacao criarNovoSaque(Transacao novo) {
        Conta fornecedor = conta.buscarPeloIdConta(novo.getFornecedor().getId());
        if (fornecedor != null) {
            Double saque = fornecedor.saque(novo.getValor());

            if (saque != null) {
                conta.atualizarDadosConta(fornecedor);

                return dao.save(novo);
            }
        }
        return null;
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
