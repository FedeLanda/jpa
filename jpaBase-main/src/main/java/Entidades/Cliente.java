package Entidades;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//comandos lombok


@Setter
@Getter
//comandos jpa
@Entity
@Table (name= "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// se genera un id autoicremental
    private long id;
   // @Column(name="nombre") esta etiqueta sirve para cambiar losnombres a las columnas, en caso de no usarlo
    //usara el nombre del atributo como nombre de la columna
    private String nombre;

    private String apellido;

    @Column(name="dni", unique = true)
    private int dni;


    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name= "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas= new ArrayList<Factura>();
    //constructores


    public Cliente(String nombre, String apellido, int dni) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;

    }

    public Cliente() {

    }

}
