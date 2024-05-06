package aed;

public class Fecha {
    public Fecha(int dia, int mes) {
        public int dia;
        public int mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = dia;
        this.mes = mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }
    @Override
    public String toString() {
        fecha.toString() = fecha.dia"/"fecha.mes;
    }

    @Override
    public boolean equals(Object otra) {
        if (otra = Fecha) {
            
        }

        ;
    }

    public void incrementarDia() {
    ;
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
