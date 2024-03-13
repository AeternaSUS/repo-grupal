package estructura_de_datos;

public class ArbolBinarioDeBusqueda {

    private static class Nodo {
        int dato;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(int dato) {
            this.dato = dato;
        }
    }

    private Nodo raiz;

    public boolean contains(int dato) throws Exception {
        if (raiz == null) {
            throw new Exception("null pointer exception because raiz is null, pendejo");
        }
        return contains(dato, raiz);
    }

    private boolean contains(int dato, Nodo raiz) {
        if (raiz != null) {
            if (raiz.dato == dato) {
                return true;
            } else if (dato < raiz.dato) {
                return contains(dato, raiz.izquierdo);
            } else {
                return contains(dato, raiz.derecho);
            }
        }
        return false;
    }

    public void insertar(int dato) {
        raiz = insertar(dato, raiz);
    }

    private Nodo insertar(int dato, Nodo raiz) {
        if (raiz == null) {
            raiz = new Nodo(dato);
        } else {
            if (dato < raiz.dato) {
                raiz.izquierdo = insertar(dato, raiz.izquierdo);
            } else if (dato > raiz.dato) {
                raiz.derecho = insertar(dato, raiz.derecho);
            }
        }
        return raiz;
    }

    public void eliminar(int dato) throws Exception {
        if (raiz == null) {
            throw new Exception("null pointer exception because raiz is null");
        }
        if (contains(dato)) {
            raiz = eliminar(dato, raiz);
        }
    }

    private Nodo eliminar(int dato, Nodo raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.dato == dato) {
            if (raiz.izquierdo == null && raiz.derecho == null) {
                raiz = null;
            } else if (raiz.izquierdo != null) {
                raiz.dato = maximoMayor(raiz.izquierdo);
                raiz.izquierdo = eliminar(raiz.dato, raiz.izquierdo);
            } else {
                raiz.dato = maximoMenor(raiz.derecho);
                raiz.derecho = eliminar(raiz.dato, raiz.derecho);
            }
        } else {
            if (dato < raiz.dato) {
                raiz.izquierdo = eliminar(dato, raiz.izquierdo);
            } else {
                raiz.derecho = eliminar(dato, raiz.derecho);
            }
        }
        return raiz;
    }

    private int maximoMenor(Nodo raiz) {
        if (raiz.izquierdo != null) {
            return maximoMenor(raiz.izquierdo);
        }
        return raiz.dato;
    }

    private int maximoMayor(Nodo raiz) {
        if (raiz.derecho != null) {
            return maximoMayor(raiz.derecho);
        }
        return raiz.dato;
    }

    public void inorden() throws Exception {
        if (raiz == null) {
            throw new Exception("null pointer exception because raiz is null");
        }
        System.out.println("Inorden");
        inordenAux(raiz);
        System.out.println();
    }

    private void inordenAux(Nodo raiz) {
        if (raiz != null) {
            inordenAux(raiz.izquierdo);
            System.out.print(raiz.dato + ", ");
            inordenAux(raiz.derecho);
        }
    }


    public static void main(String[] args) throws Exception {
        ArbolBinarioDeBusqueda arbol = new ArbolBinarioDeBusqueda();
        arbol.insertar(50);
        arbol.insertar(20);
        arbol.insertar(30);
       // arbol.insertar(10);
        arbol.insertar(80);
        arbol.insertar(100);
        arbol.insertar(60);
        arbol.insertar(90);
        arbol.insertar(70);
        arbol.insertar(40);
        //insercios de 25 solo para probar la eliminacion por maximo menor
        arbol.insertar(25);

        arbol.inorden();

        System.out.println("eliminamos 80");
        arbol.eliminar(80);
        arbol.inorden();

        System.out.println("eliminamos 20");
        arbol.eliminar(20);
        arbol.inorden();





    }
}
