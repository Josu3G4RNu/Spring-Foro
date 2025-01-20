package com.JosueGarNu.SpringForo.Domain.Topico;

import com.JosueGarNu.SpringForo.Domain.Curso.Curso;
import com.JosueGarNu.SpringForo.Domain.Respuesta.Respuesta;
import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Curso curso;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Column(unique = true)
    private String descripcion;

    @NotNull
    @ManyToOne
    // Es quien crea el topico, por lo que su metodo POST de topico debe ser llamado por una funcion de Autor
    // y asignarse asi mismo como su autor
    private Autor autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    private String fechaDeCreacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private Boolean activo;

    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.descripcion = datos.descripcion();
        this.respuestas = new ArrayList<>();
        //Formatear la fecha a 19:00 | 18 de agosto del 2015
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a | dd-MMM-yyyy"));
        this.estado = Estado.ABIERTO;
        this.activo = true;
    }

    public void setAutor(Autor autor) {
        this.autor = autor.crearTopico(this);
    }

    public void setCurso(Curso curso) {
        this.curso = curso.addTopico(this);
    }

    public void setEstado(Estado estado) {
        if (estado == Estado.CERRADO) {
            activo = false;
        }
        this.estado = estado;
    }

    public void addRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
        respuesta.setTopico(this);
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.descripcion = datosActualizarTopico.descripcion();
        setEstado(datosActualizarTopico.estado());
    }

    public void eliminarRespuesta(Respuesta respuesta) {
        respuesta.setTopico(null);
        this.respuestas.remove(respuesta);
    }
}
