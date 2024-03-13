package estructura_de_datos;

public class Pila<T> {
    private Nodo<T> cabeza;
    private static int size = 0;

    public int length() {
        return size;
    }

    public void mostrar() throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer exception because cabeza is null");
        }
        Nodo<T> apuntador = cabeza;
        System.out.println();
        while (apuntador != null) {
            System.out.println(apuntador.dato);
            apuntador = apuntador.siguiente;
        }
    }

    public void push(T dato) {
        Nodo<T> creado = new Nodo<>(dato);
        creado.siguiente = cabeza;
        cabeza = creado;
        size++;
    }

    public T pop() throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer exception because cabeza is null");
        }
        Nodo<T> temporal = cabeza;
        cabeza = cabeza.siguiente;
        temporal.siguiente = null;
        size--;
        return temporal.dato;
    }

    public static void main(String[] args) throws Exception {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.mostrar();

        int pop = pila.pop();
        System.out.println("pop = " + pop);
        pila.mostrar();

        System.out.println("length -> " + pila.length());

    }
}
