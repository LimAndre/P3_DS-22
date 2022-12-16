package e1;

public class Producto {

    private int stock;
    private final String producto;
    private final String codigoProducto;

    public Producto(int stock, String producto, String codigoProducto) {
        this.stock = stock;
        this.producto = producto;
        this.codigoProducto = codigoProducto;
    }

    public int getStock() {
        return stock;
    }

    public String getProducto() {
        return producto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public boolean removerCantidadProducto(int cantidad){
        if(stock-cantidad>=0) {
            stock=stock-cantidad;
            return true;
        }else{
            return false;
        }
    }

    public boolean tieneStock(int cantidad){
        return stock - Math.abs(cantidad) >= 0;
    }

}
