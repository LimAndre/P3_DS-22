package e1;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class ComprasTest {

    Order comanda= new Order();

    Producto pro1=new Producto(50, "Ratones", "111");
    Producto pro2=new Producto(20, "Teclados", "222");
    Producto pro3=new Producto(40, "Pantallas", "333");
    Producto pro4=new Producto(25, "Altavoces", "444");
    Producto pro5=new Producto(32, "Microfonos", "555");



    @Test
    void anadiralCarrito(){

        comanda.screenInfo();
        comanda.getCarrito().anadirAlCarrito(pro1, 10,comanda );
        comanda.getCarrito().anadirAlCarrito(pro2, 15,comanda );
        comanda.getCarrito().anadirAlCarrito(pro3, 20,comanda );
        comanda.checkout();
        comanda.getCarrito().eliminarProducto(pro3, 5, comanda);
        comanda.payment();
        comanda.completed();
        System.out.print(pro2.getStock());


    }




}
