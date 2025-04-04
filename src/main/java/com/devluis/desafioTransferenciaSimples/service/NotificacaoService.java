package com.devluis.desafioTransferenciaSimples.service;

import com.devluis.desafioTransferenciaSimples.infra.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    @Autowired
    private NotificacaoClient client;

    public void enviarNotificacao(){
        client.enviarNotificacao();
    }

}
