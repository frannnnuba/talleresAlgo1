package aed;

public class Horario {
    public int hora = 0;
    public int minutos = 0;
    
    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public  Horario(Horario horita) {
        this.minutos = horita.minutos();
        this.hora = horita.hora();
    }

    public Horario horario(){
        return new Horario(this);
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return this.hora + ":" + this.minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro instanceof Horario){
            Horario nuevaHor = (Horario) otro;
            if (this.hora == nuevaHor.hora && this.minutos == nuevaHor.minutos) {
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

}