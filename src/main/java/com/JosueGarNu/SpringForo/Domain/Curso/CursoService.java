package com.JosueGarNu.SpringForo.Domain.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public List<String> enlistarCursos(){
        return cursoRepository.findAll().stream().map(Curso::getMateriaEnEs).toList();
    }

    public List<DatosListarCurso> enlistarCursosConTopicos(){
       return cursoRepository.findAll().stream().map(DatosListarCurso::new).toList();
    }

}
