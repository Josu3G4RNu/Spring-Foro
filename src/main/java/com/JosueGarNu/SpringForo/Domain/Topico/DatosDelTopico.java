package com.JosueGarNu.SpringForo.Domain.Topico;

import com.JosueGarNu.SpringForo.Domain.Respuesta.DatosDeRespuestaParaTopicos;
import com.JosueGarNu.SpringForo.Domain.Usuario.DatosRespuestaUsuario;

import java.util.List;

public record DatosDelTopico(
        Long id,
        String curso,
        String titulo,
        String descripcion,
        DatosRespuestaUsuario autor,
        String fechaDeCreacion,
        List<DatosDeRespuestaParaTopicos> respuestas,
        Estado estado
) {
    public DatosDelTopico(Topico topico) {
        this(topico.getId(), topico.getCurso().getMateriaEnEs(), topico.getTitulo(),
                topico.getDescripcion(), new DatosRespuestaUsuario(topico.getAutor()), topico.getFechaDeCreacion(),
                topico.getRespuestas().stream().map(DatosDeRespuestaParaTopicos::new).toList(),topico.getEstado());
    }
}
