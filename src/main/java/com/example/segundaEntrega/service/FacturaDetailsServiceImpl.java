package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.FacturaDetails;
import com.example.segundaEntrega.repository.FacturaDetailsRepository;
import com.example.segundaEntrega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FacturaDetailsServiceImpl implements FacturaDetailsService{
    @Autowired
    FacturaDetailsRepository facturaDetailsRepository;
    @Override
    public FacturaDetails obtenerFacturaDetailsporId(Long id) {
        return facturaDetailsRepository.findById(id).get();
    }
}
