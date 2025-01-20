package com.JosueGarNu.SpringForo.Controller;

import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import com.JosueGarNu.SpringForo.Domain.Usuario.AutorRepository;
import com.JosueGarNu.SpringForo.Domain.Usuario.DatosRegistroUsuario;
import com.JosueGarNu.SpringForo.Domain.Usuario.DatosRespuestaUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

    @Transactional
    @PostMapping("/registrarse")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorRepository.save(new Autor(datosRegistroUsuario));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(autor);
        URI uri = uriComponentsBuilder.path("usuarios/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaUsuario);
    }


}
