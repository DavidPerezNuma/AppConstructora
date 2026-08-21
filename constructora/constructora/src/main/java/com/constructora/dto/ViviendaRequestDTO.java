package com.constructora.dto;

import com.constructora.enums.TipoVivienda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViviendaRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotNull(message = "El tipo de vivienda es obligatorio")
    private TipoVivienda tipo;

    @NotNull(message = "El número de habitaciones es obligatorio")
    @Positive(message = "El número de habitaciones debe ser mayor a cero")
    private Integer habitaciones;

    @NotNull(message = "El número de baños es obligatorio")
    @Positive(message = "El número de baños debe ser mayor a cero")
    private Integer banos;

    @NotNull(message = "El área es obligatoria")
    @Positive(message = "El área debe ser mayor a cero")
    private Double area;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    private Double precio;

    private String imagenUrl;

    private Boolean disponible;

    @NotNull(message = "El proyecto es obligatorio")
    private Long proyectoId;
}
