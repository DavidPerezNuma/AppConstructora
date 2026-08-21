package com.constructora.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInteresadoResponseDTO {     

    private long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String mensaje;
    private LocalDateTime fechaRegistro;
    private String proyectoNombre;
    private Long proyectoId;
}
