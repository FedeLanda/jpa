package Entidades;


import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//comandos lombok

@Getter
@ToString
@Setter
//comandos jpa
@Entity
@Table (name= "factura")
public class Factura  implements Serializable{

    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fecha;

    private int numero;

    private int total;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Cliente")

    private Cliente cliente;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<DetalleDeFactura> detalles= new ArrayList<DetalleDeFactura>();

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleDeFactura> detalles= new ArrayList<DetalleDeFactura>();

    public Factura(long id, int numero, String fecha, int total) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.total= total;
    }

    public Factura() {
    }

    public Factura(List<DetalleDeFactura> detalles, Cliente cliente, int numero, String fecha) {
        this.detalles = detalles;
        this.cliente = cliente;
        this.numero = numero;
        this.fecha = fecha;
    }
}
