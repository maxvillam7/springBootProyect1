package com.example.segundaEntrega.entity;


import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaInputProductsDTO {
        private ClienteDTOInput clienteData;

        private ArrayList<ProductoInputDTO> productoList;


}
