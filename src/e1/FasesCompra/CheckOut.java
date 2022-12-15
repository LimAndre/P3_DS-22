package e1.FasesCompra;

import e1.Order;

public class CheckOut extends FaseCompra {
    private static final CheckOut instancia= new CheckOut();

    private CheckOut(){}

    public static CheckOut getInstancia(){
        return instancia;
    }


    @Override
    public void Cancelled(Order Order) {

    }

    @Override
    public void Completed(Order Order) {

    }

    @Override
    public void Payment(Order Order) {
        Order.fase=Payment.getInstancia();
        Order.payment();
    }

    @Override
    public void Shopping(Order Order) {

    }

    @Override
    public void CheckOut(Order Order) {
        Order.fase=CheckOut.getInstancia();
        Order.fase.screenInfo(Order);
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