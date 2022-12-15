package e2;

import java.util.ArrayList;

public class Personal {

    String nombrePersonal;
    ArrayList<Informe> informeRojosSuscripciones= new ArrayList<>();
    ArrayList<Informe> informeNaranjaSuscripciones= new ArrayList<>();

    public Personal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public void añadirInforme(Informe informe){

       if(informe.getAlerta().getTipoAlarma()== Alerta.TipoAlarma.Naranja){
           informeNaranjaSuscripciones.add(informe);
       }
       else {
           informeRojosSuscripciones.add(informe);
       }
    }

    public void imprimirInformes(){

        System.out.println(nombrePersonal);
        System.out.println("\nAlertas ROJAS:");
        for (Informe informe:informeRojosSuscripciones) {
            informe.imprimirInforme();
        }
        System.out.println("Alertas NARANJAS:");
        for (Informe informe:informeNaranjaSuscripciones) {
            informe.imprimirInforme();
        }
    }

}
