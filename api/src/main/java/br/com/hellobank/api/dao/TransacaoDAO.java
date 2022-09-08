package br.com.hellobank.api.dao;

import br.com.hellobank.api.model.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
}
