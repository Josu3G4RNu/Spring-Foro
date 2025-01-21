package com.JosueGarNu.SpringForo.Controller;

import com.JosueGarNu.SpringForo.Domain.Curso.Curso;
import com.JosueGarNu.SpringForo.Domain.Curso.CursoRepository;
import com.JosueGarNu.SpringForo.Domain.Curso.Materia;
import com.JosueGarNu.SpringForo.Domain.Topico.*;
import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import com.JosueGarNu.SpringForo.Domain.Usuario.AutorService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "jwtToken")
public class TopicoController {

    @Autowired
    AutorService autorService;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @GetMapping("/listado")
    public ResponseEntity<List<DatosListarTopico>> listarTopicos() {
        return ResponseEntity.ok().body(topicoService.listarTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDelTopico> mostrarTopicoEspecifico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.mostrarTopicoEspecifico(id));
    }

    @Transactional
    @PostMapping("/crear")
    public ResponseEntity<DatosListarTopico> crearTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
            UriComponentsBuilder uriBuilder) {
        Autor autorDelTopico = autorService.buscarAutor(datosRegistroTopico.nombreDelUsuario());
        Materia materia = Materia.obtenerMateria(datosRegistroTopico.materia());
        Curso cursoDelTopico = cursoRepository.findByNombre(materia);
        Topico topico = new Topico(datosRegistroTopico);
        topico.setAutor(autorDelTopico);
        topico.setCurso(cursoDelTopico);
        topicoRepository.save(topico);
        DatosListarTopico datosListarTopico = new DatosListarTopico(topico);
        URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosListarTopico);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<DatosListarTopico> modificarTopico(@PathVariable @Valid @NotNull Long id,
            @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        return ResponseEntity.ok(topicoService.modificarTopico(id, datosActualizarTopico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable @Valid @NotNull Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
