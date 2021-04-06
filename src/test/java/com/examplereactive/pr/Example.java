package com.examplereactive.pr;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example {

    @Test
    void testMono(){
        Mono<String> stringMono= Mono.just("prueba")
                .log();

        stringMono.subscribe(System.out::println);

    }

    @Test
    void testMonoError(){
        Mono<Object> stringMono= Mono.just("el error")
                .then(Mono.error(new RuntimeException("Mensaje error")))
                .log();

        stringMono.subscribe(System.out::println);

    }

    @Test
    void testMonoErrorOverride(){
        Mono<Object> stringMono= Mono.just("el error")
                .then(Mono.error(new RuntimeException("Mensaje error")))
                .log();

        stringMono.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }

    @Test
    void testFlux(){
        Flux<String>stringFlux=Flux.just("flux","sirve","para","mutiples","mensajes").log();
        stringFlux.subscribe(System.out::println);
    }

    @Test
    void testFluxConcat(){
        Flux<String>stringFlux=Flux.just("flux","sirve","para","mutiples","mensajes")
                .concatWithValues("mensaje al final de la lista")
                .log();
        stringFlux.subscribe(System.out::println);
    }

    @Test
    void testFluxConcatError(){
        Flux<String>stringFlux=Flux.just("flux","sirve","para","mutiples","mensajes")
                .concatWithValues("mensaje al final de la lista")
                .concatWith(Flux.error(new RuntimeException("Exception agregada al error")))
                .log();
        stringFlux.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
