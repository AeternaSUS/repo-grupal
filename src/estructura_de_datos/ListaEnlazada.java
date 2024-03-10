package estructura_de_datos;

public class ListaEnlazada<T> {

    public static class Nodo<T> {
        Nodo<T> siguiente;
        T dato;

        public Nodo(T dato) {
            this.dato = dato;
        }
    }

    private Nodo<T> cabeza;
    private static int size = 0;

    public void add(T dato) {
        Nodo<T> creado = new Nodo<>(dato);
        creado.siguiente = cabeza;
        cabeza = creado;
        size++;
    }

    public void mostrar() {
        if(cabeza != null){
            Nodo<T> apuntador = cabeza;
            while(apuntador != null){
                System.out.println(apuntador.dato);
                apuntador = apuntador.siguiente;
            }
        }
    }

    public int length(){
        return size;
    }

    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.add("jesus");
        lista.add("ivan");
        lista.add("sandoval");
        lista.add("ramirez");

        lista.mostrar();

        System.out.println(lista.length());
    }


}
