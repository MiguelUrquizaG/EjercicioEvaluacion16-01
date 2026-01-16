package com.salesianostriana.dam.EjercicioEvaluacion16_01.repository;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Entrada;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada,Long> {

    @EntityGraph(attributePaths = {"Asistente"})
    List<Entrada> findEntradaByAsistente_IdANDEstado(Long idAsistente, Estado estado);

    @Query("select e from Entrada join fetch e.evento join fetch e.asistente where c.evento.id = :idEvento")
    List<Entrada>entradasEventoAsistente(Long idEvento);

    @EntityGraph(attributePaths = {"asistente","evento"})
    List<Entrada>findAll();

    Page<Entrada>findEntradaByEvento_Id(Long idEvento,Pageable pageable);
}
