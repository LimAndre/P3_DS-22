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
    public void Cancelled(Order order) {
        order.fase= Cancelled.getInstancia();
        order.cancelled();
    }

    @Override
    public void Completed(Order order) {
        order.fase=Completed.getInstancia();
        order.completed();
    }

    @Override
    public void Payment(Order order) {
        screenInfo(order);
    }

    @Override
    public void Shopping(Order order) {
        throw new IllegalArgumentException("Ya has pagado");
    }

    @Override
    public void CheckOut(Order order) {
        throw new IllegalArgumentException("Ya has pagado");
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
