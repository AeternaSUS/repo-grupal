package estructura_de_datos;

public class ListaConOrden<T extends Comparable<? super T>> {

    private Nodo<T> cabeza;

    public void add(T dato) {
        if (cabeza == null) {
            cabeza = new Nodo<>(dato);
        } else {
            if (dato.compareTo(cabeza.dato) < 0) {
                push(dato);
            } else {
                insert(cabeza, dato);
            }
        }

    }

    private void push(T dato) {
        Nodo<T> creado = new Nodo<>(dato);
        creado.siguiente = cabeza;
        cabeza = creado;
    }

    private void insert(Nodo<T> raiz, T dato) {

        if (raiz.siguiente == null) {
            raiz.siguiente = new Nodo<>(dato);
        } else if (dato.compareTo(raiz.dato) >= 0 && dato.compareTo(raiz.siguiente.dato) < 0) {
            Nodo<T> creado = new Nodo<>(dato);
            creado.siguiente = raiz.siguiente;
            raiz.siguiente = creado;
        } else {
            insert(raiz.siguiente, dato);
        }

    }

    public void mostrar() {
        Nodo<T> apuntador = cabeza;

        while (apuntador != null) {
            System.out.println(apuntador.dato);
            apuntador = apuntador.siguiente;
        }
    }


    public static void main(String[] args) {

        ListaConOrden<Integer> lista = new ListaConOrden<>();
        for(int i = 0; i<10; i++){
            lista.add((int) (Math.random() * 50));
        }

        lista.mostrar();
    }
}
