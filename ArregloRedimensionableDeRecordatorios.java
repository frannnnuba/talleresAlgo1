package aed;

import java.util.ArrayList;
import java.util.List;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    int longitud = 0;
    //int indiceUtilizado = 0;
    //Recordatorio record = null;
    Recordatorio recordatorios[] = null;
    //ArregloRedimensionableDeRecordatorios res = null;

    public ArregloRedimensionableDeRecordatorios() {
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.longitud = vector.longitud;
        recordatorios = new Recordatorio[this.longitud];
        for (int i = 0; i < recordatorios.length; i++) {
            Recordatorio r = vector.recordatorios[i];
            recordatorios[i] = new Recordatorio(r.mensaje(), new Fecha(r.fecha().dia(), r.fecha().mes()),
                    new Horario(r.horario().hora(), r.horario().minutos()));
        }
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        if (this.longitud == 0) {
            Recordatorio[] nuevorecordatorio = new Recordatorio[1];
            nuevorecordatorio[0] = i;
            this.recordatorios = nuevorecordatorio;
            this.longitud = 1;
        } else {
            Recordatorio[] nuevorecordat = new Recordatorio[this.longitud + 1];
            for (int k = 0; k < nuevorecordat.length - 1; k++) {
                nuevorecordat[k] = this.recordatorios[k];
            }
            nuevorecordat[nuevorecordat.length - 1] = i;

            this.recordatorios = nuevorecordat;
            this.longitud = this.longitud + 1;
        }
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevorecordat = new Recordatorio[this.longitud -1];
        for(int i = 0; i < nuevorecordat.length;i++ ){
            nuevorecordat[i] = this.recordatorios[i];
        }
        this.recordatorios = nuevorecordat;
        this.longitud = this.longitud -1;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
            this.recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }

}