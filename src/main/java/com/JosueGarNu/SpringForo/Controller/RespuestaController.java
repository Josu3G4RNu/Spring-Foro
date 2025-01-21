package com.JosueGarNu.SpringForo.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.JosueGarNu.SpringForo.Domain.Respuesta.DatosActualizarRespuesta;
import com.JosueGarNu.SpringForo.Domain.Respuesta.DatosDeRespuestaParaTopicos;
import com.JosueGarNu.SpringForo.Domain.Respuesta.DatosDeRespuestaParaUsuario;
import com.JosueGarNu.SpringForo.Domain.Respuesta.DatosRegistroRespuesta;
import com.JosueGarNu.SpringForo.Domain.Respuesta.RespuestaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/topicos/{id}/respuestas")
@SecurityRequirement(name = "jwtToken")
public class RespuestaController {

    @Autowired
    RespuestaService respuestaService;

    @GetMapping()
    public ResponseEntity<List<DatosDeRespuestaParaTopicos>> listarRespuestaDeTopico(
            @PathVariable @Valid @NotNull Long id) {
        return ResponseEntity.ok(respuestaService.listarRespuestasDeTopico(id));
    }

    @GetMapping
    @RequestMapping("/user/{idU}")
    public ResponseEntity<List<DatosDeRespuestaParaUsuario>> listarRespuestasDeUsuario(
            @PathVariable @Valid @NotNull Long idU) {
        return ResponseEntity.ok(respuestaService.listarRespuestasDeUsuario(idU));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<DatosDeRespuestaParaTopicos> crearRespuesta(@PathVariable @Valid @NotNull Long id,
            @RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
            UriComponentsBuilder uriBuilder) {
        DatosDeRespuestaParaTopicos data = respuestaService.addRespuestaATopico(id, datosRegistroRespuesta);
        URI uri = uriBuilder.path("/topicos/{id}/respuestas/{idR}").buildAndExpand(id, data.id()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DatosDeRespuestaParaTopicos> editarRespuesta(@PathVariable @Valid @NotNull Long id,
            @RequestBody DatosActualizarRespuesta mensaje) {
        return ResponseEntity.ok(respuestaService.editarRespuesta(id, mensaje));
    }

    @Transactional
    @DeleteMapping("/{idR}")
    public ResponseEntity eliminarRespuesta(@PathVariable @Valid @NotNull Long id,
            @PathVariable @Valid @NotNull Long idR) {
        respuestaService.eliminarRespuesta(idR);
        return ResponseEntity.noContent().build();
    }
}
