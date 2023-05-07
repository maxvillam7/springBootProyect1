package com.example.segundaEntrega.repository;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {

    @Query("SELECT s FROM factura s where s.clienteFact.nombre = :nombre")
    List<Factura> getFacturaByClientId(@Param("nombre") String nombre);
}
