package Entidades;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//comandos jpa
@Setter
@Getter
@Entity
@Table (name= "domicilio")
public class Domicilio implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreCalle;

    private int numero;
    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

    public Domicilio(String nombreCalle, int numero) {

        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }


    public Domicilio() {
    }

}
