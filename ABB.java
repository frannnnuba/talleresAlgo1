package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int cardinal;
    private int altura;
    
    private class Nodo {
        Nodo izq;
        T valor;
        Nodo der;
        Nodo padre;


        Nodo(T v) {
            this.izq = null;
            this.valor = v;
            this.der = null;
            this.padre = null;

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
        Nodo actual = this.raiz.izq;
        if (actual == null) {
            return this.raiz.valor;
        } else {
            while (actual.izq != null) {
                actual = actual.izq;
            }
            return actual.valor;
        }
    }

    public T maximo() {
        Nodo actual = this.raiz.der;
        if(actual == null){
            return this.raiz.valor;
        }else{
            while(actual.der != null){
                actual = actual.der;
            }
            return actual.valor;
        }
    }

    public void insertar(T elem) {
        Nodo actual = this.raiz; 
        Nodo ainsertar = new Nodo(elem); //nuevo nodo con el valor de elem
        Nodo padreainsertar = null; // padre del nuevo nodo
        if (actual == null){
            this.raiz = ainsertar; //lista vacia
            this.cardinal ++;
        }else{
            if(pertenecee(elem) == false){
                while (actual != null) { //vamos a avanzar a actual mientras no sea vacio
                    padreainsertar = actual;
                    if(elem.compareTo(actual.valor) < 0){
                        actual = actual.izq;
                    }else{
                        actual = actual.der;
                    }
                }
                ainsertar.padre = padreainsertar;
                if(elem.compareTo(padreainsertar.valor) < 0){
                    padreainsertar.izq = ainsertar;
                }
                if (elem.compareTo(padreainsertar.valor) > 0){
                    padreainsertar.der = ainsertar;
                }
                this.cardinal ++;
            }
            }
        
    }
    

    public boolean pertenece(T elem) {
        Nodo actual = this.raiz;
        while (actual != null && elem.compareTo(actual.valor) != 0){
            if (elem.compareTo(actual.valor) < 0){
                actual = actual.izq;
            }else{
                actual = actual.der;
            }
        }
        if(actual == null){
            return false;
        }else{
            return elem.compareTo(actual.valor) == 0;
        }     
    }

    private boolean pertenecee(T elem) {
        Nodo actual = this.raiz;
        while (actual != null && elem.compareTo(actual.valor) != 0){
            if (elem.compareTo(actual.valor) < 0){
                actual = actual.izq;
            }else{
                actual = actual.der;
            }
        }
        if(actual == null){
            return false;
        }else{
            return elem.compareTo(actual.valor) == 0;
        }     
    }

    public void eliminar(T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo padreaeliminar;
        Nodo actual = this.raiz;
        if(actual != null){
        while(elem.compareTo(actual.valor) != 0){ //avanzo el actual y padreaeliminar hasta encontrar el elem
                     padreaeliminar = actual;
                     if(elem.compareTo(actual.valor) < 0){
                         actual = actual.izq;
                     }else{
                         actual = actual.der;
                     }
                 }
        if(actual.izq == null && elem.compareTo(actual.valor) == 0){
            transplantar(this, actual, actual.der);
        }else if( actual.der == null && elem.compareTo(actual.valor) == 0){
            transplantar(this, actual, actual.izq);
        }else{
            Nodo sucesor = minimum(actual.der);
            if (sucesor != actual.der){
                transplantar(this, sucesor, sucesor.der);
                sucesor.der = actual.der;
                sucesor.der.padre = sucesor;
            }
            transplantar(this, actual, sucesor);
            sucesor.izq = actual.izq;
            sucesor.izq.padre = sucesor;
        }
        this.cardinal--;
    }
    }
    
    private Nodo minimum(Nodo x){
        while (x.izq != null){
            x = x.izq;
        }
        return x;
    }

    private void transplantar(ABB Tree, Nodo u, Nodo v){
        if(u.padre == null){
            Tree.raiz = v;
        }else if(u == u.padre.izq){
            u.padre.izq = v;
        }else{
            u.padre.der = v;
        }
        if (v != null){
            v.padre = u.padre;
        }
    }

    public String toString() {
        StringBuilder palabra = new StringBuilder("{");
        Iterador<T> iterador = new ABB_Iterador();
        while(iterador.haySiguiente()){
            palabra.append(iterador.siguiente());
            palabra.append(",");
        }
        palabra.append(iterador.siguiente());
        palabra.append("}");
        return palabra.toString();
    }

    private Nodo sucesor(Nodo n){
        if(n.der != null){
            return minimum(n.der);
        } 
        else{
            Nodo padrea = n.padre;
            while (padrea != null && n == padrea.der){
                n = padrea;
                padrea = padrea.padre;
            }
            return padrea;
        }

    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;


        public ABB_Iterador(){
            _actual = minimum(raiz);
        }

        public boolean haySiguiente() {            
            return (sucesor(this._actual) != null);
        }
    
        public T siguiente() {
            T adevolver = _actual.valor;
            _actual = sucesor(this._actual);
            return adevolver;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}