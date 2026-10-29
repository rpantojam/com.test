package com.test.controller;

import java.util.List;

import com.test.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.model.dtos.ClientDto;
import com.test.model.dtos.ServiceResponse;
import com.test.service.IClientService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/api")
public class ClientController implements IClientController {
    @Autowired
    private IClientService clientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(clientService.findAll());

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client")
    public ResponseEntity<ServiceResponse> saveClient(@RequestBody ClientDto client) {
        ServiceResponse serviceReponse = new ServiceResponse();
        Client result = clientService.save(client);
        if (result != null) {
            serviceReponse.setSuccess(true);
            serviceReponse.setMessage("Client saved with success");
        }

        return new ResponseEntity<>(serviceReponse, HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<ServiceResponse> deleteClient(@PathVariable Long clientId) {
        ServiceResponse response = new ServiceResponse();
        clientService.deleteClient(clientId);
        response.setSuccess(true);
        response.setMessage("Client deleted with success");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

}
