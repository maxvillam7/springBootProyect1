package com.example.segundaEntrega.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaDTO {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    private long numeroFactura;

    private Date fecha;

    private String facturaType;

    private Double facturaTotal;

    private String facturaStatus;//Rechazado , Aprobado

    private ClienteDTOFactura clienteFact;

    private List<FacturaDetailsDTOFactura> detalleFactura;

    private EmpresaDTOFactura empresaFact;

    public FacturaDetailsDTOFactura agregarFacturaDetailsDTOFactura(FacturaDetailsDTOFactura facturaDetailsAux){
        getDetalleFactura().add(facturaDetailsAux);
        return facturaDetailsAux;
    }
}
