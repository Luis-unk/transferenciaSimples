package com.devluis.desafioTransferenciaSimples.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDTO {

    private BigDecimal value;

    private Long payer;

    private Long payee;

}
