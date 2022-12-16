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
    public FaseCompra fase;
    Carrito carrito;

    //CONSTRUCTOR
    public Order() {
        this.fase=Shopping.getInstancia();
        this.carrito=new Carrito(this);
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


    //FASES
    public void cancelled(){
        fase.Cancelled(this);
    }
    public void checkout(){
        fase.CheckOut(this);
    }
    public void seguirComprando(){
        fase.Shopping(this);
    }
    public void solicitarPago(){
        fase.Payment(this);
    }
    public void completed(){
        fase.Completed(this);
    }


    public void iniciarPedido(){
        screenInfo();
    }

    public void screenLogInfo(){
        carrito.screenLogCarrito();
    }
    public void screenInfo(){

        System.out.println("=====================================================================");
        System.out.println("Order Number: "+ numFacturaActual);
        System.out.println(fase.toString() +"-- Welcome to online shop");
        System.out.println("=====================================================================");

        carrito.logFases();
    }
}
