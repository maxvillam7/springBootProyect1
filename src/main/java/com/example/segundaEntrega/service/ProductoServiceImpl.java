package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.*;
import com.example.segundaEntrega.repository.EmpresaRepository;
import com.example.segundaEntrega.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    ProductoRepository productoRepository;


    @Override
    public Producto obtenerProductoporId(Long id) {
        Producto auxEmpresa=productoRepository.findById(id).get();
        return auxEmpresa;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        Producto productoAux=productoRepository.save(producto);
        return productoAux;
    }

    @Override
    public Producto modificarStockProducto(Producto producto) {
        Producto prductoModif = productoRepository.getById(producto.getIdproducto());
        prductoModif.setCantStock(producto.getCantStock());
        return productoRepository.save(prductoModif);
    }

    @Override
    public ProductoInsuficienteMesaggeDTO descontarStockProducto(ProductoDto producto) {
        Producto productoFind=productoRepository.getReferenceById(producto.getId());
        Long cantidadDeStock=productoFind.getCantStock();
        ProductoInsuficienteMesaggeDTO productoInsuficienteMesaggeDTO=new ProductoInsuficienteMesaggeDTO();

        if (cantidadDeStock>=producto.getCantidad()){
            productoFind.setCantStock(cantidadDeStock-producto.getCantidad());
            productoInsuficienteMesaggeDTO.setRestante(productoFind.getCantStock());
            productoInsuficienteMesaggeDTO.setName(productoFind.getNombre());
            productoInsuficienteMesaggeDTO.setMessage("Cantidad en Stock (Se desconto en la BD)");
            productoRepository.save(productoFind);
            return productoInsuficienteMesaggeDTO ;
        }
        else{
            productoInsuficienteMesaggeDTO.setRestante(productoFind.getCantStock());
            productoInsuficienteMesaggeDTO.setName(productoFind.getNombre());
            productoInsuficienteMesaggeDTO.setMessage("No hay en Stock");
            return productoInsuficienteMesaggeDTO ;
        }
    }

    @Override
    public void borrarProducto(Long id) {
        Producto producto = productoRepository.getById(id);
        log.info("Se va a borrar el cliente {}", producto.getNombre());
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoBynombre(String nombre){
        return productoRepository.getProductoBynombre(nombre);
    }
}
