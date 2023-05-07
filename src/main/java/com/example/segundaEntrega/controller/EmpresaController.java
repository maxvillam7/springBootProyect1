package com.example.segundaEntrega.controller;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.entity.Empresa;
import com.example.segundaEntrega.service.ClienteService;
import com.example.segundaEntrega.service.EmpresaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;


    @SneakyThrows
    @GetMapping("/getempresa/{id}")
    public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable(value ="id") Long id){
        Empresa cliente = empresaService.obtenerEmpresaporId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/empresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> clienteList = empresaService.obtenerTodosLasEmpresas();
        return ResponseEntity.ok().body(clienteList);
    }

    @PostMapping("/setEmpresa")
    public ResponseEntity<Empresa> setEmpresa(@RequestBody Empresa empresa) {
        Empresa clienteAux = empresaService.crearEmpresa(empresa);
        return  ResponseEntity.ok().body(clienteAux);
    }

    @PutMapping("/updateEmpresa")
    public ResponseEntity<Empresa> updateEmpresaDireccion(@RequestBody Empresa empresa) {
        Empresa clienteModificado = empresaService.modificarDireccionEmpresa(empresa);
        return ResponseEntity.ok().body(clienteModificado);
    }

    @DeleteMapping("/deleteEmpresa/{id}")
    public void deleteEmpresa(@PathVariable(value = "id") Long empresaId) {
        empresaService.borrarEmpresa(empresaId);
    }
}
