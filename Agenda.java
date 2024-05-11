package aed;

public class Agenda {
    Fecha fechaAct = null;
    Recordatorio record = null;
    Recordatorio[]  recordatorios= null;
    int longitud = 0;
    ArregloRedimensionableDeRecordatorios arreglo = null;

    public Agenda(Fecha fechaActual) {
       this.fechaAct = new Fecha(fechaActual);
    }

    public Fecha fechaActual() {
        return new Fecha(fechaAct);
    }

     public void agregarRecordatorio(Recordatorio recordatorio) {
        // Recordatorio record = new Recordatorio(this.recordatorio().mensaje(), this); 
        this.arreglo.agregarAtras(recordatorio); 
     }

     @Override
     public String toString() {
         String palabra = null; 
        for (int i = 0; i < arreglo.longitud(); i++ ){
            palabra = this.arreglo.recordatorios[i].fecha().toString() + "/" + this.arreglo.recordatorios[i].fecha().dia() + "\n"
                        .concat("=====\n")
                        .concat("Clase Algoritmos @" + " " +  this.arreglo.recordatorios[i].fecha().toString() + " " + this.arreglo.recordatorios[i].horario().toString() + "\n")  
                        .concat("Labo Algoritmos @" + this.arreglo.recordatorios[i].fecha.toString() + " " + this.arreglo.recordatorios[i].horario().toString() + "\n");
        }
        return palabra;
     }

     public void incrementarDia() {
         this.fechaAct.incrementarDia();

     }

}