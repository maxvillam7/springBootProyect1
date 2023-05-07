package com.example.segundaEntrega.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="empresa")
@Table(name="empresa")
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Empresa {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="idempresa")
    private Long idempresa;

    @Column(name="nombre")
    private String nombre;

    @Column(name="ruc")
    private Long ruc;

    @Column(name="rubro")
    private String rubro;

    @Column(name="direccion")
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy="empresaFact", fetch = FetchType.LAZY)
    private List<Factura> empresaFacturas;
}
