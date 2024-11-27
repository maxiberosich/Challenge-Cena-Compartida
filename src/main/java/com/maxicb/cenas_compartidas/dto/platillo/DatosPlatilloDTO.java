package com.maxicb.cenas_compartidas.dto.platillo;

import com.maxicb.cenas_compartidas.model.TipoComida;

public record DatosPlatilloDTO(
        Long idPlatillo,
        String nombrePlatillo,
        TipoComida tipoComida,
        String nombreUsuario,
        String descripcion
) {
}
