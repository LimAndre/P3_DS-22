package e2;

public class DispositivosControl {

    int nivel_Normal;
    int test;

    public DispositivosControl(int nivel_Normal) {
        this.nivel_Normal = nivel_Normal;
    }

    public void normalizar(Sensor sensor){
        sensor.setNivel(nivel_Normal);
    }

}
