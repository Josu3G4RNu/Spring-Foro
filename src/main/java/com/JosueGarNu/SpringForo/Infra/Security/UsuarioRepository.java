package com.JosueGarNu.SpringForo.Infra.Security;


import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Autor, Long> {

    UserDetails findByNombre(String nombre);
}
