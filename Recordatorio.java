package aed;

public class Recordatorio {
    public String mensaje =null;
    public Fecha fecha = null;
    public Horario horario = null;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.horario = horario;
        this.fecha = fecha;
    }
    
    public Recordatorio(Fecha fechita){
        this.fecha = new Fecha (fechita);
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return this.fecha;
    }

    public String mensaje() {
       return this.mensaje;
    }

    // @Override
    // public String toString() {
    //     ;
    // }

    // @Override
    // public boolean equals(Object otro) {
    //     ;
    // }

}
