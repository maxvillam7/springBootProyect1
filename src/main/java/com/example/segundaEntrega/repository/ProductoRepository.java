package com.example.segundaEntrega.repository;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    Optional<Producto> getProductoBynombre(String nombre);
}
