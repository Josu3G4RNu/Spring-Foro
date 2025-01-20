package com.JosueGarNu.SpringForo.Controller;

import com.JosueGarNu.SpringForo.Domain.Respuesta.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos/{id}/respuestas")
public class RespuestaController {

    @Autowired
    RespuestaService respuestaService;

    @GetMapping()
    public ResponseEntity<List<DatosDeRespuestaParaTopicos>> listarRespuestaDeTopico(@PathVariable @Valid @NotNull Long id){
        return ResponseEntity.ok(respuestaService.listarRespuestasDeTopico(id));
    }

    @GetMapping
    @RequestMapping("/user/{idU}")
    public ResponseEntity<List<DatosDeRespuestaParaUsuario>> listarRespuestasDeUsuario(@PathVariable @Valid @NotNull Long idU){
        return ResponseEntity.ok(respuestaService.listarRespuestasDeUsuario(idU));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<DatosDeRespuestaParaTopicos> crearRespuesta(@PathVariable @Valid @NotNull Long id,
                                                                      @RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
                                                                      UriComponentsBuilder uriBuilder){
        DatosDeRespuestaParaTopicos data = respuestaService.addRespuestaATopico(id, datosRegistroRespuesta);
        URI uri = uriBuilder.path("/topicos/{id}/respuestas/{idR}").buildAndExpand(id, data.id()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DatosDeRespuestaParaTopicos> editarRespuesta(@PathVariable @Valid @NotNull Long id,
                                                                       @RequestBody DatosActualizarRespuesta mensaje){
        return ResponseEntity.ok(respuestaService.editarRespuesta(id, mensaje));
    }

    @Transactional
    @DeleteMapping("/{idR}")
    public ResponseEntity eliminarRespuesta(@PathVariable @Valid @NotNull Long id, @PathVariable @Valid @NotNull Long idR) {
        respuestaService.eliminarRespuesta(idR);
        return ResponseEntity.noContent().build();
    }
}
