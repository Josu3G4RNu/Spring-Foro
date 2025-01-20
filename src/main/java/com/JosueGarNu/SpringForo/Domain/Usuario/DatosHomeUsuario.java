package com.JosueGarNu.SpringForo.Domain.Usuario;

import com.JosueGarNu.SpringForo.Domain.Respuesta.DatosDeRespuestaParaUsuario;
import com.JosueGarNu.SpringForo.Domain.Topico.DatosTopicoParaHomeUsuario;

import java.util.List;

public record DatosHomeUsuario(DatosRespuestaUsuario usuario, List<DatosTopicoParaHomeUsuario> topicos,
                               List<DatosDeRespuestaParaUsuario> respuestas) {

    public DatosHomeUsuario(Autor autor) {
        this(new DatosRespuestaUsuario(autor),
                autor.getTopicosDondeHaInteractuado().stream().map(DatosTopicoParaHomeUsuario::new).toList(),
                autor.getRespuestasDadas().stream().map(DatosDeRespuestaParaUsuario::new).toList());
    }
}
