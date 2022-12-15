package e2;

import e2.PatronObservador.Observer;
import e2.PatronObservador.Subject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Alerta implements Observer {

    String nombreAlerta;
    int max_Alerta, min_Alerta;
    ArrayList<Personal> suscriptores= new ArrayList<>();

    enum TipoAlarma{
        Roja,
        Naranja;
    }

    TipoAlarma tipoAlarma;

    public TipoAlarma getTipoAlarma() {
        return tipoAlarma;
    }
    public String getNombreAlerta() {
        return nombreAlerta;
    }

    public Alerta(String nombreALerta, int max_Alerta, int min_Alerta, TipoAlarma tipoAlarma) {
        this.max_Alerta = max_Alerta;
        this.min_Alerta = min_Alerta;
        this.tipoAlarma = tipoAlarma;
        this.nombreAlerta=nombreALerta;
    }

    @Override
    public void update(Subject s) {
        Sensor sensor= (Sensor) s;
        if (sensor.getNivel() > max_Alerta || sensor.getNivel() < min_Alerta) {
            informar(sensor);
        }
    }

    public void añadirSuscriptores(Personal persona) {
        suscriptores.add(persona);
    }

    public void informar(Sensor sensor){
        for (Personal persona: suscriptores) {
            persona.añadirInforme(new Informe(this, sensor));
        }
    }




}
