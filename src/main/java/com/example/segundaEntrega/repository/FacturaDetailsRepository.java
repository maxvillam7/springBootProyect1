package com.example.segundaEntrega.repository;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Factura;
import com.example.segundaEntrega.entity.FacturaDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetailsRepository extends JpaRepository<FacturaDetails,Long> {
}
