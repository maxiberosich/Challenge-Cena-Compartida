package com.maxicb.cenas_compartidas.model;

import com.maxicb.cenas_compartidas.dto.CrearPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.DatosPlatilloDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlatillo;

    private String nombrePlatillo;

    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;

    private String nombreCocinero;
    private String descripcion;

    public Platillo(CrearPlatilloDTO crearPlatilloDTO) {
        this.nombrePlatillo = crearPlatilloDTO.nombrePlatillo();
        this.tipoComida = crearPlatilloDTO.tipoComida();
        this.nombreCocinero = crearPlatilloDTO.nombreCocinero();
        this.descripcion = crearPlatilloDTO.descripcion();
    }
}
