package com.JosueGarNu.SpringForo.Domain.Curso;

import com.JosueGarNu.SpringForo.Domain.Topico.Topico;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Cursos")
@NoArgsConstructor
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Materia nombre;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicos;

    public String getMateriaEnEs(){
        return nombre.getMateriaEs();
    }

    public Curso addTopico(Topico topico){
        this.topicos.add(topico);
        return this;
    }
}
