package br.com.hellobankproject.api.service.conta;

import br.com.hellobankproject.api.model.Conta;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Optional;
=======
import java.util.List;
>>>>>>> fad3de1aea2230c9a78b91e4e505328e2f087429

public interface IContaService {
    public Conta criarNovoConta(Conta novo);

    public Conta atualizarDadosConta(Conta dados);

    public List<Conta> buscarTodasContas();

    public Conta buscarPeloIdConta(Integer id);

    public void excluirConta(Integer id);

    public boolean existsById(Integer id);
}
