package estructura_de_datos;

public class ListaEnlazada<T> {

    private Nodo<T> cabeza;
    private static int size = 0;

    public void add(T dato) {
        Nodo<T> creado = new Nodo<>(dato);
        creado.siguiente = cabeza;
        cabeza = creado;
        size++;
    }

    public void addEnd(T dato) {
        if (cabeza != null) {
            Nodo<T> apuntador = cabeza;
            while (apuntador.siguiente != null) {
                apuntador = apuntador.siguiente;
            }
            apuntador.siguiente = new Nodo<>(dato);
            size++;
        }
    }

    public void add(int index, T dato) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception(String.format("index %d out of range %d", index, size));
        }
        if (cabeza == null) {
            throw new Exception("null pointer excepcion because cabeza is null");
        }
        if (index == 0) {
            add(dato);
        } else if (index == size) {
            addEnd(dato);
        } else {
            Nodo<T> apuntador = cabeza;
            int contador = 0;

            while (contador++ < index - 1) {
                apuntador = apuntador.siguiente;
            }
            Nodo<T> creado = new Nodo<>(dato);
            creado.siguiente = apuntador.siguiente;
            apuntador.siguiente = creado;
            size++;
        }
    }

    public T pop() throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer excepcion because cabeza is null");
        }
        Nodo<T> temporal = cabeza;
        cabeza = cabeza.siguiente;
        temporal.siguiente = null;
        size--;
        return temporal.dato;
    }

    public T popEnd() throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer excepcion because cabeza is null");
        }

        Nodo<T> apuntador = cabeza;
        while (apuntador.siguiente.siguiente != null) {
            apuntador = apuntador.siguiente;
        }
        Nodo<T> temporal = apuntador.siguiente;
        apuntador.siguiente = null;
        size--;
        return temporal.dato;
    }

    public void delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception(String.format("index %d out of range %d", index, size));
        }
        if (cabeza == null) {
            throw new Exception("null pointer excepcion because cabeza is null");
        }

        if (index == 0) {
            pop();
        } else if (index == size - 1) {
            popEnd();
        } else {
            Nodo<T> apuntador = cabeza;
            int contador = 0;
            while (contador++ < index - 1) {
                apuntador = apuntador.siguiente;
            }
            Nodo<T> temporal = apuntador.siguiente;
            apuntador.siguiente = apuntador.siguiente.siguiente;
            temporal.siguiente = null;
            size--;
        }
    }

    public void delete(T dato) throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer excepcion because cabeza is null");
        }
        if (cabeza.dato.equals(dato)) {
            pop();
        }

        if(contains(dato)){
            Nodo<T> apuntador = cabeza;
            while (!apuntador.siguiente.dato.equals(dato)) {
                apuntador = apuntador.siguiente;
            }
            Nodo<T> temporal = apuntador.siguiente;
            apuntador.siguiente = apuntador.siguiente.siguiente;
            temporal.siguiente=null;
            size--;
        }


    }

    public boolean contains(T dato) throws Exception {
        if (cabeza == null) {
            throw new Exception("null pointer excepcion because cabeza is null");
        }
        Nodo<T> apuntador = cabeza;
        while (apuntador != null) {
            if (apuntador.dato.equals(dato)) return true;
            apuntador = apuntador.siguiente;
        }
        return false;
    }

    public void mostrar() throws Exception{
        if (cabeza != null) {
            System.out.println();
            Nodo<T> apuntador = cabeza;
            while (apuntador != null) {
                System.out.println(apuntador.dato);
                apuntador = apuntador.siguiente;
            }
        }else{
            throw new Exception("null pointer excepcion because cabeza is null");
        }
    }

    public int length() {
        return size;
    }

    public static void main(String[] args) throws Exception{
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.add("jesus");
        lista.add("ivan");
        lista.add("sandoval");
        lista.add("ramirez");
        lista.mostrar();

        lista.addEnd("lola");
        lista.mostrar();

        lista.add(2, "pepina");
        lista.mostrar();

        System.out.println("pop en la lista -> " + lista.pop());
        System.out.println("popEnd en la lista -> " + lista.popEnd());
        lista.mostrar();

        lista.delete(2);
        lista.mostrar();

        lista.delete("pepina");
        lista.mostrar();

        System.out.println(lista.contains("jesus"));

        System.out.println("length de la lista " + lista.length());

    }
}
