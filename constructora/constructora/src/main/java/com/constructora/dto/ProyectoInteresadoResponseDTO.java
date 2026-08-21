package com.constructora.dto;

import java.math.BigDecimal;

import com.constructora.enums.EstadoProyecto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectoInteresadoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private Double ciudad;
    private BigDecimal precioDesde;
    private String imagenUrl;
    private EstadoProyecto estado;
    private Boolean destacado;
}
