package br.com.hellobank.api.dao;

import br.com.hellobank.api.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
}
