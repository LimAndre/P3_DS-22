package e1.FasesCompra;

import e1.Order;

public class Completed extends FaseCompra {

    private static final Completed instancia= new Completed();

    private Completed(){}

    public static Completed getInstancia(){
        return instancia;
    }

    @Override
    public void Cancelled(Order Order) {

    }

    @Override
    public void Completed(Order Order) {
        Order.getCarrito().borraStockComprados();
        screenInfo(Order);
    }

    @Override
    public void Payment(Order Order) {

    }

    @Override
    public void Shopping(Order Order) {

    }

    @Override
    public void CheckOut(Order Order) {
        Order.fase=CheckOut.getInstancia();
        Order.checkout();
    }

    @Override
    public void screenInfo(Order order) {
        System.out.println("\n=====================================================================");
        System.out.println("Order Number: "+ order.getNumFacturaActual());
        System.out.println(order.fase.toString() + " Order: "+order.getCarrito().numProductos()+" productos");

    }

    @Override
    public String toString() {
        return "Completed";
    }
}
