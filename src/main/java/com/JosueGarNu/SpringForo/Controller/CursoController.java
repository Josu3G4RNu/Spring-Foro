package com.JosueGarNu.SpringForo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JosueGarNu.SpringForo.Domain.Curso.CursoService;
import com.JosueGarNu.SpringForo.Domain.Curso.DatosListarCurso;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("cursos")
@SecurityRequirement(name = "jwtToken")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<String> listarCursos() {
        return cursoService.enlistarCursos();
    }

    @GetMapping("/topicos")
    public List<DatosListarCurso> listarCursosYTopicos() {
        return cursoService.enlistarCursosConTopicos();
    }

}
