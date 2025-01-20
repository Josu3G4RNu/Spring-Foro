package com.JosueGarNu.SpringForo.Domain.Topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public DatosDelTopico mostrarTopicoEspecifico(Long id) {
        if (topicoRepository.existeYEstaActivo(id)) {
            return new DatosDelTopico(topicoRepository.getReferenceById(id));
        }
        return null;
    }

    public List<DatosListarTopico> listarTopicos() {
        return topicoRepository.findByActivoTrue().stream().map(DatosListarTopico::new).toList();
    }

    public DatosListarTopico modificarTopico(Long id, DatosActualizarTopico datosActualizarTopico) {
        boolean existe = topicoRepository.existeYEstaActivo(id);

        if (existe) {
            Topico topico = topicoRepository.getReferenceById(id);
            topico.actualizarDatos(datosActualizarTopico);
            return new DatosListarTopico(topico);
        }
        return null;
    }

    public void eliminarTopico(Long id) {
        boolean existe = topicoRepository.existeYEstaActivo(id);

        if (existe) {
            Topico topico = topicoRepository.getReferenceById(id);
            topico.setEstado(Estado.CERRADO);
        }
    }
}
