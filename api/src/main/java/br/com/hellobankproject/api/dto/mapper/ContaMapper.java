package br.com.hellobankproject.api.dto.mapper;

import br.com.hellobankproject.api.dto.request.contaRequest.ContaRequest;
import br.com.hellobankproject.api.dto.response.contaResponse.ContaResponse;
import br.com.hellobankproject.api.model.Cliente;
import br.com.hellobankproject.api.model.Conta;

public class ContaMapper {
    public static Conta toConta(ContaRequest request) {
        Cliente primeiroTitular = new Cliente();
        Cliente segundoTitular = new Cliente();
        primeiroTitular.setId(request.getIdPrimeiroTitular());
        segundoTitular.setId(request.getIdSegundoTitular());

        Conta conta = new Conta();
        conta.setTipo(request.getTipo());
        conta.setSaldo(request.getSaldo());
        conta.setCredito(request.getCredito());
        conta.setPrimeiroTitular(primeiroTitular);
        if (segundoTitular.getId() != null) {
            conta.setSegundoTitular(segundoTitular);
        } else {
            conta.setSegundoTitular(null);
        }

        return conta;
    }

    public static ContaResponse toContaResponse(Conta conta) {
        ContaResponse response = new ContaResponse();

        response.setId(conta.getId());
        response.setTipo(conta.getTipo());
        response.setSaldo(conta.getSaldo());
        response.setCredito(conta.getCredito());
        response.setIdPrimeiroTitular(conta.getPrimeiroTitular().getId());
        if (conta.getSegundoTitular() != null) {
            response.setIdSegundoTitular(conta.getSegundoTitular().getId());
        }

        return response;
    }
};
