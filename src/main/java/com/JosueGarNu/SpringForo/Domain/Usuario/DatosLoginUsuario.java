package com.JosueGarNu.SpringForo.Domain.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosLoginUsuario(
        @NotBlank
        String nombreUsuario,

        @NotBlank
        String password) {
}
