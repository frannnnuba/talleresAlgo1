package aed;

public class Recordatorio {
    public String mensaje =null;
    public Fecha fecha = null;
    public Horario horario = null;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.horario = horario;
        this.fecha = new Fecha (fecha);
    }
    
    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha (fecha);
    }

    public String mensaje() {
       return this.mensaje;
    }

     @Override
     public String toString() {
         return this.mensaje + " @ " + this.fecha + " " + this.horario;
     }

     @Override
     public boolean equals(Object otro) {
         if(otro instanceof Recordatorio){
            Recordatorio record = (Recordatorio) otro;
            if(this.fecha == record.fecha && this.mensaje == record.mensaje && this.horario == record.horario){
                return true;
            }else {
                return false;
            }
         }else{
            return false;
         }
     }

}