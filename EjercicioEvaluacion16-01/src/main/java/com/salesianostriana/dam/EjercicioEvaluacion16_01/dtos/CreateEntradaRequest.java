package com.salesianostriana.dam.EjercicioEvaluacion16_01.dtos;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Estado;

import java.time.LocalDateTime;

public record CreateEntradaRequest(
        LocalDateTime fechaCompra,
        Estado estado,
        Long idEvento,
        Long idAsistente
) {
}
