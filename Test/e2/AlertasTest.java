package e2;

import org.junit.jupiter.api.Test;

public class AlertasTest {

    Tanque tanqueFocas= new Tanque("Piscina de las Focas", "Exterior");

    DispositivosControl controlTemperaturaFocas= new DispositivosControl(15);
    DispositivosControl controlPHFocas= new DispositivosControl(100);

    Sensor sensorTemperaturaFocas= new Sensor("Temperatura", controlTemperaturaFocas, tanqueFocas);
    Sensor sensorPHFocas= new Sensor("PH",controlPHFocas, tanqueFocas);

    Alerta alertaRojaTemperaturaFocas= new Alerta("Control de Temperatura Focas",40, -10, Alerta.TipoAlarma.Roja);
    Alerta alertaNaranjaTemperaturaFocas= new Alerta("Control de Temperatura Focas",30, 0, Alerta.TipoAlarma.Naranja);

    Alerta alertaRojaPHFocas= new Alerta("Control de PH Focas",300, -100, Alerta.TipoAlarma.Roja );
    Alerta alertaNaranjaPHFocas= new Alerta("Control de PH Focas",200, 0, Alerta.TipoAlarma.Naranja);

    Personal personalFocas= new Personal("Alertas de mantenimiento Focas");



    @Test
    void testing(){
        alertaRojaTemperaturaFocas.añadirSuscriptores(personalFocas);
        alertaNaranjaTemperaturaFocas.añadirSuscriptores(personalFocas);

        alertaNaranjaPHFocas.añadirSuscriptores(personalFocas);
        alertaRojaPHFocas.añadirSuscriptores(personalFocas);

        sensorTemperaturaFocas.attach(alertaRojaTemperaturaFocas);
        sensorTemperaturaFocas.attach(alertaNaranjaTemperaturaFocas);

        sensorPHFocas.attach(alertaNaranjaPHFocas);
        sensorPHFocas.attach(alertaRojaPHFocas);

        sensorTemperaturaFocas.setNivel(50);
        sensorPHFocas.setNivel(5000);
        personalFocas.imprimirInformes();

    }


}
