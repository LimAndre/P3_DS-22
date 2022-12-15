package e1;

import e1.FasesCompra.FaseCompra;
import e1.FasesCompra.Shopping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Order {


    private static int numOrder=1;
    private final int numFacturaActual;
    private final DateTimeFormatter fechaYhora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
    private final Map<Producto, Integer> listaPedidos = new HashMap<>();
    public FaseCompra fase;
    Carrito carrito;

    //CONSTRUCTOR
    public Order() {
        this.fase=Shopping.getInstancia();
        this.carrito=new Carrito();
        this.numFacturaActual = numOrder;
        numOrder++;
    }

   //GETTERs

    public Carrito getCarrito() {
        return carrito;
    }
    public int getNumFacturaActual() {
        return numFacturaActual;
    }
    public DateTimeFormatter getFechaYhora() {
        return fechaYhora;
    }
    public Map<Producto, Integer> getListaPedidos() {
        return listaPedidos;
    }


    public void checkout(){
        fase.CheckOut(this);
    }

    public void shopping(){
        fase.Shopping(this);
    }

    public void payment(){
        fase.Payment(this);
    }

    public void completed(){
        fase.Completed(this);
    }


    public void screenInfo(){

        System.out.println("============================================================");
        System.out.println("Order Number: "+ numFacturaActual);
        System.out.println(fase.toString() +"-- Welcome to online shop");
        System.out.println("============================================================");

        carrito.iniciaCarrito(this);

    }
}
