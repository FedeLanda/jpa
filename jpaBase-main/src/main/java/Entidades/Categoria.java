package Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.*;
@Getter
@Setter
@Entity
@Table
public class Categoria implements Serializable {

    private static final long serialVersionUID= 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     private String denominacion;
     @ManyToMany(mappedBy = "categorias")
     private List<Articulo> articulos= new ArrayList<Articulo>();


    public Categoria(String denominacion) {
        this.denominacion = denominacion;

    }

    public Categoria(String denominacion, List<Articulo> articulos) {
        this.denominacion = denominacion;
        this.articulos = articulos;
    }

    public Categoria() {
    }
}
