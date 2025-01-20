package com.JosueGarNu.SpringForo.Domain.Respuesta;

public record DatosDeRespuestaParaUsuario(
        String mensaje,
        String fechaDeCreacion) {

    public DatosDeRespuestaParaUsuario(Respuesta respuesta){
        this(respuesta.getMensaje(), respuesta.getFechaDeCreacion());
    }
}
