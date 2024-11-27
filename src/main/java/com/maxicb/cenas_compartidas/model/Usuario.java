package com.maxicb.cenas_compartidas.model;

import com.maxicb.cenas_compartidas.dto.usuario.CrearUsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombreUsuario;
    private String password;
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Platillo> listaPlatillos;

    public Usuario(CrearUsuarioDTO crearUsuarioDTO) {
        this.nombreUsuario = crearUsuarioDTO.nombreUsuario();
        this.password = crearUsuarioDTO.password();
        this.email = crearUsuarioDTO.email();
    }
}
