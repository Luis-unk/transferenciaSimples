package com.devluis.desafioTransferenciaSimples.service;

import com.devluis.desafioTransferenciaSimples.infra.clients.AutorizacaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AutorizacaoService {

    @Autowired
    AutorizacaoClient client;

    public boolean validarTransferencia() {

        if (Objects.equals(client.validarAutorizacao()
                        .data()
                        .authorization()
                , "true")) {
            return true;
        }
        return false;
    }
}
