package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTOFactura {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO

    private String nombre;

    private String apellidos;

    private Long dni;

    private String direccion;

}
