package com.salesianostriana.dam.EjercicioEvaluacion16_01.controller;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.dtos.EntradaDto;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Entrada;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.services.EntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EntradasController {
    private final EntradaService entradaService;

    @GetMapping("/entradas")
    public List<EntradaDto> getAll(){
        return entradaService.findAll().stream().map(EntradaDto::of).toList();
    }

    @PutMapping("/entradas/{id}/cancelar")
    public EntradaDto cancel(@PathVariable Long id){
        return EntradaDto.of(entradaService.cancelarEntrada(id));
    }


    @GetMapping("/eventos/{id}/entradas")
    public Page<Entrada>getEntradasEventoPaged(@PathVariable Long id, Pageable pageable){
        return entradaService.obtenerEntradasEvento(id,pageable);
    }


}
