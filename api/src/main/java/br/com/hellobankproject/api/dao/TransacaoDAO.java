package br.com.hellobankproject.api.dao;

import br.com.hellobankproject.api.model.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {

}
