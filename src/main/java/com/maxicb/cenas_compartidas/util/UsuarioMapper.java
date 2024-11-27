package com.maxicb.cenas_compartidas.util;

import com.maxicb.cenas_compartidas.dto.usuario.DatosUsuarioDTO;
import com.maxicb.cenas_compartidas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    @Autowired
    private PlatilloMapper platilloMapper;

    public DatosUsuarioDTO toDto(Usuario usuario){
        DatosUsuarioDTO datosUsuarioDTO = new DatosUsuarioDTO(usuario.getIdUsuario(),
                usuario.getNombreUsuario(), usuario.getListaPlatillos().stream()
                .map(platilloMapper::toDto)
                .collect(Collectors.toList()));
        return datosUsuarioDTO;
    }

    public Usuario toEntity(DatosUsuarioDTO datosUsuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(datosUsuarioDTO.idUsuario());
        usuario.setNombreUsuario(datosUsuarioDTO.nombreUsuario());
        return usuario;
    }

}
