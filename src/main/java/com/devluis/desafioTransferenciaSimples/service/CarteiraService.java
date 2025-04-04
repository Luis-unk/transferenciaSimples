package com.devluis.desafioTransferenciaSimples.service;

import com.devluis.desafioTransferenciaSimples.entity.Carteira;
import com.devluis.desafioTransferenciaSimples.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepository repository;

    public void salvar(Carteira carteira){
        repository.save(carteira);
    }

}
