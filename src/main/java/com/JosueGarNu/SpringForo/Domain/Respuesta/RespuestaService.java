package com.JosueGarNu.SpringForo.Domain.Respuesta;

import com.JosueGarNu.SpringForo.Domain.Topico.Topico;
import com.JosueGarNu.SpringForo.Domain.Topico.TopicoRepository;
import com.JosueGarNu.SpringForo.Domain.Usuario.Autor;
import com.JosueGarNu.SpringForo.Domain.Usuario.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

    public DatosDeRespuestaParaTopicos addRespuestaATopico(Long id, DatosRegistroRespuesta datosRegistroRespuesta) {
        boolean existe = topicoRepository.existeYEstaActivo(id);

        if (existe) {
            Respuesta respuesta = new Respuesta(datosRegistroRespuesta.respuesta());
            topicoRepository.getReferenceById(id).addRespuesta(respuesta);
            autorRepository.findByNombre(datosRegistroRespuesta.nombreDelAutor()).crearRespuesta(respuesta);
            respuestaRepository.save(respuesta);
            return new DatosDeRespuestaParaTopicos(respuesta);
        }
        return null;
    }

    public List<DatosDeRespuestaParaTopicos> listarRespuestasDeTopico(Long id) {
        boolean existe = topicoRepository.existeYEstaActivo(id);
        if (existe) {
            return topicoRepository.getReferenceById(id).getRespuestas().stream().map(DatosDeRespuestaParaTopicos::new).toList();
        }
        return null;
    }

    public List<DatosDeRespuestaParaUsuario> listarRespuestasDeUsuario(Long id) {
        Autor autor = autorRepository.getReferenceById(id);
        return autor.getRespuestasDadas().stream().map(DatosDeRespuestaParaUsuario::new).toList();
    }

    public DatosDeRespuestaParaTopicos editarRespuesta(Long id, DatosActualizarRespuesta mensaje) {
        boolean existe = topicoRepository.existeYEstaActivo(id);
        if (existe) {
            Respuesta respuesta = respuestaRepository.findByMensaje(mensaje.mensaje());
            respuesta.setMensaje(mensaje.mensaje());
            return new DatosDeRespuestaParaTopicos(respuesta);
        }
        return null;
    }

    public void eliminarRespuesta(Long id) {
        if (respuestaRepository.existsById(id)) {
            respuestaRepository.deleteById(id);
        }
    }
}
