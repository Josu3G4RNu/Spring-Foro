package com.JosueGarNu.SpringForo.Domain.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNombre(Materia materia);
}
