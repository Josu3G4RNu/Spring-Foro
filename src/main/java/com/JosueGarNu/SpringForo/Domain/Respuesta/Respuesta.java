package com.JosueGarNu.SpringForo.Domain.Respuesta;

import com.JosueGarNu.SpringForo.Domain.Topico.Topico;
import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Respuestas")
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Topico topico;

    @ManyToOne
    private Autor autor;

    private String mensaje;
    private String fechaDeCreacion;

    public Respuesta(String mensaje) {
        this.mensaje = mensaje;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a | dd-MMM-yyyy"));
    }


    public void eliminar() {
        autor.eliminarRespuesta(this);
        topico.eliminarRespuesta(this);
    }
}
