package com.constructora.dto;

import java.math.BigDecimal;

import com.constructora.enums.EstadoProyecto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectoInteresadoRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    private String direccion;

    @NotNull(message = "La ciudad es obligatoria")
    private String ciudad;

    @NotNull(message = "El precio desde es obligatorio")
    @Positive(message = "El precio desde debe ser mayor a cero")
    private BigDecimal precioDesde;

    private String imagenUrl;

    @NotNull(message = "El estado es obligatorio")
    private EstadoProyecto estado;

    private Boolean destacado;
}
