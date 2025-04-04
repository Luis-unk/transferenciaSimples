package com.devluis.desafioTransferenciaSimples.repository;

import com.devluis.desafioTransferenciaSimples.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
