package com.example.segundaEntrega.controller;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Producto;
import com.example.segundaEntrega.entity.ProductoDto;
import com.example.segundaEntrega.entity.ProductoInsuficienteMesaggeDTO;
import com.example.segundaEntrega.service.ClienteService;
import com.example.segundaEntrega.service.ProductoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductoController {
    @Autowired
    ProductoService productoService;


    @SneakyThrows
    @GetMapping("/getproducto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable(value ="id") Long productoId){
        Producto producto = productoService.obtenerProductoporId(productoId);
        return ResponseEntity.ok().body(producto);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productoList = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok().body(productoList);
    }

    @PostMapping("/setProducto")
    public ResponseEntity<Producto> setProducto(@RequestBody Producto producto) {
        Producto productoAux = productoService.crearProducto(producto);
        return  ResponseEntity.ok().body(productoAux);
    }

    @PutMapping("/updateProducto")
    public ResponseEntity<Producto> updateProductoStock(@RequestBody Producto producto) {
        Producto productoModificado = productoService.modificarStockProducto(producto);
        return ResponseEntity.ok().body(productoModificado);
    }
    @PutMapping("/descontarStock")
    public ResponseEntity<ProductoInsuficienteMesaggeDTO> descontarStockProducto(@RequestBody @Validated ProductoDto productodto) {
        ProductoInsuficienteMesaggeDTO productoModificado = productoService.descontarStockProducto(productodto);

        return ResponseEntity.ok().body(productoModificado);
    }
    @DeleteMapping("/deleteProducto/{id}")
    public void deleteProducto(@PathVariable(value = "id") Long productoId) {
        productoService.borrarProducto(productoId);
    }
}
