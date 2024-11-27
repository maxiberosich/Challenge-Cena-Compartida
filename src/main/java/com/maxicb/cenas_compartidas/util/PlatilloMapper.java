package com.maxicb.cenas_compartidas.util;

import com.maxicb.cenas_compartidas.dto.platillo.ActualizarPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.CrearPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.DatosPlatilloDTO;
import com.maxicb.cenas_compartidas.model.Platillo;
import com.maxicb.cenas_compartidas.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class PlatilloMapper {

    public DatosPlatilloDTO toDto(Platillo platillo){
        return new DatosPlatilloDTO(
                platillo.getIdPlatillo(),
                platillo.getNombrePlatillo(),
                platillo.getTipoComida(),
                platillo.getUsuario().getNombreUsuario(),
                platillo.getDescripcion()
        );
    }

//    public Platillo toEntity(DatosPlatilloDTO datosPlatilloDTO){
//        Platillo platillo = new Platillo();
//        platillo.setIdPlatillo(datosPlatilloDTO.idPlatillo());
//        platillo.setNombrePlatillo(datosPlatilloDTO.nombrePlatillo());
//        platillo.setTipoComida(datosPlatilloDTO.tipoComida());
//        platillo.setUsuario(datosPlatilloDTO.nombreUsuario());
//        platillo.setDescripcion(datosPlatilloDTO.descripcion());
//        return platillo;
//    }

    public Platillo toEntity(CrearPlatilloDTO crearPlatilloDTO, Usuario usuario) {
        Platillo platillo = new Platillo();
        platillo.setNombrePlatillo(crearPlatilloDTO.nombrePlatillo());
        platillo.setTipoComida(crearPlatilloDTO.tipoComida());
        platillo.setUsuario(usuario); // Aquí se asigna el usuario
        platillo.setDescripcion(crearPlatilloDTO.descripcion());
        return platillo;
    }

    public Platillo toEntity(Long idPlatillo, ActualizarPlatilloDTO actualizarPlatilloDTO, Usuario usuario) {
        Platillo platillo = new Platillo();
        platillo.setIdPlatillo(idPlatillo);
        platillo.setNombrePlatillo(actualizarPlatilloDTO.nombrePlatillo());
        platillo.setTipoComida(actualizarPlatilloDTO.tipoComida());
        platillo.setUsuario(usuario); // Aquí se asigna el usuario
        platillo.setDescripcion(actualizarPlatilloDTO.descripcion());
        return platillo;
    }

}
