package com.example.segundaEntrega.entity;

import lombok.*;

import javax.validation.constraints.Min;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoInsuficienteMesaggeDTO {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    private String name;
    @Min(0)
    private Long restante;

    private String message;
}
