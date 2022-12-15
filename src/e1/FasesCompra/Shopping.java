package e1.FasesCompra;

import e1.Order;

public class Shopping extends FaseCompra{

    private static final Shopping instancia= new Shopping();

    private Shopping(){}

    public static Shopping getInstancia(){
        return instancia;
    }

    @Override
    public void Shopping(Order Order) {
        Order.fase=Shopping.getInstancia();
        screenInfo(Order);
    }

    @Override
    public void CheckOut(Order Order) {
        Order.fase=CheckOut.getInstancia();
        Order.checkout();
    }

    @Override
    public void Cancelled(Order Order) {
        throw new IllegalArgumentException("Primero tienes que pagar");
    }

    @Override
    public void Completed(Order Order) {
        throw new IllegalArgumentException("Primero tienes que pagar");
    }

    @Override
    public void Payment(Order Order) {
        Order.fase=Payment.getInstancia();
        Order.payment();
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

