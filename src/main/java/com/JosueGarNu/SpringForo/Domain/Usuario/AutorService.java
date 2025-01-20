package com.JosueGarNu.SpringForo.Domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public Autor buscarAutor(String nombreDelAutor){
        return autorRepository.findByNombre(nombreDelAutor);
    }

    public DatosHomeUsuario mostrarPerfilDelUsuario(Long id){
        Autor autor = autorRepository.getReferenceById(id);
        return new DatosHomeUsuario(autor);
    }

}
