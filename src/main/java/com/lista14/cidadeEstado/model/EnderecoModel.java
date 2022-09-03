package com.lista14.cidadeEstado.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 50, nullable = false)
    private String logradouro;

    @Column(length = 3, nullable = false)
    private String numero;

    @Column(length = 50, nullable = false)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidade_codigo")
    private CidadeModel cidade;
}
