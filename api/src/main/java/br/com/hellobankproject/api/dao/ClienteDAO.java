package br.com.hellobankproject.api.dao;

import br.com.hellobankproject.api.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
}
