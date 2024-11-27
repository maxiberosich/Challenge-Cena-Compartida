package com.maxicb.cenas_compartidas.controller;

import com.maxicb.cenas_compartidas.dto.ActualizarPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.CrearPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.DatosPlatilloDTO;
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

    @PostMapping
    public DatosPlatilloDTO crearPlatillo(@RequestBody @Valid CrearPlatilloDTO crearPlatilloDTO){
        return platilloService.crearPlatillo(crearPlatilloDTO);
    }

    @GetMapping("/todos")
    public List<DatosPlatilloDTO> mostrarTodosLosPlatillos(){
        return platilloService.todosLosPlatillos();
    }

    @GetMapping("/{idPlatillo}")
    public DatosPlatilloDTO mostrarPlatilloPorId(@PathVariable Long idPlatillo){
        return platilloService.buscarPlatilloPorId(idPlatillo);
    }

    @PutMapping("/{idPlatillo}")
    public DatosPlatilloDTO actualizarPlatillo(
            @PathVariable Long idPlatillo,
            @RequestBody @Valid ActualizarPlatilloDTO actualizarPlatilloDTO){
        return platilloService.actualizarPlatillo(idPlatillo, actualizarPlatilloDTO);
    }

    @DeleteMapping("/{idPlatillo}")
    public void borrarPlatillo(@PathVariable Long idPlatillo){
        platilloService.borrarPlatillo(idPlatillo);
    }

}
