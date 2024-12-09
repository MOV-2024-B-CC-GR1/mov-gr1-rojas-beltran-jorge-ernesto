import java.util.*;

public class Main {
    public static void main(String[] args) {
        // INMUTABLES
        final String inmutable = "Jorge";
        // inmutable = "Elias"; // Error!

        // MUTABLES
        String mutable = "Bolanos";
        mutable = "Elias"; // Ok

        // Duck Typing no existe en Java, pero se usan tipos explícitos
        String ejemploVariable = " Jorge Rojas ";
        ejemploVariable = ejemploVariable.trim();
        int edadEjemplo = 12;
        // ejemploVariable = edadEjemplo; // Error!

        // Variables Primitivas
        String nombreProfesor = "Jorge Rojas";
        double sueldo = 1.2;
        char estadoCivil = 'C';
        boolean mayorEdad = true;
        Date fechaNacimiento = new Date();

        // Switch
        String estadoCivilWhen = "C";
        switch (estadoCivilWhen) {
            case "C":
                System.out.println("Casado");
                break;
            case "S":
                System.out.println("Soltero");
                break;
            default:
                System.out.println("No sabemos");
        }

        boolean esSoltero = estadoCivilWhen.equals("S");
        String coqueteo = esSoltero ? "Si" : "No";

        imprimirNombre("Jorge");

        calcularSueldo(10.00); // solo parámetro requerido
        calcularSueldo(10.00, 15.00, 20.00); // parámetros opcionales
        calcularSueldo(10.00, 14.00, 20.00); // parámetros nombrados en Java

        // Clases
        Suma sumaA = new Suma(1, 1);
        Suma sumaB = new Suma(null, 1);
        Suma sumaC = new Suma(1, null);
        Suma sumaD = new Suma(null, null);
        sumaA.sumar();
        sumaB.sumar();
        sumaC.sumar();
        sumaD.sumar();
        System.out.println(Suma.pi);
        System.out.println(Suma.elevarAlCuadrado(2));
        System.out.println(Suma.historialSumas);

        // Arreglos estáticos
        Integer[] arregloEstatico = {1, 2, 3};
        System.out.println(Arrays.toString(arregloEstatico));

        // Arreglos dinámicos
        ArrayList<Integer> arregloDinamico = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(arregloDinamico);
        arregloDinamico.add(11);
        arregloDinamico.add(12);
        System.out.println(arregloDinamico);

        // For-each
        arregloDinamico.forEach(valorActual -> System.out.println("Valor actual: " + valorActual));

        // Map
        List<Double> respuestaMap = new ArrayList<>();
        for (int valorActual : arregloDinamico) {
            respuestaMap.add(valorActual + 100.00);
        }
        System.out.println(respuestaMap);

        // Filter
        List<Integer> respuestaFilter = new ArrayList<>();
        for (int valorActual : arregloDinamico) {
            if (valorActual > 5) {
                respuestaFilter.add(valorActual);
            }
        }
        System.out.println(respuestaFilter);

        // Reduce
        int respuestaReduce = 0;
        for (int valorActual : arregloDinamico) {
            respuestaReduce += valorActual;
        }
        System.out.println(respuestaReduce);
    }

    public static void imprimirNombre(String nombre) {
        System.out.println("Nombre: " + nombre);
    }

    public static double calcularSueldo(double sueldo, double tasa, Double bonoEspecial) {
        if (bonoEspecial == null) {
            return sueldo * (100 / tasa);
        } else {
            return sueldo * (100 / tasa) * bonoEspecial;
        }
    }

    public static double calcularSueldo(double sueldo) {
        return calcularSueldo(sueldo, 12.00, null);
    }

    public static double calcularSueldo(double sueldo, double tasa, double bonoEspecial) {
        return calcularSueldo(sueldo, tasa, Double.valueOf(bonoEspecial));
    }
}

abstract class Numeros {
    protected int numeroUno;
    protected int numeroDos;

    public Numeros(int uno, int dos) {
        this.numeroUno = uno;
        this.numeroDos = dos;
    }
}

class Suma extends Numeros {
    public static final double pi = 3.14;
    public static List<Integer> historialSumas = new ArrayList<>();

    public Suma(int uno, int dos) {
        super(uno, dos);
    }

    public Suma(Integer uno, int dos) {
        this(uno != null ? uno : 0, dos);
    }

    public Suma(int uno, Integer dos) {
        this(uno, dos != null ? dos : 0);
    }

    public Suma(Integer uno, Integer dos) {
        this(uno != null ? uno : 0, dos != null ? dos : 0);
    }

    public int sumar() {
        int total = numeroUno + numeroDos;
        agregarHistorial(total);
        return total;
    }

    public static int elevarAlCuadrado(int num) {
        return num * num;
    }

    public static void agregarHistorial(int valorTotalSuma) {
        historialSumas.add(valorTotalSuma);
    }
}
