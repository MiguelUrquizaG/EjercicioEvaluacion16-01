package com.salesianostriana.dam.EjercicioEvaluacion16_01.models;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.events.EventException;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Entrada {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fechaCompra;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asistente_id")
    private Asistente asistente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id")
    private Evento evento;

}
