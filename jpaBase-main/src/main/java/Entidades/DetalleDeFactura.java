package Entidades;


import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//comandos lombok

@Getter
@ToString
@Setter
//comandos jpa
@Entity
@Table (name= "DetalleDeFactura")
public class DetalleDeFactura implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cantidad;

    private int subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")

    private Articulo articulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "fk_factura")
    private Factura factura;
    public DetalleDeFactura() {
    }

    public DetalleDeFactura(Articulo articulo, int subtotal, int cantidad) {
        this.articulo = articulo;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public DetalleDeFactura(int cantidad, int subtotal, Articulo articulo, Factura factura) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.articulo = articulo;
        this.factura = factura;
    }
}
