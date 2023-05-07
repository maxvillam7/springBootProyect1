package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDto {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    private Long id;
    @Min(0)
    private Long cantidad;
}

