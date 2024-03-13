package estructura_de_datos;

public class Nodo<T> {
    Nodo<T> siguiente;
    T dato;
    public Nodo(T dato){
        this.dato = dato;
    }
}
