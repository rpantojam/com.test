package com.test.service;

import java.util.ArrayList;
import java.util.List;


import com.test.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.test.model.Client;
import com.test.model.dtos.ClientDto;
import com.test.respository.IClientRepository;


@Service
public class ClientService implements IClientService {

	private final IClientRepository clientRepository;

	public ClientService(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	 
	@Override
	public List<ClientDto> findAll() {
		List<ClientDto> clients = new ArrayList<ClientDto>();
		
		try {
			clientRepository.findAll().forEach((c) -> {
				//convert  this to auto mapped
				ClientDto cl = new ClientDto(c.getId(), c.getFirstName(), c.getLastName(), c.getSurname(), c.getPhone());
				clients.add(cl);
			});
        
		}catch(Exception ex){
			throw ex;
		}
		
		return clients;
	}



	@Override
	public Client save(ClientDto clientdto) {
		Client row = null;
		try {
			
			Client client = new Client();
			
			//convert  this to auto mapped
			
			client.setFirstName(clientdto.getFirstName());
			client.setLastName(clientdto.getLastName());
			client.setSurname(clientdto.getSurname());
			client.setPhone(clientdto.getPhone());
			
			row = clientRepository.save(client);
        
		}catch(Exception ex){
			throw ex;
		}
		
		return row;
	}

	@Override
	public void deleteClient(Long clientId) {

		var client = clientRepository.findById(clientId);

		if (client.isEmpty()) {
			throw new ResourceNotFoundException("Client not found with id: " + clientId);
		}

		clientRepository.delete(client.get());
	}

}
