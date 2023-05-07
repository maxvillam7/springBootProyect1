package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Cliente;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public Cliente obtenerClienteporId(Long id) throws ParseException;

    Cliente crearCliente(Cliente cliente);

    Cliente modificarDireccionCliente(Cliente cliente);

    void borrarCliente(Long id);

    List<Cliente> obtenerTodosLosCLientes();
    Optional<Cliente> getClienteBydni(Long dni);

}
