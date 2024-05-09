package aed;

import java.util.ArrayList;
import java.util.List;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    public int longitud = 0;
    public int indice = 0;
    // public List<Recordatorio> lista = null;
    // public ArrayList<Recordatorio> arreglito = null;
    public Recordatorio nuevoRecord[] = null;
    public ArregloRedimensionableDeRecordatorios arreglito = null;
    
    public ArregloRedimensionableDeRecordatorios() {
        this.nuevoRecord = null;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.arreglito = new ArregloRedimensionableDeRecordatorios();
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevoRecordat = new Recordatorio[this.longitud];
        this.longitud = this.longitud + 1;
        this.nuevoRecord = new Recordatorio[this.longitud];
        for (this.indice = 0; this.indice < this.longitud; this.indice++){
            nuevoRecordat[indice] = this.nuevoRecord[indice];
        } 
        nuevoRecordat[this.longitud] = i;
    }

    public Recordatorio obtener(int i) {
        if(i>= 0 && i < this.longitud){
            return this.nuevoRecord[i];
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
