package com.salesianostriana.dam.EjercicioEvaluacion16_01.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Evento {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private LocalDateTime fecha;
    private int aforoMaximo;
    private int entradasVendidas;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "evento")
    @Builder.Default
    Set<Entrada> entradaSet = new HashSet<>();

}
