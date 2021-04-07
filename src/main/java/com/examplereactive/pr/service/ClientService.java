package com.examplereactive.pr.service;

import com.examplereactive.pr.model.Cliente;
import com.examplereactive.pr.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClienteDao dao;


    public List<Cliente> showClients(){

        return this.dao.getAllClients();
    }

    public Flux<Cliente>showClientFlux(){
        return this.dao.getFluxClients();
    }
}
