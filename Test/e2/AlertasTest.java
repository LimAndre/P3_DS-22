package e2;

import org.junit.jupiter.api.Test;

public class AlertasTest {

    //FOCAS
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


    //PINGUINOS
    Tanque tanquePinguinos= new Tanque("Piscina de los Pinguinos", "Interior");
    DispositivosControl controlTemperaturaPinguinos= new DispositivosControl(10);
    DispositivosControl controlPHPinguinos= new DispositivosControl(50);

    Sensor sensorTemperaturaPinguinos= new Sensor("Temperatura", controlTemperaturaPinguinos, tanquePinguinos);
    Sensor sensorPHPinguinos= new Sensor("PH",controlPHPinguinos, tanquePinguinos);

    Alerta alertaRojaTemperaturaPinguinos= new Alerta("Control de Temperatura Pinguinos",20, -20, Alerta.TipoAlarma.Roja);
    Alerta alertaNaranjaTemperaturaPinguinos= new Alerta("Control de Temperatura Focas",15, -10, Alerta.TipoAlarma.Naranja);

    Alerta alertaRojaPHPinguinos= new Alerta("Control de PH Pinguinos",200, -100, Alerta.TipoAlarma.Roja );
    Alerta alertaNaranjaPHPinguinos= new Alerta("Control de PH Pinguinos",100, 0, Alerta.TipoAlarma.Naranja);

    Personal personalPinguinos= new Personal("Alertas de mantenimiento Pinguinos");

    @Test
    void testing(){

        //TestingFocas
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

        //TestingPinguinos
        alertaRojaTemperaturaPinguinos.añadirSuscriptores(personalPinguinos);
        alertaNaranjaTemperaturaPinguinos.añadirSuscriptores(personalPinguinos);

        alertaNaranjaPHPinguinos.añadirSuscriptores(personalPinguinos);
        alertaRojaPHPinguinos.añadirSuscriptores(personalPinguinos);

        sensorTemperaturaPinguinos.attach(alertaRojaTemperaturaPinguinos);
        sensorTemperaturaPinguinos.attach(alertaNaranjaTemperaturaPinguinos);

        sensorPHPinguinos.attach(alertaNaranjaPHPinguinos);
        sensorPHPinguinos.attach(alertaRojaPHPinguinos);

        sensorTemperaturaPinguinos.setNivel(30);
        sensorPHPinguinos.setNivel(55);
        personalPinguinos.imprimirInformes();


    }


}
