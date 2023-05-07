package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDTOFactura {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO

    private String nombre;

    private Long ruc;

    private String rubro;
}
