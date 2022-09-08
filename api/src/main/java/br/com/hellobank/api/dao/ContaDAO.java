package br.com.hellobank.api.dao;

import br.com.hellobank.api.model.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaDAO extends CrudRepository<Conta, Integer> {
}
