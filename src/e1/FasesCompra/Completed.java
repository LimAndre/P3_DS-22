package e1.FasesCompra;

import e1.Order;

public class Completed extends FaseCompra {

    private static final Completed instancia= new Completed();

    private Completed(){}

    public static Completed getInstancia(){
        return instancia;
    }

    @Override
    public void Cancelled(Order order) {
        throw new IllegalArgumentException("No puedes cancelar si ya has completado");
    }

    @Override
    public void Completed(Order order) {
        order.getCarrito().borraStockComprados();
        screenInfo(order);
    }

    @Override
    public void Payment(Order order) {
        throw new IllegalArgumentException("No puedes pagar si ya has completado");
    }

    @Override
    public void Shopping(Order order) {
        throw new IllegalArgumentException("No puedes seguir comprando si ya has completado");
    }

    @Override
    public void CheckOut(Order order) {
        throw new IllegalArgumentException("No puedes checkear si ya has completado");
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
