package com.devluis.desafioTransferenciaSimples.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "cpfcnpj", unique = true, nullable = false)
    private String cpfCnpj;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha")
    private String senha;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Carteira carteira;

    private TipoUsuario tipoUsuario;

}
