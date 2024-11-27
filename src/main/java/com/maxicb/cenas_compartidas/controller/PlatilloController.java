package com.maxicb.cenas_compartidas.controller;

import com.maxicb.cenas_compartidas.dto.platillo.ActualizarPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.CrearPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.DatosPlatilloDTO;
import com.maxicb.cenas_compartidas.service.PlatilloService;
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
    public DatosPlatilloDTO crearPlatillo(
            @PathVariable Long idUsuario,
            @RequestBody @Valid CrearPlatilloDTO crearPlatilloDTO){
        return platilloService.crearPlatillo(crearPlatilloDTO, idUsuario);
    }

    @GetMapping("/todos")
    public List<DatosPlatilloDTO> mostrarTodosLosPlatillos(){
        return platilloService.todosLosPlatillos();
    }

    @GetMapping("/{idPlatillo}")
    public DatosPlatilloDTO mostrarPlatilloPorId(@PathVariable Long idPlatillo){
        return platilloService.buscarPlatilloPorId(idPlatillo);
    }

    @PutMapping("/{idUsuario}/{idPlatillo}")
    public DatosPlatilloDTO actualizarPlatillo(
            @PathVariable Long idUsuario,
            @PathVariable Long idPlatillo,
            @RequestBody @Valid ActualizarPlatilloDTO actualizarPlatilloDTO){
        return platilloService.actualizarPlatillo(idPlatillo, actualizarPlatilloDTO, idUsuario);
    }

    @DeleteMapping("/{idPlatillo}")
    public void borrarPlatillo(@PathVariable Long idPlatillo){
        platilloService.borrarPlatillo(idPlatillo);
    }

}
