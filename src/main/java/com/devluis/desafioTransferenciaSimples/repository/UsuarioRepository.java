package com.devluis.desafioTransferenciaSimples.repository;

import com.devluis.desafioTransferenciaSimples.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
