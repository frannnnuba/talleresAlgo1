package aed;

import java.util.ArrayList;
import java.util.List;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    int longitud = 0;
    int indiceUtilizado = 0;
    // List<Recordatorio> lista = null;
    // public ArrayList<Recordatorio> arreglito = null;
    Recordatorio recordatorios[] = null;
    
    
    public ArregloRedimensionableDeRecordatorios() {
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.longitud = vector.longitud ;
        recordatorios = new Recordatorio[vector.recordatorios.length];
        for (int i = 0; i < recordatorios.length; i++) {
            Recordatorio r = vector.recordatorios[i];
            recordatorios[i] = new Recordatorio(r.mensaje(), new Fecha(r.fecha()), new Horario(r.horario().hora(), r.horario().minutos()));
        }
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        if (this.indiceUtilizado < this.longitud){
            for(this.indiceUtilizado = 0; this.indiceUtilizado < this.longitud; this.indiceUtilizado ++){
                this.Recordatorios[indiceUtilizado] = ;
            }
        }
        // Recordatorio[] nuevoRecordat = new Recordatorio[this.longitud+1];
        // this.longitud = this.longitud + 1;
        // this.Recordatorios = new Recordatorio[this.longitud];
        // for (this.indice = 0; this.indice < this.longitud; this.indice++){
        //     nuevoRecordat[indice] = this.Recordatorios[indice];
        // } 
        // nuevoRecordat[this.longitud] = i;
    }

    public Recordatorio obtener(int i) {
        if(i>= 0 && i < this.longitud){
            return this.Recordatorios[i];
        }else{
            return null;
        }
        
    }

    public void quitarAtras() {
        ;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        ;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}