package aed;

public class Agenda {
    Fecha fechaAct = null;
    //Recordatorio record = null;
    Recordatorio  recordatorios[] = null;
    int longitud = 0;
    ArregloRedimensionableDeRecordatorios arreglo = null;

    public Agenda(Fecha fechaActual) {
       this.fechaAct = new Fecha(fechaActual);
       this.arreglo = new ArregloRedimensionableDeRecordatorios();
    }

    public Fecha fechaActual() {
        return new Fecha(fechaAct);
    }

     public void agregarRecordatorio(Recordatorio recordatorio) {
        String mensaje = recordatorio.mensaje;
        Fecha fecha = new Fecha(recordatorio.fecha);
        Horario horario = new Horario(recordatorio.horario.hora(),recordatorio.horario.minutos());
        Recordatorio copiarecord = new Recordatorio(mensaje,fecha ,horario);
        this.arreglo.agregarAtras(copiarecord); 
     }

     @Override
     public String toString() {
        Fecha fechita = fechaActual();
        StringBuilder palabra = new StringBuilder();
        palabra.append(fechita).append("\n").append("=====\n");
        for (int i = 0; i < arreglo.longitud(); i++ ){
            Recordatorio recordatorio = this.arreglo.recordatorios[i];
            if(recordatorio.fecha().equals(fechita)){
                palabra.append(recordatorio.mensaje()).append(" @ ")
                  .append(recordatorio.fecha()).append(" ")
                  .append(recordatorio.horario()).append("\n");
            }
        }
        return palabra.toString();
     }

     public void incrementarDia() {
         this.fechaAct.incrementarDia();

     }

}