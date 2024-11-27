package com.maxicb.cenas_compartidas.util;

import com.maxicb.cenas_compartidas.dto.DatosPlatilloDTO;
import com.maxicb.cenas_compartidas.model.Platillo;
import org.springframework.stereotype.Component;

@Component
public class PlatilloMapper {

    public DatosPlatilloDTO toDto(Platillo platillo){
        DatosPlatilloDTO datosPlatilloDTO = new DatosPlatilloDTO(platillo.getIdPlatillo(), platillo.getNombrePlatillo(),
                platillo.getTipoComida(), platillo.getNombreCocinero(), platillo.getDescripcion());
        return datosPlatilloDTO;
    }

    public Platillo toEntity(DatosPlatilloDTO datosPlatilloDTO){
        Platillo platillo = new Platillo();
        platillo.setIdPlatillo(datosPlatilloDTO.idPlatillo());
        platillo.setNombrePlatillo(datosPlatilloDTO.nombrePlatillo());
        platillo.setTipoComida(datosPlatilloDTO.tipoComida());
        platillo.setNombreCocinero(datosPlatilloDTO.nombreCocinero());
        platillo.setDescripcion(datosPlatilloDTO.descripcion());
        return platillo;
    }

}
