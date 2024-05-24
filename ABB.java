package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int cardinal;
    private int altura;
    private Nodo actual;

    private class Nodo {
        Nodo izq;
        Nodo anterior;
        T valor;
        Nodo der;

        Nodo(T v) {
            this.izq = null;
            this.valor = v;
            this.anterior = null;
            this.der = null;
        }
    }

    public ABB() {
        this.raiz = null;
        this.cardinal = 0;
        this.altura = 0;
    }

    public int cardinal() {
        return this.cardinal;
    }

    public T minimo() {
        this.actual = this.raiz.izq;
        if (this.raiz.izq == null) {
            return this.raiz.valor;
        } else {
            while (this.actual.izq != null) {
                this.actual = this.actual.izq;
            }
            return this.actual.valor;
        }
    }

    public T maximo() {
        this.actual = this.raiz.der;
        if(this.raiz.der == null){
            return this.raiz.valor;
        }else{
            while(this.actual.der != null){
                this.actual = this.actual.der;
            }
            return this.actual.valor;
        }
    }

    public void insertar(T elem) {
        this.actual = this.raiz; 
        if(elem.compareTo(this.raiz.valor) == 0){
            ;
        }
        if (elem.compareTo(this.raiz.valor) < 0){
            while(this.actual.izq != null && elem.compareTo(this.actual.valor) < 0){
                this.actual = this.actual.izq;
            }
            this.actual.valor = elem;
            while(this.actual.der != null && elem.compareTo(this.actual.valor) > 0){
                this.actual = this.actual.der;
            }
            this.actual.valor = elem;
        }
        
    }
    }

    public boolean pertenece(T elem) {
        ;
    }

    public void eliminar(T elem) {
        ;
    }

    public String toString() {
        ;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            ;
        }

        public T siguiente() {
            ;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
