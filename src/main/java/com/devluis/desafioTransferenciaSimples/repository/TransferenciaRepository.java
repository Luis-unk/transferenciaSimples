package com.devluis.desafioTransferenciaSimples.repository;

import com.devluis.desafioTransferenciaSimples.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
