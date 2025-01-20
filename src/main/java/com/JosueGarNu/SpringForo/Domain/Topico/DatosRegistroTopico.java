package com.JosueGarNu.SpringForo.Domain.Topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank
        String materia,

        @NotBlank
        String titulo,

        @NotBlank
        String descripcion,

        @NotBlank
        String nombreDelUsuario
) { }
