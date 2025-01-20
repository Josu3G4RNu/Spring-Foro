package com.JosueGarNu.SpringForo.Domain.Curso;

import com.JosueGarNu.SpringForo.Domain.Topico.DatosCursoTopico;

import java.util.List;

public record DatosListarCurso(String materia, List<DatosCursoTopico> listaTopicos) {

    public DatosListarCurso(Curso curso) {
        this(curso.getMateriaEnEs(), curso.getTopicos().stream().map(DatosCursoTopico::new).toList());
    }
}
