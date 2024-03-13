package estructura_de_datos;

public class Cola<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private static int size = 0;

    public int length() {
        return size;
    }

    public void mostrar() throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer exception because cabeza is null");
        }
        Nodo<T> apuntador = cabeza;
        System.out.println("Datos de la cola");
        while (apuntador != null) {
            System.out.println(apuntador.dato);
            apuntador = apuntador.siguiente;
        }
    }

    public void offer(T dato) {
        Nodo<T> creado = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = creado;
        } else {
            cola.siguiente = creado;
        }
        cola = creado;
        size++;
    }

    public T poll() throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer exception because cabeza is null");
        }
        Nodo<T> temporal = cabeza;
        cabeza = cabeza.siguiente;
        temporal.siguiente = null;

        if (cabeza == null) {
            cola = null;
        }
        size--;
        return temporal.dato;
    }

    public static void main(String[] args) throws Exception {
        Cola<String> cola = new Cola<>();
        cola.offer("jesus");
        cola.offer("ivan");
        cola.offer("sandoval");
        cola.offer("ramirez");
        cola.mostrar();

        String poll = cola.poll();
        System.out.println("poll = " + poll);
        cola.mostrar();

        System.out.println("cola length -> " + cola.length());
    }

}
