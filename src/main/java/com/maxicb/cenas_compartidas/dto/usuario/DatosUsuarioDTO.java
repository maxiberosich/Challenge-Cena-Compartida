package com.maxicb.cenas_compartidas.dto.usuario;

import com.maxicb.cenas_compartidas.dto.platillo.DatosPlatilloDTO;

import java.util.List;

public record DatosUsuarioDTO(
        Long idUsuario,
        String nombreUsuario,
        List<DatosPlatilloDTO> listaPlatillos
) {
}
