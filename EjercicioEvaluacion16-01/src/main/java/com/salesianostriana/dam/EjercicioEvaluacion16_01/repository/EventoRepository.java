package com.salesianostriana.dam.EjercicioEvaluacion16_01.repository;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Long> {
}
