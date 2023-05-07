package com.example.segundaEntrega.service;

import com.example.segundaEntrega.entity.*;
import com.example.segundaEntrega.repository.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    FacturaDetailsRepository facturaDetailsRepository;

    @Override
    public Factura obtenerFacturaporId(Long id) {
        Optional<Factura> auxFactura=facturaRepository.findById(id);
        if (auxFactura.isPresent()){
            return auxFactura.get();
        } else {
            throw new  DBException("No se encontro la factura de id "+id);
        }

    }
    @Override
    public FacturaDTO newFactura(FacturaInputProductsDTO facturaInputProductsDTO) {
        FacturaDTO facturaToSend=new FacturaDTO();

        boolean allProductshaveStockFlag=true;
        boolean allProductsExistByIdFlag=true;
        double cantidadTotal=0;

        facturaToSend.setDetalleFactura(new ArrayList<>());

        for (ProductoInputDTO auxProductInput :facturaInputProductsDTO.getProductoList()){
            Optional<Producto> auxProduct=productoRepository.findById(auxProductInput.getId());

            FacturaDetailsDTOFactura facturaDetailsDTOFactura=new FacturaDetailsDTOFactura();
            if (auxProductInput.getCantidad()<=0){
                throw new  DBException("No se puede escoger un numero negativo para los productos");
            }
            ProductoDTOFactura auxProductToSend=new ProductoDTOFactura();
            if (auxProduct.isPresent()){
                long stockOfProduct=auxProduct.get().getCantStock();
                //PRODUCTO ENVIADO
                auxProductToSend.setDescription(auxProduct.get().getDescription());
                auxProductToSend.setNombre(auxProduct.get().getNombre());
                auxProductToSend.setPrecioUnitario(auxProduct.get().getPrecioUnitario());

                if (auxProductInput.getCantidad()<=stockOfProduct){
                    auxProductToSend.setStatus("HAY SUFICIENTE EN STOCK");
                    facturaDetailsDTOFactura.setTotalParcial(auxProductInput.getCantidad()*auxProduct.get().getPrecioUnitario());
                    cantidadTotal+=auxProductInput.getCantidad()*auxProduct.get().getPrecioUnitario();
                } else {
                    auxProductToSend.setStatus("SOLO HAY "+stockOfProduct+" UNIDADES DE ESTE PRODUCTO");
                    allProductshaveStockFlag=false;
                    facturaDetailsDTOFactura.setTotalParcial(0.0);
                }
            } else {
                auxProductToSend.setDescription("No existe");
                auxProductToSend.setNombre(auxProductInput.getNombre());
                auxProductToSend.setPrecioUnitario(0.0);
                facturaDetailsDTOFactura.setTotalParcial(0.0);
                auxProductToSend.setStatus("EL ID DEL PRODUCTO NO EXISTE");
                allProductsExistByIdFlag=false;
            }
            facturaDetailsDTOFactura.setProductoDTOFactura(auxProductToSend);
            facturaDetailsDTOFactura.setCantidad(auxProductInput.getCantidad());
            facturaToSend.agregarFacturaDetailsDTOFactura(facturaDetailsDTOFactura);
        }
        //HASTA ESTE PUNTO YA SABEMOS SI EXISTEN TODOS LOS PRODUCTOS EN STOCK

        if (allProductsExistByIdFlag&&allProductshaveStockFlag){
            //EN ESTE CASO YA SE VERIFICO QUE HAYA STOCK DE TODO
            Optional<Empresa> empresa=empresaRepository.findById(1L);
            if (empresa.isPresent()){
                EmpresaDTOFactura empresaToSend=new EmpresaDTOFactura();
                empresaToSend.setNombre(empresa.get().getNombre());
                empresaToSend.setRubro(empresa.get().getRubro());
                empresaToSend.setRuc(empresa.get().getRuc());
                facturaToSend.setEmpresaFact(empresaToSend);
            } else{
                throw new  DBException("No hay ninguna empresa");
            }
            Optional<Cliente> cliente=clienteRepository.findById(facturaInputProductsDTO.getClienteData().getId());
            if (cliente.isPresent()){
                ClienteDTOFactura clienteToSend=new ClienteDTOFactura();
                clienteToSend.setNombre(cliente.get().getNombre());
                clienteToSend.setApellidos(cliente.get().getApellidos());
                clienteToSend.setDireccion(cliente.get().getDireccion());
                clienteToSend.setDni(cliente.get().getDni());
                facturaToSend.setClienteFact(clienteToSend);
            } else {
                Optional<Cliente> clienteFindByid=clienteRepository.getClienteBydni(facturaInputProductsDTO.getClienteData().getDni());
                Cliente newCliente;
                newCliente=new Cliente();
                if (clienteFindByid.isPresent()){
                    throw new  DBException("El id de este nuevo cliente ya coincide con el DNI de otro usuario, porfavor seleccionar otro");
                } else {
                    newCliente.setNombre(facturaInputProductsDTO.getClienteData().getNombre());
                    newCliente.setApellidos(facturaInputProductsDTO.getClienteData().getApellidos());
                    newCliente.setDireccion(facturaInputProductsDTO.getClienteData().getDireccion());
                    newCliente.setDni(facturaInputProductsDTO.getClienteData().getDni());
                    newCliente.setClienteFacturas(new ArrayList<>());
                    clienteRepository.save(newCliente);
                }
                ClienteDTOFactura clienteToSend=new ClienteDTOFactura();
                clienteToSend.setNombre(facturaInputProductsDTO.getClienteData().getNombre());
                clienteToSend.setApellidos(facturaInputProductsDTO.getClienteData().getApellidos());
                clienteToSend.setDireccion(facturaInputProductsDTO.getClienteData().getDireccion());
                clienteToSend.setDni(facturaInputProductsDTO.getClienteData().getDni());
                facturaToSend.setClienteFact(clienteToSend);

            }
            facturaToSend.setFacturaStatus("FACTURA APROBADA");
            facturaToSend.setFacturaTotal(cantidadTotal);
            facturaToSend.setFecha(Date.from(Instant.now()));
            facturaToSend.setFacturaType("A");//Este parametro sera Constante
            //facturaToSend.setNumeroFactura(100);
            Factura facturaSaved=crearFactura(facturaToSend);
            facturaSaved.setNumeroFactura(facturaSaved.getId());
            facturaToSend.setNumeroFactura(facturaSaved.getId());
        } else {
            if (!allProductsExistByIdFlag){
                facturaToSend.setFacturaStatus("FACTURA NO APROBADA - ALGUNOS PRODUCTOS NO EXISTEN");
            }
            if (!allProductshaveStockFlag){
                facturaToSend.setFacturaStatus("FACTURA NO APROBADA - ALGUNOS PRODUCTOS NO ESTAN EN STOCK");
            }
            if (!allProductshaveStockFlag && !allProductsExistByIdFlag){
                facturaToSend.setFacturaStatus("FACTURA NO APROBADA - ALGUNOS PRODUCTOS NO EXISTEN Y NO ESTAN EN STOCK");
            }
            facturaToSend.setFacturaTotal(0.0);
            facturaToSend.setFecha(Date.from(Instant.now()));
            facturaToSend.setNumeroFactura(0);
        }



        return facturaToSend;
    }

    @Override
    public List<Factura> getFacturaByClientId(Long id) {
        List<Factura> auxFactura=facturaRepository.getFacturaByClientId(clienteRepository.findById(id).get().getNombre());
        if (auxFactura.isEmpty()){
            throw new  DBException("No hay ninguna factura asociada al cliente de id "+id);
        } else {
            return auxFactura;
        }
    }

    Factura crearFactura(FacturaDTO facturaToSend){
        Factura facturaAux=new Factura();
        facturaAux.setFacturaTotal(facturaToSend.getFacturaTotal());
        facturaAux.setClienteFact(clienteRepository.getClienteBydni(facturaToSend.getClienteFact().getDni()).get());
        facturaAux.setEmpresaFact(empresaRepository.findById(1L).get());
        facturaAux.setFacturaDetails(new HashSet<>());
        facturaAux.setFecha(facturaToSend.getFecha());
        facturaAux.setFacturaType(facturaToSend.getFacturaType());

        for (FacturaDetailsDTOFactura aux:facturaToSend.getDetalleFactura()){
            FacturaDetails facturaDetail1=new FacturaDetails();
            facturaDetail1.setCantidad(aux.getCantidad());
            facturaDetail1.setTotalParcial(aux.getTotalParcial());
            facturaDetail1.setProductoout(productoRepository.getProductoBynombre(aux.getProductoDTOFactura().getNombre()).get());
            facturaAux.agregarDetails(facturaDetail1);
            //descontar cada p´roducto de la base de datos
            Producto productToRestStock=productoRepository.getProductoBynombre(aux.getProductoDTOFactura().getNombre()).get();
            productToRestStock.setCantStock(productToRestStock.getCantStock()-aux.getCantidad());
            productoRepository.save(productToRestStock);
        }
        //guardar factura
        return facturaRepository.save(facturaAux);
    }

}
