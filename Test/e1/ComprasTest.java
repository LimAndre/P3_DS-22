package e1;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class ComprasTest {

    Order comanda = new Order();

    Producto ratones = new Producto(50, "Ratones", "111");
    Producto teclados = new Producto(20, "Teclados", "222");
    Producto pantallas = new Producto(40, "Pantallas", "333");
    Producto altavoces = new Producto(25, "Altavoces", "444");
    Producto microfonos = new Producto(32, "Microfonos", "555");


    @Before
    void añadirAlCarrito(){
        comanda.getCarrito().anadirAlCarrito(ratones, 10 );
        comanda.getCarrito().anadirAlCarrito(teclados, 15);
        comanda.getCarrito().anadirAlCarrito(teclados, 50 );
        comanda.getCarrito().anadirAlCarrito(pantallas, 20 );
    }

    @Before
    void eliminarDelCarrito(){
        comanda.getCarrito().eliminarProducto(ratones, 10);
        comanda.getCarrito().eliminarProducto(teclados, 15);
        comanda.getCarrito().eliminarProducto(pantallas, 20);
    }



    @Test
    void testAñadirCarrito() {
        assertTrue(comanda.getCarrito().anadirAlCarrito(ratones, 10));
        assertTrue(comanda.getCarrito().anadirAlCarrito(teclados, 15));
        assertTrue(comanda.getCarrito().anadirAlCarrito(pantallas, 20));
        assertTrue(comanda.getCarrito().anadirAlCarrito(pantallas, 1));

        assertFalse(comanda.getCarrito().anadirAlCarrito(teclados, 50));
        assertFalse(comanda.getCarrito().anadirAlCarrito(pantallas, 100));
        assertFalse(comanda.getCarrito().anadirAlCarrito(altavoces, -50));
        assertFalse(comanda.getCarrito().anadirAlCarrito(microfonos, 2000));

    }

    @Test
    void testEliminarCarrito() {

        añadirAlCarrito();
        assertTrue(comanda.getCarrito().eliminarProducto(ratones, 5));
        assertTrue(comanda.getCarrito().eliminarProducto(teclados, 10));
        assertTrue(comanda.getCarrito().eliminarProducto(pantallas, 15));

        assertFalse(comanda.getCarrito().eliminarProducto(pantallas, 1000));
        assertFalse(comanda.getCarrito().eliminarProducto(pantallas, 100));
        assertFalse(comanda.getCarrito().eliminarProducto(altavoces, -50));
        assertFalse(comanda.getCarrito().eliminarProducto(microfonos, 2000));

    }

    @Test
    void fases() {

        comanda.iniciarPedido();
        añadirAlCarrito();
        comanda.checkout();
        eliminarDelCarrito();
        comanda.solicitarPago();
        comanda.completed();

    }

    @Test
    void log(){
        añadirAlCarrito();
        comanda.checkout();
        eliminarDelCarrito();
        comanda.solicitarPago();
        comanda.screenLogInfo();
    }


}

