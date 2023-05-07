package com.example.segundaEntrega.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="producto")
@Table(name="producto")
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})

public class Producto {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproducto")
    private Long idproducto;

    @Column(name="nombre")
    private String nombre;

    @Column(name="description")
    private String description;

    @Column(name="preciounitario")
    private Double precioUnitario;

    @Min(0)
    @Column(name="cantstock")
    private Long cantStock;

    @JsonIgnore
    @OneToMany(mappedBy="productoout", fetch = FetchType.LAZY)
    private List<FacturaDetails> facturaOutPutProduct;
}
