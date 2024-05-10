package aed;

public class Agenda {
    Fecha fechaAct = null;
    Recordatorio record = null;
    Recordatorio recordatorios[] = null;
    int longitud = 0;

    public Agenda(Fecha fechaActual) {
       this.fechaAct = new Fecha(fechaActual);
    }

    public Fecha fechaActual() {
        return new Fecha(fechaAct);
    }

     public void agregarRecordatorio(Recordatorio recordatorio) {
        Recordatorio record = new Recordatorio(this.recordatorio().mensaje(), this); 
        record.recordatorios = agregarAtras(recordatorio); 
     }

    // @Override
    // public String toString() {
    //     ;

    // }

    // public void incrementarDia() {
    //     ;

    // }

    // public Fecha fechaActual() {
    //     ;
    // }

}
