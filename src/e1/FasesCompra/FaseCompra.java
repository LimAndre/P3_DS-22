package e1.FasesCompra;

import e1.Order;

public abstract class FaseCompra {

    public abstract void Cancelled(Order Order);
    public abstract void Completed(Order Order);
    public abstract void Payment(Order Order);
    public abstract void Shopping(Order Order);
    public abstract void CheckOut(Order Order);
    public abstract void screenInfo(Order order);
    public abstract String toString();

}
