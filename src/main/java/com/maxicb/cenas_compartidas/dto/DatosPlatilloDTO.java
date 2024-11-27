package com.maxicb.cenas_compartidas.dto;

import com.maxicb.cenas_compartidas.model.TipoComida;

public record DatosPlatilloDTO(
        Long idPlatillo,
        String nombrePlatillo,
        TipoComida tipoComida,
        String nombreCocinero,
        String descripcion
) {
}
