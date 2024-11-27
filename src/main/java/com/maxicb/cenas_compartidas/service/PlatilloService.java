package com.maxicb.cenas_compartidas.service;

import com.maxicb.cenas_compartidas.dto.platillo.ActualizarPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.CrearPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.platillo.DatosPlatilloDTO;
import com.maxicb.cenas_compartidas.dto.usuario.DatosUsuarioDTO;
import com.maxicb.cenas_compartidas.model.Platillo;
import com.maxicb.cenas_compartidas.repository.PlatilloRepository;
import com.maxicb.cenas_compartidas.util.PlatilloMapper;
import com.maxicb.cenas_compartidas.util.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatilloService {

    @Autowired
    private PlatilloRepository platilloRepository;

    @Autowired
    private PlatilloMapper platilloMapper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public DatosPlatilloDTO crearPlatillo(CrearPlatilloDTO crearPlatilloDTO, Long idUsuario){
        DatosUsuarioDTO datosUsuarioDTO = usuarioService.buscarUsuarioPorId(idUsuario);
        Platillo platillo = new Platillo(crearPlatilloDTO, usuarioMapper.toEntity(datosUsuarioDTO));
        Platillo platilloGuardado = platilloRepository.save(platillo);
        return platilloMapper.toDto(platilloGuardado);
    }

    public List<DatosPlatilloDTO> todosLosPlatillos(){
        List<Platillo> platilloList = platilloRepository.findAll();
        return platilloList.stream()
                .map(platilloMapper::toDto)
                .collect(Collectors.toList());
    }

    public DatosPlatilloDTO buscarPlatilloPorId(Long idPlatillo){
        Platillo platillo = platilloRepository.findById(idPlatillo)
                .orElseThrow(() -> new RuntimeException(("Platillo no encontrado")));
        return platilloMapper.toDto(platillo);
    }

    public DatosPlatilloDTO actualizarPlatillo(Long idPlatillo, ActualizarPlatilloDTO actualizarPlatilloDTO, Long idUsuario){
        Platillo platilloEncontrado = platilloRepository.findById(idPlatillo)
                .orElseThrow(() -> new RuntimeException(("Platillo no encontrado")));

        DatosUsuarioDTO datosUsuarioDTO = usuarioService.buscarUsuarioPorId(idUsuario);

        platilloEncontrado.setNombrePlatillo(actualizarPlatilloDTO.nombrePlatillo());
        platilloEncontrado.setUsuario(usuarioMapper.toEntity(datosUsuarioDTO));
        platilloEncontrado.setTipoComida(actualizarPlatilloDTO.tipoComida());
        platilloEncontrado.setDescripcion(actualizarPlatilloDTO.descripcion());

        platilloRepository.save(platilloEncontrado);

        return platilloMapper.toDto(platilloEncontrado);
    }

    public void borrarPlatillo(Long idPlatillo){
        Platillo platillo = platilloRepository.findById(idPlatillo)
                .orElseThrow(() -> new RuntimeException(("Platillo no encontrado")));
        platilloRepository.delete(platillo);
    }

}
