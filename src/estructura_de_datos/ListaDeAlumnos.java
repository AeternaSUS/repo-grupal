package estructura_de_datos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;


public class ListaDeAlumnos extends JFrame {

    private static class Alumno {
        String nombre;
        int edad;
        int semestre;
        String carrera;

        public Alumno(String nombre, int edad, int semestre, String carrera) {
            this.nombre = nombre;
            this.edad = edad;
            this.semestre = semestre;
            this.carrera = carrera;
        }

        @Override
        public String toString() {
            return String.format("%s\t%d\t%d\t%s", nombre, edad, semestre, carrera);
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public int getSemestre() {
            return semestre;
        }
    }

    ArrayList<Alumno> lista = new ArrayList<>();
    File f = new File("Alumnos.txt");

    public void agregar() {
        String nombre = JOptionPane.showInputDialog("Nombre del estudiante");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("edad del estudiante"));
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("semestre en curso"));
        String carrera = JOptionPane.showInputDialog("carrera del estudiante");

        lista.add(new Alumno(nombre, edad, semestre, carrera));
        agregarAlArchivo(nombre, edad, semestre, carrera);

    }

    private void agregarAlArchivo(String nombre, int edad, int semestre, String carrera) {
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.write(String.format("%s\t%d\t%d\t%s\n", nombre, edad, semestre, carrera));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void leerArchivo() {
        try (BufferedReader bf = new BufferedReader(new FileReader(f))) {

            String[] separarCadena;
            String cadena = bf.readLine();

            while (cadena != null) {
                separarCadena = cadena.split("\t");
                lista.add(new Alumno(
                        separarCadena[0],
                        Integer.parseInt(separarCadena[1]),
                        Integer.parseInt(separarCadena[2]),
                        separarCadena[3]
                ));

                cadena = bf.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrar() {
        System.out.println("\nAlumnos en la lista: ");
        lista.forEach(System.out::println);
    }

    public void ordenar() {
        try {
            int op = Integer.parseInt(JOptionPane.showInputDialog("""

                    Por que caracteristica desea ordenar?
                    1.- Nombre
                    2.- Edad
                    3.- Semestre"""));

            switch (op) {
                case 1 -> ordenarPorNombre();
                case 2 -> ordenarPorEdad();
                case 3 -> ordenarPorSemestre();
            }

            JOptionPane.showMessageDialog(null, "Lista ordenada");
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error " + e.getMessage());

        }
    }

    private void ordenarPorNombre() {
        lista.sort(Comparator.comparing(Alumno::getNombre));

    }

    private void ordenarPorEdad() {
        lista.sort(Comparator.comparing(Alumno::getEdad));
    }

    private void ordenarPorSemestre() {
        lista.sort(Comparator.comparing(Alumno::getSemestre));
    }

    public void eliminar() {
        String nombre = JOptionPane.showInputDialog("Nombre del alumno a eliminar");

        if (lista.removeIf(a -> a.getNombre().equals(nombre))) {
            JOptionPane.showMessageDialog(null, "Alumno eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado");
        }
        actualizarArchivo();
    }

    public void actualizarArchivo() {
        try (FileWriter fw = new FileWriter(f, false)) {
            for (Alumno alumno : lista) {
                fw.write(alumno.toString() + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int op;
        ListaDeAlumnos l = new ListaDeAlumnos();
        l.leerArchivo();
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("""

                        Ingrese opcion
                        1.- Agregar
                        2.- Mostrar
                        3.- Ordenar
                        4.- Eliminar Alumno
                        5.- Salir"""));

                switch (op) {
                    case 1 -> l.agregar();
                    case 2 -> l.mostrar();
                    case 3 -> l.ordenar();
                    case 4 -> l.eliminar();
                    case 5 -> System.exit(0);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
