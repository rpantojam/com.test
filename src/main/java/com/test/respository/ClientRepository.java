package com.test.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.model.Client;

@Repository
public class ClientRepository {

    private final IClientRepository repository;

    public ClientRepository(IClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client save(Client client) {
        return repository.save(client);
    }

}
