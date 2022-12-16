package e1.FasesCompra;

import e1.Order;

public class Shopping extends FaseCompra{

    private static final Shopping instancia= new Shopping();

    private Shopping(){}

    public static Shopping getInstancia(){
        return instancia;
    }


    @Override
    public void Shopping(Order order) {
        screenInfo(order);
    }

    @Override
    public void CheckOut(Order order) {
        order.fase=CheckOut.getInstancia();
        order.getCarrito().logFases();
        order.checkout();
    }

    @Override
    public void Cancelled(Order order) {
        throw new IllegalArgumentException("Primero tienes que pagar");
    }

    @Override
    public void Completed(Order order) {
        throw new IllegalArgumentException("Primero tienes que pagar");
    }

    @Override
    public void Payment(Order order) {
        order.fase=CheckOut.getInstancia();
        order.solicitarPago();
    }

    @Override
    public void screenInfo(Order order) {
        System.out.println("\n=====================================================================");
        System.out.println("Order Number: "+ order.getNumFacturaActual());
        System.out.println(order.fase.toString() + " -- "+order.getCarrito().numProductos()+" productos");

    }

    @Override
    public String toString() {
        return "Shopping";
    }

}

