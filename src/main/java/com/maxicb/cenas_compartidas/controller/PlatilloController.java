package com.maxicb.cenas_compartidas.controller;

import com.maxicb.cenas_compartidas.dto.platillo.ActualizarPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.CrearPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.DatosPlatilloDTO;
import com.maxicb.cenas_compartidas.service.PlatilloService;
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
@RequestMapping("/platillo")
public class PlatilloController {

    @Autowired
    private PlatilloService platilloService;

    @PostMapping("/{idUsuario}/cargar-platillo")
    @Operation(
            summary = "Crear un platillo",
            description = "Crea un nuevo platillo asociado a un usuario mediante su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Platillo creado correctamente",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DatosPlatilloDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
            }
    )
    public DatosPlatilloDTO crearPlatillo(
            @Parameter(description = "ID del usuario que sube el platillo", required = true)
            @PathVariable Long idUsuario,
            @RequestBody @Valid CrearPlatilloDTO crearPlatilloDTO){
        return platilloService.crearPlatillo(crearPlatilloDTO, idUsuario);
    }

    @GetMapping("/todos")
    @Operation(
            summary = "Mostrar todos los platillos",
            description = "Recupera todos los platillos registrados.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Operación exitosa",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = DatosPlatilloDTO.class))))
            }
    )
    public List<DatosPlatilloDTO> mostrarTodosLosPlatillos(){
        return platilloService.todosLosPlatillos();
    }

    @GetMapping("/{idPlatillo}")
    @Operation(
            summary = "Mostrar platillo por ID",
            description = "Recupera un platillo específico mediante su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Platillo encontrado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DatosPlatilloDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Platillo no encontrado")
            }
    )
    public DatosPlatilloDTO mostrarPlatilloPorId(
            @Parameter(description = "ID del platillo a buscar", required = true)
            @PathVariable Long idPlatillo){
        return platilloService.buscarPlatilloPorId(idPlatillo);
    }

    @PutMapping("/{idUsuario}/{idPlatillo}")
    @Operation(
            summary = "Actualizar platillo",
            description = "Actualiza los detalles de un platillo existente según su ID y el ID del usuario.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Platillo actualizado correctamente",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DatosPlatilloDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Platillo no encontrado"),
                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
            }
    )
    public DatosPlatilloDTO actualizarPlatillo(
            @Parameter(description = "ID del usuario que actualiza el platillo", required = true)
            @PathVariable Long idUsuario,
            @Parameter(description = "ID del platillo a actualizar", required = true)
            @PathVariable Long idPlatillo,
            @RequestBody @Valid ActualizarPlatilloDTO actualizarPlatilloDTO){
        return platilloService.actualizarPlatillo(idPlatillo, actualizarPlatilloDTO, idUsuario);
    }

    @DeleteMapping("/{idPlatillo}")
    @Operation(
            summary = "Eliminar platillo",
            description = "Elimina un platillo mediante su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Platillo eliminado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Platillo no encontrado")
            })
    public void borrarPlatillo(
            @Parameter(description = "ID del platillo a eliminar", required = true)
            @PathVariable Long idPlatillo){
        platilloService.borrarPlatillo(idPlatillo);
    }

}
