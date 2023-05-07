package com.example.segundaEntrega.controller;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.service.ClienteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;


    @SneakyThrows
    @GetMapping("/getcliente/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable(value ="id") Long id){
        Cliente cliente = clienteService.obtenerClienteporId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clienteList = clienteService.obtenerTodosLosCLientes();
        return ResponseEntity.ok().body(clienteList);
    }

    @PostMapping("/setCliente")
    public ResponseEntity<Cliente> setCliente(@RequestBody Cliente cliente) {
        Cliente clienteAux = clienteService.crearCliente(cliente);
        return  ResponseEntity.ok().body(clienteAux);
    }

    @PutMapping("/updateCliente")
    public ResponseEntity<Cliente> updateClienteDireccion(@RequestBody Cliente cliente) {
        Cliente clienteModificado = clienteService.modificarDireccionCliente(cliente);
        return ResponseEntity.ok().body(clienteModificado);
    }

    @DeleteMapping("/deleteCliente/{id}")
    public void deleteCliente(@PathVariable(value = "id") Long clienteId) {
        clienteService.borrarCliente(clienteId);
    }

}