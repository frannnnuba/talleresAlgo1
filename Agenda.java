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
        this.longitud = this.recordatorios.length;
         recordatorios = new Recordatorio[this.longitud];
        
         for (int i = 0; i < recordatorios.length; i++) {
             Recordatorio r = this.recordatorios[i];
             recordatorios[i] = new Recordatorio(r.mensaje(), new Fecha(r.fecha().dia(),r.fecha().mes()),
                     new Horario(r.horario().hora(), r.horario().minutos()));
         }

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
