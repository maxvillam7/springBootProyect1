package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.Cliente;
import com.example.segundaEntrega.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public Cliente obtenerClienteporId(Long id) {
        Cliente auxClient=clienteRepository.findById(id).get();
        return auxClient;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Cliente clienteAux=clienteRepository.save(cliente);
        return clienteAux;
    }

    @Override
    public Cliente modificarDireccionCliente(Cliente cliente) {
        Cliente clienteModificado = clienteRepository.getById(cliente.getIdclient());
        clienteModificado.setDireccion(cliente.getDireccion());
        return clienteRepository.save(clienteModificado);
    }

    @Override
    public void borrarCliente(Long id) {
        Cliente cliente = clienteRepository.getById(id);
        log.info("Se va a borrar el cliente {}", cliente.getNombre());
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> obtenerTodosLosCLientes() {


        return clienteRepository.findAll();
    }
    public Optional<Cliente> getClienteBydni(Long dni){
        return clienteRepository.getClienteBydni(dni);
    }

}