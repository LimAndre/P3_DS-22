package e1.FasesCompra;

import e1.Order;

public class CheckOut extends FaseCompra {

    private static final CheckOut instancia= new CheckOut();
    private CheckOut(){}
    public static CheckOut getInstancia(){
        return instancia;
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
        order.fase=Payment.getInstancia();
        order.getCarrito().logFases();
        order.solicitarPago();
    }

    @Override
    public void Shopping(Order order) {
        order.fase=Shopping.getInstancia();
        order.getCarrito().logFases();
        order.seguirComprando();
    }

    @Override
    public void CheckOut(Order order) {
        screenInfo(order);
    }

    @Override
    public void screenInfo(Order order) {
        System.out.println("\n=====================================================================");
        System.out.println("Order Number: "+ order.getNumFacturaActual());
        System.out.println(order.fase.toString() + ": "+order.getCarrito().numProductos()+" productos");

    }

    @Override
    public String toString() {
        return "CheckOut";
    }
}