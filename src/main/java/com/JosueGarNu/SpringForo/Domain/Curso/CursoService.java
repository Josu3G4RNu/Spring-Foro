package com.JosueGarNu.SpringForo.Domain.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Curso encontrarCurso(Materia materia){
        return cursoRepository.findByNombre(materia);
    }

}
