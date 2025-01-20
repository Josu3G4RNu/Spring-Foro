package com.JosueGarNu.SpringForo.Domain.Respuesta;

import com.JosueGarNu.SpringForo.Domain.Usuario.DatosRespuestaUsuario;

public record DatosDeRespuestaParaTopicos(Long id, DatosRespuestaUsuario autor, DatosDeRespuestaParaUsuario respuesta) {

    public DatosDeRespuestaParaTopicos(Respuesta respuesta) {
        this(respuesta.getId(), new DatosRespuestaUsuario(respuesta.getAutor()),
                new DatosDeRespuestaParaUsuario(respuesta));
    }

}
