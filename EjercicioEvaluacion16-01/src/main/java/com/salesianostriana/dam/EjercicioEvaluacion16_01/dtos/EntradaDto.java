package com.salesianostriana.dam.EjercicioEvaluacion16_01.dtos;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Entrada;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Estado;

import java.time.LocalDateTime;

public record EntradaDto(
        Long id,
        LocalDateTime fechaCompra,
        Estado estado,
        String tituloEvento

) {

    public static EntradaDto of(Entrada e){
        return new EntradaDto(
                e.getId(),
                e.getFechaCompra(),
                e.getEstado(),
                e.getEvento().getTitulo()
        );
    }
}
