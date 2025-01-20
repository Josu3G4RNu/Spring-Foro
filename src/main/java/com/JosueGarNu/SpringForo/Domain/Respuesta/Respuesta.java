package com.JosueGarNu.SpringForo.Domain.Respuesta;

import com.JosueGarNu.SpringForo.Domain.Topico.Topico;
import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

//    public Respuesta(DTORespuesta datos){
//        this.mensaje = datos.mensaje;
//        // Para el topico lo que tengo que realizar es una busqueda
//        // que me retorne el topico al cual le estoy realizando una respuesta
//        this.horaDeCreacion = LocalDateTime.now();
//    }
}
