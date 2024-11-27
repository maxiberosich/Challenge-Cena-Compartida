package com.maxicb.cenas_compartidas.model;

import com.maxicb.cenas_compartidas.dto.platillo.CrearPlatilloDTO;
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

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Platillo(CrearPlatilloDTO crearPlatilloDTO, Usuario usuario) {
        this.nombrePlatillo = crearPlatilloDTO.nombrePlatillo();
        this.tipoComida = crearPlatilloDTO.tipoComida();
        this.descripcion = crearPlatilloDTO.descripcion();
        this.usuario = usuario;
    }
}
