package com.example.segundaEntrega.entity;

import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="factura")
@Table(name="factura")

public class Factura implements Serializable {
    //TODO LISTOOOOOOOOOOOOOOOOOOOOOOOOOO
    public static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="factura_id")
    private Long id;

    @Column(name="numeroFactura")
    private long numeroFactura;

    @Column(name="fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name="facturaType")
    private String facturaType;

    @Column(name="facturaTotal")
    private Double facturaTotal;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name="idclient")
    private Cliente clienteFact;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name="idempresa")
    private Empresa empresaFact;

    @OneToMany(mappedBy="factura", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<FacturaDetails> facturaDetails;

    public FacturaDetails agregarDetails(FacturaDetails facturaDetailsAux){
        getFacturaDetails().add(facturaDetailsAux);
        facturaDetailsAux.setFactura(this);
        return facturaDetailsAux;
    }
    public FacturaDetails removeFacturaDetail(FacturaDetails facturaDetailsAux2){
        getFacturaDetails().remove(facturaDetailsAux2);
        facturaDetailsAux2.setFactura(null);
        return facturaDetailsAux2;
    }
}
