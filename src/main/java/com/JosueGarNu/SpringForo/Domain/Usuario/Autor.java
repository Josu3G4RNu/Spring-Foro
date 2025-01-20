package com.JosueGarNu.SpringForo.Domain.Usuario;

import com.JosueGarNu.SpringForo.Domain.Respuesta.Respuesta;
import com.JosueGarNu.SpringForo.Domain.Topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter @Setter @NoArgsConstructor
public class Autor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    // Debes hacerle HASH antes de ingresarla a la base de datos
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicosDondeHaInteractuado;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestasDadas;

    public Autor(DatosRegistroUsuario datosRegistroUsuario) {
        this.nombre = datosRegistroUsuario.nombreUsuario();
        this.email = datosRegistroUsuario.email();
        this.password = datosRegistroUsuario.password();
        this.topicosDondeHaInteractuado = new ArrayList<>();
        this.respuestasDadas = new ArrayList<>();
    }

    public Autor crearTopico(Topico topico) {
        this.topicosDondeHaInteractuado.add(topico);
        return this;
    }

    public void crearRespuesta(Respuesta respuesta) {
        if (!topicosDondeHaInteractuado.contains(respuesta.getTopico())) {
            this.topicosDondeHaInteractuado.add(respuesta.getTopico());
        }
        respuesta.setAutor(this);
        this.respuestasDadas.add(respuesta);
    }

    public void eliminarRespuesta(Respuesta respuesta){
        respuesta.setAutor(null);
        this.respuestasDadas.remove(respuesta);
    }

}
