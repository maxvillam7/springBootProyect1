package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Factura;
import com.example.segundaEntrega.entity.FacturaDTO;
import com.example.segundaEntrega.entity.FacturaInputProductsDTO;
import com.example.segundaEntrega.entity.Producto;

import java.util.List;

public interface FacturaService {
    public Factura obtenerFacturaporId(Long id);

    FacturaDTO newFactura(FacturaInputProductsDTO facturaInputProductsDTO);
    List<Factura> getFacturaByClientId(Long id);
}