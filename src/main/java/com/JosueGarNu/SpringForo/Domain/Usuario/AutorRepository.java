package com.JosueGarNu.SpringForo.Domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNombre(String nombreDelAutor);

}
