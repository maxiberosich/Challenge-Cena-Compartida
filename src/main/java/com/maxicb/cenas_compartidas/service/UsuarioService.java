package com.maxicb.cenas_compartidas.service;

import com.maxicb.cenas_compartidas.dto.usuario.ActualizarUsuarioDTO;
import com.maxicb.cenas_compartidas.dto.usuario.CrearUsuarioDTO;
import com.maxicb.cenas_compartidas.dto.usuario.DatosUsuarioDTO;
import com.maxicb.cenas_compartidas.model.Usuario;
import com.maxicb.cenas_compartidas.repository.UsuarioRepository;
import com.maxicb.cenas_compartidas.util.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public CrearUsuarioDTO crearUsuario(CrearUsuarioDTO crearUsuarioDTO){
        Usuario usuario = new Usuario(crearUsuarioDTO);
        usuarioRepository.save(usuario);
        return crearUsuarioDTO;
    }

    public List<DatosUsuarioDTO> obtenerTodosLosUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    public DatosUsuarioDTO buscarUsuarioPorId(Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException(("Usuario no encontrado")));
        return usuarioMapper.toDto(usuario);
    }

    public DatosUsuarioDTO buscarUsuarioPorNombre(String nombreUsuario){
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException(("Usuario no encontrado")));
        return usuarioMapper.toDto(usuario);
    }

    public ActualizarUsuarioDTO actualizarUsuario(Long idUsuario, ActualizarUsuarioDTO actualizarUsuarioDTO){
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombreUsuario(actualizarUsuarioDTO.nombreUsuario());
        usuario.setPassword(actualizarUsuarioDTO.password());
        usuario.setEmail(actualizarUsuarioDTO.email());

        usuario = usuarioRepository.save(usuario);

        return actualizarUsuarioDTO;
    }

    public void eliminarUsuario(Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

}
