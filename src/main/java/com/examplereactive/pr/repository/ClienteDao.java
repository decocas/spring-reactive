package com.examplereactive.pr.repository;


import com.examplereactive.pr.model.Cliente;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ClienteDao {
    private static void pausar(int i)   {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

   public List<Cliente> getAllClients(){

        return IntStream.rangeClosed(1,20)
                .peek(value -> System.out.println("# "+value))
                .peek(ClienteDao::pausar)
                .mapToObj(value -> new Cliente(value,"cliente # "+value))
                .collect(Collectors.toList());
    }


    public Flux<Cliente> getFluxClients(){
        return Flux.range(1,20)
                .delayElements(Duration.ofSeconds(2))
                .doOnNext(integer -> System.out.println("cliente"+integer))
                .map(integer -> new Cliente(integer, "clinte"+integer));

    }
}
