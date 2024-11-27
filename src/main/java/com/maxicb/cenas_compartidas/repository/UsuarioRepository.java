package com.maxicb.cenas_compartidas.repository;

import com.maxicb.cenas_compartidas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String nombre);
}
