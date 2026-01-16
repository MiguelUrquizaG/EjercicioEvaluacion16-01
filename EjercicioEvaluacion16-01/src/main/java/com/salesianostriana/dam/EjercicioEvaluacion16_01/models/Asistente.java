package com.salesianostriana.dam.EjercicioEvaluacion16_01.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Asistente {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "asistente")
    @Builder.Default
    private Set<Entrada> entradaSet =  new HashSet<>();
}
