package e1.FasesCompra;

import e1.Order;

public class Cancelled extends FaseCompra{

    private static final Cancelled instancia= new Cancelled();

    private Cancelled(){}

    public static Cancelled getInstancia(){
        return instancia;
    }

    @Override
    public void Cancelled(Order order) {
        screenInfo(order);
    }

    @Override
    public void Completed(Order order) {
        throw new IllegalArgumentException("No puedes completar si ya has cancelado");
    }

    @Override
    public void Payment(Order order) {
        throw new IllegalArgumentException("No puedes pagar si ya has cancelado");
    }

    @Override
    public void Shopping(Order order) {
        throw new IllegalArgumentException("No puedes comprar si ya has cancelado");
    }

    @Override
    public void CheckOut(Order order) {
        throw new IllegalArgumentException("No puedes checkear si ya has cancelado");
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
