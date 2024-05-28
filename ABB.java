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
        this.actual = null;
    }

    public int cardinal() {
        return this.cardinal;
    }

    public T minimo() {
        this.actual = this.raiz.izq;
        if (this.actual == null) {
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
        if(this.actual == null){
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
        Nodo ainsertar = new Nodo(elem); //nuevo nodo con el valor de elem
        Nodo padreainsertar = null; // padre del nuevo nodo
        if (this.actual == null){
            this.raiz = ainsertar; //lista vacia
        }
        while (this.actual != null) { //vamos a avanzar a actual mientras no sea vacio
            padreainsertar = this.actual;
            if(elem.compareTo(actual.valor) < 0){
                this.actual = this.actual.izq;
            }else{
                this.actual = this.actual.der;
            }
        }
        ainsertar.padre = padreainsertar;
        if(elem.compareTo(padreainsertar.valor) < 0){
            padreainsertar.izq = ainsertar;
        }
        if (elem.compareTo(padreainsertar.valor) > 0){
            padreainsertar.der = ainsertar;
        }
    }
    

    public boolean pertenece(T elem) {
        this.actual = this.raiz;
        while (actual != null && elem.compareTo(actual.valor) != 0){
            if (elem.compareTo(this.actual.valor) < 0){
                this.actual = this.actual.izq;
            }else{
                this.actual = this.actual.der;
            }
        }
        if(actual == null){
            return false;
        }else{
            return elem.compareTo(actual.valor) == 0;
        }     
    }

    // public void eliminar(T elem) {
    //     this.actual = this.raiz;
    //     Nodo padreaeliminar;
    //     // caso raiz sin hijos 
    //     if (this.actual.izq == null && this.actual.der == null && elem.compareTo(actual.valor) == 0){
    //         this.actual = null;
    //         this.actual.padre = null;
    //     }
    //     while(elem.compareTo(this.actual.valor) != 0){ //avanzo el actual y padreaeliminar hasta encontrar el elem
    //         padreaeliminar = this.actual;
    //         if(elem.compareTo(this.actual.valor) < 0){
    //             this.actual = this.actual.izq;
    //         }else{
    //             this.actual = this.actual.der;
    //         }
    //     }
    //     //caso no hay rama izq
    //     if(this.actual.izq == null && this.actual.der != null){
    //         if(this.actual.valor.compareTo(padreaeliminar.valor) < 0){
    //             padreaeliminar.izq = this.actual.der;
    //             this.actual.der = null;
    //             this.actual.padre = null;
    //         }else if(this.actual.valor.compareTo(padreaeliminar.valor) > 0){
    //             padreaeliminar.der = this.actual.der;
    //             this.actual.der = null;
    //             this.actual.padre = null;
    //         }
    //     } //caso no hay rama derecha
    //     if(this.actual.izq != null && this.actual.der == null){
    //         if(this.actual.valor.compareTo(padreaeliminar.valor) < 0){
    //             padreaeliminar.izq = this.actual.izq;   
    //             this.actual.izq = null; 
    //             this.actual.padre = null;
    //         }else if(this.actual.valor.compareTo(padreaeliminar.valor) > 0){
    //             padreaeliminar.der = this.actual.izq;
    //             this.actual.izq = null; 
    //             this.actual.padre = null;
    //         }
    //     }
    //      // caso sucesor inmediato,buscamos por la rama derecha
    //      if(actual.izq != null && actual.der != null && elem.compareTo(actual.valor) == 0){
    //         Nodo sucesor = new Nodo(this.actual.der.valor);
    //         Nodo padresucesor = new Nodo(sucesor.padre.valor);
    //         while (sucesor.der != null){
    //             padresucesor = sucesor;
    //             sucesor = sucesor.der;
    //         }
    //         if (sucesor.izq )
    //     }
    // }
    public void eliminar(T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo padreaeliminar;
        this.actual = this.raiz;
        while(elem.compareTo(this.actual.valor) != 0){ //avanzo el actual y padreaeliminar hasta encontrar el elem
                     padreaeliminar = this.actual;
                     if(elem.compareTo(this.actual.valor) < 0){
                         this.actual = this.actual.izq;
                     }else{
                         this.actual = this.actual.der;
                     }
                 }
        if(this.actual.izq == null && elem.compareTo(actual.valor) == 0){
            transplantar(this, actual, actual.der);
        }else if( this.actual.der == null && elem.compareTo(actual.valor) == 0){
            transplantar(this, actual, actual.izq);
        }else{
            Nodo sucesor = minimum(this.actual.der);
            if (sucesor != actual.der){
                transplantar(this, sucesor, sucesor.der);
                sucesor.der = actual.der;
                sucesor.der.padre = sucesor;
            }
            transplantar(this, actual, sucesor);
            sucesor.izq = actual.izq;
            sucesor.izq.padre = sucesor;
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
        return traducido(this);
    }

    private String traducido(ABB tree){
        StringBuilder palabra = new StringBuilder("{");
        Nodo act = tree.raiz;
        Stack<Nodo> stack = new Stack<>();
        while (!stack.isEmpty() || act != null){
            while (act != null){
                stack.push(act);
                act = act.izq;
            }
            act = stack.pop();
            palabra.append(act.valor);
            palabra.append(", ");
            act = act.der;
        }
        palabra.append("}");
        return palabra.toString();
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
