package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    int longitu = 0;
    Nodo primero;
    Nodo ultimo;
    private class Nodo {
        Nodo anterior;
        Nodo siguiente;
        T valor = null; 
    }

    public ListaEnlazada() {
    }

    public ListaEnlazada<T> ListaCopiada(ListaEnlazada<T> listita){
        ListaEnlazada<T> listaa = new ListaEnlazada<>();
        listaa.longitu = listita.longitu;
        listaa.primero = listita.primero;
        listaa.ultimo = listita.ultimo;
        Nodo recorredor = new Nodo();
        for (recorredor = listita.primero; recorredor != null ;recorredor = recorredor.siguiente){
            listaa.agregarAtras(recorredor.valor);
        }
        return listaa;
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
        if (this.longitu != 0){
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
        }else{
            this.primero = nuevo;
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
        Nodo actual = this.primero.siguiente;
        if (i == 0) {
            //actual.anterior = null;
            this.primero = actual;
        }
        if (i == this.longitu -1){
            actual = this.ultimo.anterior;
            this.ultimo = actual;
            //actual.siguiente = null;
        }
        for (int j = 1; j < i;j++){
            previo = actual;
            actual = actual.siguiente;
        }
        previo.siguiente = actual.siguiente;
        actual.siguiente.anterior = previo;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = this.primero;
        for(int j = 0; j < indice; j++){
            actual = actual.siguiente;
        }
        actual.valor = elem;

    }

     public ListaEnlazada<T> copiar() {
         return ListaCopiada(this);
     }

    // public ListaEnlazada(ListaEnlazada<T> lista) {
    //     ;
    // }
    
    // @Override
    // public String toString() {
    //     ;
    // }

    // private class ListaIterador implements Iterador<T> {
    // 	// Completar atributos privados

    //     public boolean haySiguiente() {
	//         ;
    //     }
        
    //     public boolean hayAnterior() {
	//         ;
    //     }

    //     public T siguiente() {
	//         ;
    //     }
        

    //     public T anterior() {
	//         ;
    //     }
    // }

    // public Iterador<T> iterador() {
	//     ;
    // }

}
