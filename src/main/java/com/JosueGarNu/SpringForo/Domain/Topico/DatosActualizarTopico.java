package com.JosueGarNu.SpringForo.Domain.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String descripcion,

        @NotNull
        Estado estado
) {
}
