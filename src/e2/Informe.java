package e2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Informe {

    private final Alerta alerta;
    private Sensor sensor;
    private final DateTimeFormatter fechaYhora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");

    public Informe(Alerta alerta, Sensor sensor) {
        this.alerta = alerta;
        this.sensor= sensor;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void imprimirInforme(){

        if(alerta.tipoAlarma== Alerta.TipoAlarma.Naranja) {
            System.out.println("*Alerta NARANJA: ");

        }else if(alerta.tipoAlarma== Alerta.TipoAlarma.Roja){
            System.out.println("*Alerta ROJA: ");
        }

        System.out.println(sensor.getTanque().getNombre() + ", " + sensor.getTanque().getUbicacion());
        System.out.println(alerta.getNombreAlerta() + ": parametro " + sensor.getNombreParametro() + ", nivel " + sensor.getNivel());
        System.out.println(fechaYhora.format(LocalDateTime.now()) + "\n");
    }
}
