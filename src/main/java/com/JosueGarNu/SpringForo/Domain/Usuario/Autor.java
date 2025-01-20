package com.JosueGarNu.SpringForo.Domain.Usuario;

import com.JosueGarNu.SpringForo.Domain.Respuesta.Respuesta;
import com.JosueGarNu.SpringForo.Domain.Topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter @Setter @NoArgsConstructor
public class Autor implements UserDetails {


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
    private String clave;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicosDondeHaInteractuado;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestasDadas;

    public Autor(DatosRegistroUsuario datosRegistroUsuario) {
        this.nombre = datosRegistroUsuario.nombreUsuario();
        this.email = datosRegistroUsuario.email();
        this.clave = datosRegistroUsuario.password();
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
