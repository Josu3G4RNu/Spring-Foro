package com.JosueGarNu.SpringForo.Domain.Topico;

import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;

public record DatosCursoTopico(Long id, String titulo, String autor) {
    public DatosCursoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getAutor().getNombre());
    }
}
