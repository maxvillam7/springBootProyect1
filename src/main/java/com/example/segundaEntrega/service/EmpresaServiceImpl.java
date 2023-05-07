package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Empresa;
import com.example.segundaEntrega.repository.ClienteRepository;
import com.example.segundaEntrega.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    EmpresaRepository empresaepository;

    @Override
    public Empresa obtenerEmpresaporId(Long id) {
        Empresa auxEmpresa=empresaepository.findById(id).get();
        return auxEmpresa;
    }

    @Override
    public Empresa crearEmpresa(Empresa empresa) {
        Empresa empresaAux=empresaepository.save(empresa);
        return empresaAux;
    }

    @Override
    public Empresa modificarDireccionEmpresa(Empresa empresa) {
        Empresa empresaModif = empresaepository.getById(empresa.getIdempresa());
        empresaModif.setDireccion(empresa.getDireccion());
        return empresaepository.save(empresaModif);
    }

    @Override
    public void borrarEmpresa(Long id) {
        Empresa empresa = empresaepository.getById(id);
        log.info("Se va a borrar el cliente {}", empresa.getNombre());
        empresaepository.deleteById(id);
    }

    @Override
    public List<Empresa> obtenerTodosLasEmpresas()  {
        return empresaepository.findAll();
    }
}
