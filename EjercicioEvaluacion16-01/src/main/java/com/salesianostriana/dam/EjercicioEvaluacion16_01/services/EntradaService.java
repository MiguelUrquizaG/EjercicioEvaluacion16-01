package com.salesianostriana.dam.EjercicioEvaluacion16_01.services;

import com.salesianostriana.dam.EjercicioEvaluacion16_01.dtos.CreateEntradaRequest;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Asistente;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Entrada;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Estado;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.models.Evento;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.repository.AsistenteRepository;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.repository.EntradaRepository;
import com.salesianostriana.dam.EjercicioEvaluacion16_01.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntradaService {

    private final EntradaRepository entradaRepository;
    private final AsistenteRepository asistenteRepository;
    private final EventoRepository eventoRepository;


    public List<Entrada>findAll(){
        return entradaRepository.findAll();
    }

    public Entrada comprarEntrada(CreateEntradaRequest dto){

        Asistente asistente = asistenteRepository.findById(dto.idAsistente()).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el asistente."));
        Evento evento = eventoRepository.findById(dto.idEvento()).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el evento"));

        if(evento.getEntradasVendidas()>= evento.getAforoMaximo()){
            throw new RuntimeException("No se puede comprar entradas si se ha superado el aforo.");
        }

        Entrada entrada = Entrada.builder()
                .asistente(asistente)
                .evento(evento)
                .estado(Estado.ACTIVA)
                .build();

        evento.setEntradasVendidas(evento.getEntradasVendidas()+1);
        eventoRepository.save(evento);

        return entradaRepository.save(entrada);
    }

    public Entrada cancelarEntrada(Long id){
        Entrada entrada = entradaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra la entrada"));
        Evento evento = eventoRepository.findById(entrada.getEvento().getId()).orElseThrow(() -> new EntityNotFoundException("No se encuentra el evento"));
        if(entrada.getEstado() == Estado.CANCELADA){
            throw new RuntimeException("No se puede cancelar una entrada cancelada");
        }

        evento.setEntradasVendidas(evento.getEntradasVendidas()-1);
        entrada.setEstado(Estado.CANCELADA);

        eventoRepository.save(evento);
        return entradaRepository.save(entrada);

    }

    public Page<Entrada> obtenerEntradasEvento(Long id, Pageable pageable){
        return entradaRepository.findEntradaByEvento_Id(id,pageable);
    }

}
