package br.com.hellobankproject.api.dao;

import br.com.hellobankproject.api.model.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaDAO extends CrudRepository<Conta, Integer> {
}
