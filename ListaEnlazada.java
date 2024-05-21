package aed;

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

    public ListaEnlazada<T> CopiaListaEnlazada(ListaEnlazada<T> listita){
        ListaEnlazada<T> listaa = new ListaEnlazada<>();
        listaa.longitu = listita.longitu;
        if (listita.longitu == 0){
            return listaa;
        }else{
            Nodo recorredor = new Nodo();
            for (recorredor = listita.primero; recorredor != null ;recorredor = recorredor.siguiente){
                Nodo nuevo = new Nodo();
                nuevo.valor = recorredor.valor;
                listaa.agregarAtras(nuevo.valor);
            }
            listaa.ultimo = listita.ultimo;
            return listaa;
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
        if (this.longitu != 0){
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
        }
        this.ultimo = nuevo; 
        this.longitu++;
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
         return CopiaListaEnlazada(this);
     }
    
     @Override
     public String toString() {
        StringBuilder palabra =  new StringBuilder();
        Nodo actual = new Nodo();
        actual = this.primero;
        palabra.append("[");
        for (int i = 0; i < this.longitu -1; i++) {
            palabra.append(actual.valor);
            palabra.append(",");
            actual = actual.siguiente;
        }
        palabra.append(this.ultimo.valor);
        palabra.append("]");
        return palabra.toString();
     }

     private class ListaIterador implements Iterador<T> {
         Nodo actual;
         Nodo siguiente;
         Nodo anterior;

         public boolean haySiguiente() {
	        if(this.actual == ListaEnlazada.this.ultimo || ListaEnlazada.this.longitu == 0){
                return false;
            }
            else {
                return true;
            }
         }
        
         public boolean hayAnterior() {
            if (ListaEnlazada.this.longitu == 0 || this.actual == ListaEnlazada.this.primero) {
                return false;
            }else {
                return true;
            }
            }

         public T siguiente() {
                this.actual = this.actual.siguiente;
                return this.actual.valor;
            }
        
         public T anterior() {
                this.actual = this.actual.anterior;
                return this.actual.valor;
            }
     }

     public Iterador<T> iterador() {
        ListaIterador iteradorcito = new ListaIterador();
        return iteradorcito;
     }

}