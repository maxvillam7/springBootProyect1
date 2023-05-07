package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Empresa;
import com.example.segundaEntrega.entity.Factura;
import com.example.segundaEntrega.entity.FacturaDetails;

import java.util.List;


public interface FacturaDetailsService {
    public FacturaDetails obtenerFacturaDetailsporId(Long id);

}