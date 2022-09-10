package br.com.hellobankproject.api.service.transacao;

import br.com.hellobankproject.api.model.Transacao;

import java.util.ArrayList;

public interface ITransacaoService {
    public Transacao criarNovoTransacao(Transacao novo);
    public Transacao atualizarDadosTransacao(Transacao dados);
    public ArrayList<Transacao> buscarTodosTransacao();
    public Transacao buscarPeloIdTransacao(Integer id);
    public void excluirTransacao(Integer id);
}
