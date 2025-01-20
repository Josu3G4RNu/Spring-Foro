package com.JosueGarNu.SpringForo.Domain.Topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public DatosRespuestaTopico mostrarTopicoEspecifico(Long id){
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topicoRepository.getReferenceById(id));
        return datosRespuestaTopico;
    }

    public List<DatosRespuestaTopico> listarTopicos(){
        return topicoRepository.findByActivoTrue().stream().map(DatosRespuestaTopico::new).toList();
    }

}
