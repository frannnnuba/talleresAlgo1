package aed;

public class Fecha {
    public int dia = 0;
    public int mes =0;
    public Fecha(int dia, int mes) {
         this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia  = fecha.dia;
        this.mes = fech.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }
    @Override
    public String toString() {
        fecha.toString() = fecha.dia + "/" + fecha.mes;
    }

    @Override
    public boolean equals(Object otra) {
        if (otra.getClass() == fecha.getClass()) {
            if (otra.dia == this.dia && otra.mes = this.mes) {
                return true;
            }
            else {
                return false;
            }
        }else{
            return false;
        }
    }

    public void incrementarDia() {
    if (this.dia == 31 || this.dia == 28 && mes != 11){     //es una lista? preguntar para saber si asi hacer mes-1 = 11 para diciembre
        this.dia = 1;
        this.mes = this.mes +1; 
    }elseif (this.dia == 31 & mes == 11){
        this.dia = 1;
        this.mes = 0;
    }elseif(this.dia == 30 && this.mes != 3 && this.mes != 5 && this.mes != 7 && this.mes != 9 ){
        this.dia = 31;
        this.mes = this.mes +1;
    }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}