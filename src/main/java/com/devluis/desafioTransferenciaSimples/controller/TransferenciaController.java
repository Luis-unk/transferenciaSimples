package com.devluis.desafioTransferenciaSimples.controller;

import com.devluis.desafioTransferenciaSimples.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @PostMapping
    public ResponseEntity<?> realizarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO){
        service.realizarTransferencia(transferenciaDTO);
        return ResponseEntity.accepted().build();
    }

}
