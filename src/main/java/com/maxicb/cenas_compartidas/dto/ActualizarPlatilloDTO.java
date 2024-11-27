package com.maxicb.cenas_compartidas.dto;

import com.maxicb.cenas_compartidas.model.TipoComida;
import jakarta.validation.constraints.NotBlank;

public record ActualizarPlatilloDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombrePlatillo,
        TipoComida tipoComida,
        @NotBlank(message = "El nombre del cocinero no puede estar vacío")
        String nombreCocinero,
        String descripcion
) {
}
