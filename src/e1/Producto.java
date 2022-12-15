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

    public void removerCantidadProducto(int cantidad){
        if(stock-cantidad>=0) {
            stock=stock-cantidad;
        }else throw new IllegalArgumentException("Se han eliminado productos no existentes");
    }

    public boolean tieneStock(int cantidad){
        return stock - cantidad >= 0;
    }

}
