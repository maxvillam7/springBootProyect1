package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Producto;
import com.example.segundaEntrega.entity.ProductoDto;
import com.example.segundaEntrega.entity.ProductoInsuficienteMesaggeDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public Producto obtenerProductoporId(Long id);
    Producto crearProducto(Producto producto);

    Producto modificarStockProducto(Producto producto);

    ProductoInsuficienteMesaggeDTO descontarStockProducto(ProductoDto producto);
    void borrarProducto(Long id);

    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> getProductoBynombre(String nombre);
}
