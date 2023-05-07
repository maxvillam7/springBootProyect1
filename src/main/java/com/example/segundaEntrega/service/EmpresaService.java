package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Empresa;

import java.text.ParseException;
import java.util.List;

public interface EmpresaService {
    public Empresa obtenerEmpresaporId(Long id);

    Empresa crearEmpresa(Empresa cliente);

    Empresa modificarDireccionEmpresa(Empresa cliente);

    void borrarEmpresa(Long id);

    List<Empresa> obtenerTodosLasEmpresas();

}
