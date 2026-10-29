package com.test.service;

import java.util.List;

import com.test.model.Client;
import com.test.model.dtos.ClientDto;

public interface IClientService {

	List<ClientDto> findAll();
	Client save(ClientDto client);
	void deleteClient(Long clientId);

}
