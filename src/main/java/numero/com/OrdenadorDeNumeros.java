package numero.com;

import java.util.ArrayList;
import java.util.Scanner;

//Entrada de Números
//Permitir a los usuarios ingresar números hasta que decidan terminar la entrada.

public class OrdenadorDeNumeros {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numeros = new ArrayList<>();
            
            System.out.println("Ingrese una lista de números. Ingrese 'q' para terminar:");
            while (true) {
                String entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("q")) {
                    break;
                }
                try {
                    int numero = Integer.parseInt(entrada);
                    if (numero == 4) {
                        System.out.println("El número 4 no está permitido.");
                    } else {
                        numeros.add(numero);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingrese un número o 'q' para terminar.");
                }
            }

//Selección del Método de Ordenación
//Permitir al usuario seleccionar el algoritmo de ordenación y el tipo de orden (ascendente o descendente)

            System.out.println("Seleccione el método de ordenación: 1. Burbuja  2. Selección");
            int metodo = scanner.nextInt();

            System.out.println("Seleccione el orden: 1. Ascendente  2. Descendente");
            int orden = scanner.nextInt();

            switch (metodo) {
                case 1 -> burbuja(numeros, orden == 1);
                case 2 -> seleccion(numeros, orden == 1);
                default -> {
                    System.out.println("Método de ordenación no válido.");
                    return;
                }
            }

            System.out.println("Números ordenados: " + numeros);
        }
    }

//Implementación de los Algoritmos de Ordenación
//Implementaremos los algoritmos de burbuja y selección.

    public static void burbuja(ArrayList<Integer> numeros, boolean ascendente) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascendente && numeros.get(j) > numeros.get(j + 1)) ||
                    (!ascendente && numeros.get(j) < numeros.get(j + 1))) {
                    int temp = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, temp);
                }
            }
        }
    }

    public static void seleccion(ArrayList<Integer> numeros, boolean ascendente) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if ((ascendente && numeros.get(j) < numeros.get(index)) ||
                    (!ascendente && numeros.get(j) > numeros.get(index))) {
                    index = j;
                }
            }
            int temp = numeros.get(index);
            numeros.set(index, numeros.get(i));
            numeros.set(i, temp);
        }
    }
}
