package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaDetailsDTOFactura {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    private ProductoDTOFactura productoDTOFactura;

    private int cantidad;

    private double totalParcial;
}
