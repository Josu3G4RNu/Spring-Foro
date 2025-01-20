package com.JosueGarNu.SpringForo.Domain.Respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroRespuesta(

        @NotBlank
        String nombreDelAutor,

        @NotBlank
        String respuesta
) {
}
