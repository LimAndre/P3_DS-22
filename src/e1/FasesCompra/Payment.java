package e1.FasesCompra;

import e1.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment extends FaseCompra {

    private static final Payment instancia= new Payment();

    private Payment(){}

    public static Payment getInstancia(){
        return instancia;
    }

    private final DateTimeFormatter fechaYhora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");

    @Override
    public void Cancelled(Order Order) {
        Order.fase= Cancelled.getInstancia();
    }

    @Override
    public void Completed(Order Order) {
        Order.fase=Completed.getInstancia();
        Order.completed();
    }

    @Override
    public void Payment(Order Order) {
        Order.fase=Payment.getInstancia();
        screenInfo(Order);
    }

    @Override
    public void Shopping(Order Order) {
        Order.fase=Shopping.getInstancia();
        Order.shopping();
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
        System.out.println(order.fase.toString() + ": "+order.getCarrito().numProductos()+" productos "+ "date "+fechaYhora.format(LocalDateTime.now()));

    }

    @Override
    public String toString() {
        return "Payment";
    }

}
