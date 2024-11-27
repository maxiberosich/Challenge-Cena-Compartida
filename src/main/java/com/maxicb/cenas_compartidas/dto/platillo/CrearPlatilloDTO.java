package com.maxicb.cenas_compartidas.dto.platillo;

import com.maxicb.cenas_compartidas.model.TipoComida;
import jakarta.validation.constraints.NotBlank;

public record CrearPlatilloDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombrePlatillo,
        TipoComida tipoComida,
        String descripcion
) {
}
