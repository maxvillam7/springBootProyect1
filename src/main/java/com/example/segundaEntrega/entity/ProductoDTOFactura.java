package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTOFactura {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    private String nombre;

    private String description;

    private Double precioUnitario;

    private String status;

}
