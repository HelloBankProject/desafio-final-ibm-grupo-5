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
    private IContaService contaDAO;

    @Autowired
    private TransacaoDAO dao;
    private static final String MSG = "Transacão não registrada";

    @Override
    public Transacao criarNovoTransferencia(Transacao novo) {
        if (contaDAO.existsById(novo.getFornecedor().getId())) {
            if (contaDAO.existsById(novo.getRecebedor().getId())) {
                Conta recebedor = contaDAO.buscarPeloIdConta(novo.getRecebedor().getId());
                Conta fornecedor = contaDAO.buscarPeloIdConta(novo.getFornecedor().getId());

                fornecedor.saque(novo.getValor());
                recebedor.deposito(novo.getValor());
                contaDAO.atualizarDadosConta(recebedor);
                contaDAO.atualizarDadosConta(fornecedor);
                return dao.save(novo);
            } else {
                throw new NotFoundException("Conta recebedora não cadastrada");
            }
        } else {
            throw new NotFoundException("Conta fornecedora não cadastrada");
        }
    }

    @Override
    public Transacao criarNovoDeposito(Transacao novo) {
        if (contaDAO.existsById(novo.getRecebedor().getId())) {
            Conta conta = contaDAO.buscarPeloIdConta(novo.getRecebedor().getId());
            conta.deposito(novo.getValor());
            contaDAO.atualizarDadosConta(conta);
            return dao.save(novo);
        } else {
            throw new NotFoundException("Conta não cadastrada");
        }
    }

    @Override
    public Transacao criarNovoSaque(Transacao novo) {
        if (contaDAO.existsById(novo.getRecebedor().getId())) {
            Conta conta = contaDAO.buscarPeloIdConta(novo.getRecebedor().getId());
            conta.saque(novo.getValor());
            contaDAO.atualizarDadosConta(conta);
            return dao.save(novo);
        } else {
            throw new NotFoundException("Conta não cadastrada");
        }
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
