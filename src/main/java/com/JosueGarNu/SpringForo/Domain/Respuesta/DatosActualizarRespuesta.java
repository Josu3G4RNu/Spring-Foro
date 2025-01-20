package com.JosueGarNu.SpringForo.Domain.Respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarRespuesta(

        @NotBlank
        String mensaje

) { }
