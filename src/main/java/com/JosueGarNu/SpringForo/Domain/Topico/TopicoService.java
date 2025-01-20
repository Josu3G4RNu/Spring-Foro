package com.JosueGarNu.SpringForo.Domain.Topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public DatosRespuestaTopico mostrarTopicoEspecifico(Long id){
        return new DatosRespuestaTopico(topicoRepository.getReferenceById(id));
    }

    public List<DatosRespuestaTopico> listarTopicos(){
        return topicoRepository.findByActivoTrue().stream().map(DatosRespuestaTopico::new).toList();
    }

    public DatosRespuestaTopico modificarTopico(Long id, DatosActualizarTopico datosActualizarTopico){
        boolean existe = topicoRepository.existsById(id);

        if(existe){
            Topico topico = topicoRepository.getReferenceById(id);
            topico.actualizarDatos(datosActualizarTopico);
            return new DatosRespuestaTopico(topico);
        }
        return null;
    }

    public void eliminarTopico(Long id) {
        boolean existe = topicoRepository.existsById(id);

        if(existe){
            Topico topico = topicoRepository.getReferenceById(id);
            topico.setEstado(Estado.CERRADO);
        }
    }
}
