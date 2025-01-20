package com.JosueGarNu.SpringForo.Domain.Usuario;

public record DatosRespuestaUsuario(Long id, String nombreUsuario) {

    public DatosRespuestaUsuario(Autor autor) {
        this(autor.getId(), autor.getNombre());
    }
}
