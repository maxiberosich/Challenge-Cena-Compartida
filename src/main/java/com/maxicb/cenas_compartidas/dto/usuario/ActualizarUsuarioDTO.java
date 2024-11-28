package com.maxicb.cenas_compartidas.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ActualizarUsuarioDTO(
        @NotBlank(message = "Nombre de usuario no puede estar en blanco")
        @Schema(description = "El nombre de usuario para iniciar sesión", example = "Juan")
        String nombreUsuario,
        @NotBlank(message = "La contraseña no puede estar en blanco")
        @Schema(description = "La contraseña del usuario")
        String password,
        @NotBlank(message = "El email no puede estar en blanco")
        @Email(message = "El email debe tener un formato válido")
        @Schema(description = "El correo electrónico del usuario", example = "juanperez@correo.com")
        String email
) {
}
