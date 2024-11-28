package com.maxicb.cenas_compartidas.controller;

import com.maxicb.cenas_compartidas.dto.usuario.ActualizarUsuarioDTO;
import com.maxicb.cenas_compartidas.dto.usuario.CrearUsuarioDTO;
import com.maxicb.cenas_compartidas.dto.usuario.DatosUsuarioDTO;
import com.maxicb.cenas_compartidas.service.UsuarioService;
import com.maxicb.cenas_compartidas.util.UsuarioMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            summary = "Registrar usuario",
            description = "Registra un nuevo usuario en el sistema.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario registrado correctamente",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CrearUsuarioDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos, el formato del cuerpo no es válido")
            }
    )
    public CrearUsuarioDTO registrarUsuario(@RequestBody @Valid CrearUsuarioDTO crearUsuarioDTO){
        return usuarioService.crearUsuario(crearUsuarioDTO);
    }

    @GetMapping("/todos")
    @Operation(
            summary = "Mostrar todos los usuarios",
            description = "Recupera todos los usuarios registrados en el sistema.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Operación exitosa",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = DatosUsuarioDTO.class))))
            }
    )
    public List<DatosUsuarioDTO> obtenerTodosLosUsuarios(){
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{idUsuario}")
    @Operation(
            summary = "Buscar usuario por ID",
            description = "Busca un usuario por su ID único.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DatosUsuarioDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
            }
    )
    public DatosUsuarioDTO buscarUsuarioPorId(
            @Parameter(description = "ID del usuario a buscar", required = true)
            @PathVariable Long idUsuario){
        return usuarioService.buscarUsuarioPorId(idUsuario);
    }

    @GetMapping
    @Operation(
            summary = "Buscar usuario por nombre",
            description = "Busca un usuario por su nombre único.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DatosUsuarioDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
            }
    )
    public DatosUsuarioDTO buscarUsuarioPorNombre(
            @Parameter(description = "Nombre del usuario para buscar", required = true)
            @RequestParam String nombreUsuario){
        return usuarioService.buscarUsuarioPorNombre(nombreUsuario);
    }

    @PutMapping("/{idUsuario}")
    @Operation(
            summary = "Actualizar usuario",
            description = "Actualiza los datos de un usuario según su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ActualizarUsuarioDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos, el formato del cuerpo no es válido")
            }
    )
    public ActualizarUsuarioDTO actualizarUsuario(
            @Parameter(description = "ID del usuario que se quiere actualizar", required = true)
            @PathVariable Long idUsuario,
            @RequestBody @Valid ActualizarUsuarioDTO actualizarUsuarioDTO){
        return usuarioService.actualizarUsuario(idUsuario, actualizarUsuarioDTO);
    }

    @DeleteMapping("/{idUsuario}")
    @Operation(
            summary = "Eliminar usuario",
            description = "Elimina un usuario del sistema según su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
            }
    )
    public void eliminarUsuario(
            @Parameter(description = "ID del usuario a eliminar", required = true)
            @PathVariable Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }


}
