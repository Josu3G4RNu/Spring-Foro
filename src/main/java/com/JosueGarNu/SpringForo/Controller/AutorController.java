package com.JosueGarNu.SpringForo.Controller;

import com.JosueGarNu.SpringForo.Domain.Usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    AutorService autorService;

    @Transactional
    @PostMapping("/registrarse")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorRepository.save(new Autor(datosRegistroUsuario));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(autor);
        URI uri = uriComponentsBuilder.path("usuarios/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaUsuario);
    }

    @GetMapping("/{id}/home")
    public ResponseEntity<DatosHomeUsuario> mostrarPerfilDelUsuario(@PathVariable @Valid @NotNull Long id){
        return ResponseEntity.ok(autorService.mostrarPerfilDelUsuario(id));
    }

}
