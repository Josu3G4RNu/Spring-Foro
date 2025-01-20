package com.JosueGarNu.SpringForo.Domain.Topico;

import com.JosueGarNu.SpringForo.Domain.Usuario.DatosRespuestaUsuario;

public record DatosListarTopico(
        Long id,
        String curso,
        String titulo,
        String descripcion,
        DatosRespuestaUsuario autor,
        String fechaDeCreacion,
        Estado estado
) {
    public DatosListarTopico(Topico topico) {
        this(topico.getId(), topico.getCurso().getMateriaEnEs(), topico.getTitulo(),
                topico.getDescripcion(), new DatosRespuestaUsuario(topico.getAutor()), topico.getFechaDeCreacion(),
                topico.getEstado());
    }
}
