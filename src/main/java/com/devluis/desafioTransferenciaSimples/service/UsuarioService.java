package com.devluis.desafioTransferenciaSimples.service;

import com.devluis.desafioTransferenciaSimples.entity.Usuario;
import com.devluis.desafioTransferenciaSimples.exeptions.UserNotFound;
import com.devluis.desafioTransferenciaSimples.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new UserNotFound("Usuário não encontrado."));
    }


}
