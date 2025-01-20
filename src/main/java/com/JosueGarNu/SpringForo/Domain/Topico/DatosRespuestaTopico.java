package com.JosueGarNu.SpringForo.Domain.Topico;

import com.JosueGarNu.SpringForo.Domain.Respuesta.Respuesta;
import com.JosueGarNu.SpringForo.Domain.Usuario.DatosRespuestaUsuario;

import java.util.List;

public record DatosRespuestaTopico(
        Long id,
        String curso,
        String titulo,
        String descripcion,
        DatosRespuestaUsuario autor,
        String fechaDeCreacion,
        List<Respuesta> respuestas,
        Estado estado
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getCurso().getMateriaEnEs(), topico.getTitulo(),
                topico.getDescripcion(), new DatosRespuestaUsuario(topico.getAutor()), topico.getFechaDeCreacion(),
                topico.getRespuestas(), topico.getEstado());
    }
}
