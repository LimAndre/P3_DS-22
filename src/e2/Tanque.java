package e2;

import e2.PatronObservador.Subject;

public class Tanque extends Subject {

    private String nombre, ubicacion;

    public Tanque(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
