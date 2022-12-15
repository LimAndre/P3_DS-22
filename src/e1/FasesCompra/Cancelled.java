package e1.FasesCompra;

import e1.Order;

public class Cancelled extends FaseCompra{

    private static final Cancelled instancia= new Cancelled();

    private Cancelled(){}

    public static Cancelled getInstancia(){
        return instancia;
    }

    @Override
    public void Cancelled(Order Order) {
        Order.fase=Cancelled.getInstancia();
        screenInfo(Order);
    }

    @Override
    public void Completed(Order Order) {
        throw new IllegalArgumentException("No puedes haber pagar si ya has cancelado");
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
        return "Cancelled";
    }
}
