package com.JosueGarNu.SpringForo.Domain.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombreUsuario,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password) {
}
