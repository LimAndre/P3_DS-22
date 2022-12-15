package e2;

import e2.PatronObservador.Subject;

public class Sensor extends Subject {

    DispositivosControl dispositivosControl;
    Tanque tanque;
    String nombreParametro;
    int nivel;

    public Sensor(String nombreParametro, DispositivosControl dispositivosControl, Tanque tanque) {
        this.dispositivosControl = dispositivosControl;
        this.tanque= tanque;
        this.nombreParametro=nombreParametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
        notifyObservers();
    }

    public void normalizar(){
        dispositivosControl.normalizar(this);
    }
}
