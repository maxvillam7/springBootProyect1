package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClienteDTOInput {

    private Long id;

    private String nombre;

    private String apellidos;

    private Long dni;

    private String direccion;
}
