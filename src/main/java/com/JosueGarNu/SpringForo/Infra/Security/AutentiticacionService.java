package com.JosueGarNu.SpringForo.Infra.Security;

import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import com.JosueGarNu.SpringForo.Domain.Usuario.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutentiticacionService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByNombre(username);
    }
}
