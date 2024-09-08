package Entidades;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cantidad;
    private String denominacion;
    private int precio;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="Articulo_categoria",
    joinColumns =@JoinColumn(name= "articulo_id"),
    inverseJoinColumns=@JoinColumn(name="categoria_id"))
    private List<Categoria> categoria= new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo")
    private List<DetalleDeFactura> detalle= new ArrayList<DetalleDeFactura>();

    public Articulo() {
    }

    public Articulo(int precio, String denominacion, int cantidad) {
        this.precio = precio;
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }


}
