package com.examplereactive.pr.controller;

import com.examplereactive.pr.model.Cliente;
import com.examplereactive.pr.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControl {
        @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Cliente> show(){

        return this.service.showClients();
    }

    @GetMapping(value = "/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Cliente>showFlux(){

        return  this.service.showClientFlux();
    }

}
