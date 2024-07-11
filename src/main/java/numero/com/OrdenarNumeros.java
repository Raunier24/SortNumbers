package numero.com;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdenarNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Ingrese números (ingrese 'fin' para terminar):");
        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                if (numero != 4) {
                    numeros.add(numero);
                } else {
                    System.out.println("El número 4 no está permitido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }

        System.out.println("Seleccione el tipo de ordenación: (1) Ascendente (2) Descendente");
        int tipoOrdenacion = scanner.nextInt();

        if (tipoOrdenacion == 1) {
            ordenarBurbuja(numeros, true);
        } else if (tipoOrdenacion == 2) {
            ordenarBurbuja(numeros, false);
        } else {
            System.out.println("Selección no válida.");
        }

        System.out.println("Lista de números ordenados: " + numeros);
    }

    public static void ordenarBurbuja(ArrayList<Integer> numeros, boolean ascendente) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascendente ? numeros.get(j) > numeros.get(j + 1) : numeros.get(j) < numeros.get(j + 1)) {
                    int temp = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, temp);
                }
            }
        }
    }
}
