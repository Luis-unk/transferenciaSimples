package com.devluis.desafioTransferenciaSimples.infra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "autorizacao")
public interface AutorizacaoClient {

    @GetMapping
    AutorizacaoDTO validarAutorizacao(); // A resposta é desserializada diretamente em nosso DTO
}
