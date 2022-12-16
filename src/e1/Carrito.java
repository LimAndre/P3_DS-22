package e1;
import e1.FasesCompra.Shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Carrito {

    private final Map<Producto, Integer> listaProducto= new HashMap<>();
    private final Order order;
    ArrayList<String> log= new ArrayList<>();

    public Carrito(Order order) {
        this.order = order;
    }

    public void iniciaCarrito(Order order){
        System.out.println("Order Number "+ order.getNumFacturaActual() + ": "+ order.fase.toString()+ " Phase");
    }

    public boolean borraStockComprados(){
        boolean band=false;

        for(Map.Entry<Producto, Integer> entry : listaProducto.entrySet()) {

            Producto key = entry.getKey();
            int value = entry.getValue();

            band=key.removerCantidadProducto(value);
        }

        return band;
    }

    public boolean anadirAlCarrito(Producto producto, int cantidad){
        if(producto.tieneStock(cantidad)){

            if(listaProducto.isEmpty()){
                iniciaCarrito(order);
            }

            listaProducto.put(producto, cantidad);

            if(order.fase== Shopping.getInstancia())
                log(producto, cantidad, true);
            else {
                logModify(producto, cantidad);
            }
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(Producto producto, int cantidad){
        if(listaProducto.containsKey(producto) && cantidad<= listaProducto.get(producto)){

            int aux=listaProducto.get(producto)-Math.abs(cantidad);

            if(aux==0){
                listaProducto.remove(producto);
            }else{
                listaProducto.put(producto, aux);
            }

            if(order.fase== Shopping.getInstancia()){
                log(producto, cantidad, false);
            }
            else{
                logModify(producto, cantidad);
            }
            return true;
        }
        else{
            return false;
        }
    }

    public int numProductos(){
       return listaProducto.size();
    }

    public void log(Producto producto, int cantidad, boolean tipo) {
        if (tipo) {
            log.add("-Add: Item: " + producto.getCodigoProducto() + "- Quantity: " + cantidad + "-> Shopping Cart -- Products : " + numProductos());
        }else
            log.add("-Remove: Item: "+ producto.getCodigoProducto()+ "- Quantity: "+ cantidad +"-> Shopping Cart -- Products : "+ numProductos());
    }

    public void logModify(Producto producto, int cantidad){
        log.add("-Modify: Item: "+ producto.getCodigoProducto()+ "- Quantity: "+ cantidad +"-> CheckOut Order -- Products : "+ numProductos());
    }

    public void logFases(){
        log.add("Order number "+ order.getNumFacturaActual()+": "+order.fase.toString()+" phase");
    }

    public void screenLogCarrito(){
        System.out.println("=====================================================================");
        for (String l:log) {
            System.out.println(l);
        }
    }

}
