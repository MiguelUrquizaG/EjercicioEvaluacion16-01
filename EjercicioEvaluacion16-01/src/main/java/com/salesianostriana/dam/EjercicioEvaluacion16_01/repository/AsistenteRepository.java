package com.salesianostriana.dam.EjercicioEvaluacion16_01.repository;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Asistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenteRepository extends JpaRepository<Asistente,Long> {
}
