package com.maxicb.cenas_compartidas.dto.platillo;

import com.maxicb.cenas_compartidas.model.TipoComida;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CrearPlatilloDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Schema(description = "El nombre del platillo", example = "Pizza")
        String nombrePlatillo,
        @Schema(description = "El tipo de comida", example = "PLATO_PRINCIPAL")
        TipoComida tipoComida,
        @Schema(description = "Se puede agregar una descripcion si se desea", example = "Pizza de pollo")
        String descripcion
) {
}
