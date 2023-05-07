package com.example.segundaEntrega.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@Entity(name="cliente")
@Table(name="cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Cliente {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="idclient")
    private Long idclient;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="dni")
    private Long dni;

    @Column(name="direccion")
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy="clienteFact", fetch = FetchType.LAZY)
    private List<Factura> clienteFacturas;

}
