package com.example.segundaEntrega.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="facturadetails")
@Table(name="facturadetails")
public class FacturaDetails implements Serializable {
    public static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="totalParcial")
    private double totalParcial;

    @ManyToOne
    @JoinColumn(name="idproducto")
    @JsonBackReference
    private Producto productoout;

    @ManyToOne
    @JoinColumn(name="factura_id")
    @JsonBackReference
    private Factura factura;




}
