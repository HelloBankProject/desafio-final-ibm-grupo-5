package br.com.hellobankproject.api.service.conta;

import br.com.hellobankproject.api.model.Conta;

import java.util.ArrayList;
import java.util.Optional;

public interface IContaService {
    public Conta criarNovoConta(Conta novo);
    public Conta atualizarDadosConta(Conta dados);
    public ArrayList<Conta> buscarTodasContas();
    public Conta buscarPeloIdConta(Integer id);
    public void excluirConta(Integer id);
}
