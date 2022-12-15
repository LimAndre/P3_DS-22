package e1;
import e1.FasesCompra.Shopping;

import java.util.HashMap;
import java.util.Map;

public class Carrito {

    private Map<Producto, Integer> listaProducto= new HashMap<>();

    public Map<Producto, Integer> getListaProducto() {
        return listaProducto;
    }

    public void iniciaCarrito(Order order){
        System.out.println("Order Number "+ order.getNumFacturaActual() + ": "+ order.fase.toString()+ " Phase");
    }

    public void borraStockComprados(){

        for(Map.Entry<Producto, Integer> entry : listaProducto.entrySet()) {

            Producto key = entry.getKey();
            int value = entry.getValue();

            key.removerCantidadProducto(value);
        }
    }

    public void anadirAlCarrito(Producto producto, int cantidad, Order order){
        if(producto.tieneStock(cantidad)){
            listaProducto.put(producto, cantidad);

            if(order.fase== Shopping.getInstancia())
                log(producto, cantidad, true);
            else {
                logModify(producto, cantidad, true);
            }
        }
    }

    public void eliminarProducto(Producto producto, int cantidad, Order order){
        if(listaProducto.containsKey(producto) && cantidad<= listaProducto.get(producto)){
            if(listaProducto.get(producto)==0) listaProducto.remove(producto);

            int aux=listaProducto.get(producto)-cantidad;
            listaProducto.put(producto, aux);

            if(order.fase== Shopping.getInstancia())
                log(producto, cantidad, false);
            else{
                logModify(producto, cantidad, false);
            }
        }
        else{
            throw new IllegalArgumentException("No hay suficientes unidades para eleminar");
        }
    }

    public int numProductos(){
       return listaProducto.size();
    }

    public void log(Producto producto, int cantidad, boolean tipo) {
        if (tipo) {
            System.out.println("-Add: Item: " + producto.getProducto() + "- Quantity: " + cantidad + " Shopping Cart -- Products : " + numProductos());
        }else
            System.out.println("-Remove: Item: "+ producto.getProducto()+ "- Quantity: "+ cantidad +" Shopping Cart -- Products : "+ numProductos());
    }

    public void logModify(Producto producto, int cantidad, boolean tipo){

        if(tipo)
            System.out.println("-Modify: Item: "+ producto.getProducto()+ "- Quantity: "+ cantidad +" CheckOut Order -- Products : "+ numProductos());
        else
            System.out.println("-Modify: Item: "+ producto.getProducto()+ "- Quantity: "+ cantidad +" CheckOut Order -- Products : "+ numProductos());
    }

}
