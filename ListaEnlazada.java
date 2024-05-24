package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    int longitu = 0;
    Nodo primero;
    Nodo ultimo;
    private class Nodo {
        Nodo anterior;
        Nodo siguiente;
        T valor; 
    }

    public ListaEnlazada() {
        this.longitu = 0;
        this.primero = null;
        this.ultimo = null;
    }

    public ListaEnlazada(ListaEnlazada<T> listita){
        if (listita.longitu == 0){
            this.longitu = 0;
            this.primero = null;
            this.ultimo = null;
        }else{
            Nodo actual = new Nodo();
            actual = listita.primero;
            while (actual != null){
                this.agregarAtras(actual.valor);
                actual = actual.siguiente;
            }
        }
    }

    public int longitud() {
        return this.longitu;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo();
        nuevo.valor = elem;
        if (this.longitu == 0) {
            this.ultimo = nuevo;
        }else{
            nuevo.siguiente = this.primero;
            this.primero.anterior = nuevo;
        }
        this.primero = nuevo;
        this.longitu++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo();
        nuevo.valor = elem;
        if (this.longitud()== 0){
            this.primero = nuevo;
        }
        if (this.ultimo != null){
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
        }
        this.ultimo = nuevo; 
        this.ultimo.siguiente = null;
        this.longitu = this.longitu + 1 ;
    }

    public T obtener(int i) {
        Nodo actual = this.primero;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo previo = this.primero;
        if (this.longitu == 1){
            this.primero = null;
            this.ultimo = null;
        } else if (i == 0){
            this.primero = previo.siguiente;
            previo.siguiente.anterior = null;
        }else if(i == this.longitu -1){
            this.ultimo = this.ultimo.anterior;
            this.ultimo.siguiente = null;
        }else{
            for (int j = 0; j < i;j++){
                previo = previo.siguiente;
            }
            previo.anterior.siguiente = previo .siguiente;
            previo.siguiente.anterior = previo.anterior;
        }
        this.longitu--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = this.primero;
        for(int j = 0; j < indice; j++){
            actual = actual.siguiente;
        }
        actual.valor = elem;

    }

      public ListaEnlazada<T> copiar() {
          return new ListaEnlazada<T>(this);
      }
    
     @Override
     public String toString() {
        StringBuilder palabra =  new StringBuilder();
        Nodo actual = new Nodo();
        actual = this.primero;
        palabra.append("[");
        for (int i = 0; i < this.longitu -1; i++) {
            palabra.append(actual.valor);
            palabra.append(", ");
            actual = actual.siguiente;
        }
        palabra.append(this.ultimo.valor);
        palabra.append("]");
        return palabra.toString();
     }

     private class ListaIterador implements Iterador<T> {
         Nodo actual;
         int dedito = 0;

          public ListaIterador() {
             if (ListaEnlazada.this.primero != null) {
                 this.actual = ListaEnlazada.this.primero;
             }else {
                this.actual = null;
             }
         }

         public boolean haySiguiente() {
            if (this.actual == null) {
                return false;
            }
	        if(this.dedito >= ListaEnlazada.this.longitud()){
                return false;
            }
            else {
                return true;
            }
         }
        
         public boolean hayAnterior() {
            if (this.dedito <= 0) {
                return false;
            }else {
                return true;
            }
            }

         public T siguiente() {
            if (haySiguiente()){
                    Nodo nodito = this.actual ;
                    this.actual = this.actual.siguiente;
                    this.dedito ++;
                    return nodito.valor; 
            }else{
                return null;
            }
            }
        
         public T anterior() {
            if(hayAnterior()){
                if(this.actual == null){
                    this.dedito--;
                    return ListaEnlazada.this.ultimo.valor;
                }
                this.actual = this.actual.anterior;
                this.dedito--;
                return this.actual.valor;
            }else{
                return null;
            }    
            }
     }

     public Iterador<T> iterador() {
        return new ListaIterador();
     }

}