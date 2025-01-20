package com.JosueGarNu.SpringForo.Controller;

import com.JosueGarNu.SpringForo.Domain.Usuario.*;
import com.JosueGarNu.SpringForo.Infra.Security.DatosToken;
import com.JosueGarNu.SpringForo.Infra.Security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class AutorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

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

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosLoginUsuario datosLoginUsuario){
        Authentication token = new UsernamePasswordAuthenticationToken(datosLoginUsuario.nombreUsuario(), datosLoginUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(token);
        var JWTtoken = tokenService.generarToken((Autor) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok().body(new DatosToken(JWTtoken));
    }

    @GetMapping("/{id}/home")
    public ResponseEntity<DatosHomeUsuario> mostrarPerfilDelUsuario(@PathVariable @Valid @NotNull Long id){
        return ResponseEntity.ok(autorService.mostrarPerfilDelUsuario(id));
    }

}
