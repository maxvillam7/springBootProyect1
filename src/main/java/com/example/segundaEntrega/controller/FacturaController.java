package com.example.segundaEntrega.controller;

import com.example.segundaEntrega.entity.*;
import com.example.segundaEntrega.service.FacturaService;
import com.example.segundaEntrega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {
    @Autowired
    FacturaService facturaService;
    @GetMapping("/getFactura/{id}")
    public ResponseEntity<Factura> getFacurabyId(@PathVariable(value ="id") Long id) {
        Factura producto = facturaService.obtenerFacturaporId(id);
        return ResponseEntity.ok().body(producto);
    }
    @GetMapping("/getFacturasPerClientId/{id}")
    public ResponseEntity<List<Factura>> getFacurasbyIdOfCliente(@PathVariable(value ="id") Long id) {
        List<Factura> listFacturas = facturaService.getFacturaByClientId(id);
        return ResponseEntity.ok().body(listFacturas);
    }
    @PostMapping("/crearFactura")
    public ResponseEntity<FacturaDTO> newFactura(@RequestBody @Validated FacturaInputProductsDTO facturaProducts) {
        FacturaDTO facturaDTO = facturaService.newFactura(facturaProducts);

        return ResponseEntity.ok().body(facturaDTO);
    }
}
