package com.example.segundaEntrega.entity;

import lombok.*;

import javax.validation.constraints.Min;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoInputDTO {
    private Long id;

    private String nombre;

    @Min(0)
    private Integer cantidad;
}
