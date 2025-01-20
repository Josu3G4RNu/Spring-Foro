package com.JosueGarNu.SpringForo.Domain.Topico;

public record DatosTopicoParaHomeUsuario(String titulo, Estado estadoDelTopico) {
    public DatosTopicoParaHomeUsuario(Topico topico){
        this(topico.getTitulo(), topico.getEstado());
    }
}
