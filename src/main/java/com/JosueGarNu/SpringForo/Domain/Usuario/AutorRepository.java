package com.JosueGarNu.SpringForo.Domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNombre(String nombreDelAutor);


}
