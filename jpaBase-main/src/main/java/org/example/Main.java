
package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.*;



public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager em = emf.createEntityManager();


        try {
            // Persistir una nueva entidad Person
            em.getTransaction().begin();

//

            Factura factura1 = new Factura();
            factura1.setNumero(12);
            factura1.setFecha("10/12/2010");

            Domicilio dom= new Domicilio("San MArtin", 1500);
            Cliente cliente= new Cliente("Federico", "landa", 3509117);

            cliente.setDomicilio(dom);
            dom.setCliente(cliente);

            factura1.setCliente(cliente);

            Categoria perecederos= new Categoria( "perecederos");
            Categoria lacteos = new Categoria("lacteos");
            Categoria limpieza= new Categoria ("Limpieza");

            Articulo art1= new Articulo(100, "Yogurt vinilla", 1);
            Articulo art2= new Articulo(500, "Detergente", 20);

            art1.getCategoria().add(perecederos);
            art1.getCategoria().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);


            art2.getCategoria().add(limpieza);
            limpieza.getArticulos().add(art2);

            DetalleDeFactura det1= new DetalleDeFactura();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            art1.getDetalle().add(det1);
            factura1.getDetalles().add(det1);
            det1.setFactura(factura1);

            DetalleDeFactura det2= new DetalleDeFactura();
            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);

            art2.getDetalle().add(det2);
            factura1.getDetalles().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);



            em.persist(factura1);



            em.flush();
            em.getTransaction().commit();

        }catch (Exception e){

            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Salí por el catch");}

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}

/*

Manejo del Ciclo de Estados en JPA
El ciclo de estados en JPA (Java Persistence API) define los diferentes estados que puede tener una entidad en relación con el contexto de persistencia (EntityManager). Comprender y manejar correctamente estos estados es crucial para trabajar eficazmente con JPA. Los estados del ciclo de vida de una entidad en JPA son:

New (Nuevo):

Una entidad está en estado "New" cuando ha sido creada pero aún no ha sido persistida en la base de datos.
Managed (Gestionado):

Una entidad está en estado "Managed" cuando está asociada con un contexto de persistencia (EntityManager) y cualquier cambio en la entidad se reflejará automáticamente en la base de datos.
Detached (Desconectado):

Una entidad está en estado "Detached" cuando ya no está asociada con un contexto de persistencia. Los cambios en la entidad no se reflejarán automáticamente en la base de datos.
Removed (Eliminado):

Una entidad está en estado "Removed" cuando ha sido marcada para su eliminación en la base de datos.
*/


