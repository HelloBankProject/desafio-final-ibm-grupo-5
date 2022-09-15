package br.com.hellobankproject.api.service.transacao;

import br.com.hellobankproject.api.model.Transacao;

import java.util.List;

public interface ITransacaoService {
    public Transacao criarNovoTransacao(Transacao novo);

    public Transacao atualizarDadosTransacao(Transacao dados);

    public List<Transacao> buscarTodosTransacao();

    public Transacao buscarPeloIdTransacao(Integer id);

    public void excluirTransacao(Integer id);
}
