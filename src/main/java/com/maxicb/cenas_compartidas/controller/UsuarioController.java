package com.maxicb.cenas_compartidas.controller;

import com.maxicb.cenas_compartidas.dto.usuario.ActualizarUsuarioDTO;
import com.maxicb.cenas_compartidas.dto.usuario.CrearUsuarioDTO;
import com.maxicb.cenas_compartidas.dto.usuario.DatosUsuarioDTO;
import com.maxicb.cenas_compartidas.service.UsuarioService;
import com.maxicb.cenas_compartidas.util.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @PostMapping
    public CrearUsuarioDTO registrarUsuario(@RequestBody @Valid CrearUsuarioDTO crearUsuarioDTO){
        return usuarioService.crearUsuario(crearUsuarioDTO);
    }

    @GetMapping("/todos")
    public List<DatosUsuarioDTO> obtenerTodosLosUsuarios(){
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public DatosUsuarioDTO buscarUsuarioPorId(@PathVariable Long idUsuario){
        return usuarioService.buscarUsuarioPorId(idUsuario);
    }

    @GetMapping
    public DatosUsuarioDTO buscarUsuarioPorNombre(@RequestParam String nombreUsuario){
        return usuarioService.buscarUsuarioPorNombre(nombreUsuario);
    }

    @PutMapping("/{idUsuario}")
    public ActualizarUsuarioDTO actualizarUsuario(
            @PathVariable Long idUsuario,
            @RequestBody @Valid ActualizarUsuarioDTO actualizarUsuarioDTO){
        return usuarioService.actualizarUsuario(idUsuario, actualizarUsuarioDTO);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }

}
