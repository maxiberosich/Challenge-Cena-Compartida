package com.maxicb.cenas_compartidas.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;

public record DatosAutenticacionUsuario(
        @Schema(description = "El nombre de usuario para iniciar sesión", example = "Juan")
        String nombre,
        @Schema(description = "La contraseña del usuario")
        String password
) {
}
