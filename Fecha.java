package aed;

public class Fecha {
    public int dia = 0;
    public int mes = 0;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }
    
    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes;
    }

    @Override
    public boolean equals(Object otra) {
        if (otra instanceof Fecha) {
            Fecha fechita = (Fecha) otra;
            if ((this.dia == fechita.dia) && (this.mes == fechita.mes)) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public void incrementarDia() {
        int cantDias = diasEnMes(mes);
        if (this.dia < cantDias) {
            this.dia = this.dia + 1;
        } else {
            this.dia = 1;
            if (this.mes != 12) {
                this.mes = this.mes + 1;
            } else {
                this.mes = 1;
            }
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