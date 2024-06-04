package numero.com;

import java.util.Arrays;
import java.util.Scanner;




public class Numeros {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingresa la cantidad de números: ");
            int n = scanner.nextInt();

            int[] numbers = new int[n];
            System.out.println("Ingresa los números uno por uno:");

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            System.out.print("¿Ordenar en orden ascendente (1) o descendente (2)? ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Arrays.sort(numbers);
                case 2 -> {
                    Arrays.sort(numbers);
                    reverseArray(numbers);
                }
                default -> {
                    System.out.println("Opción no válida. Saliendo del programa.");
                    return;
                }
            }

            System.out.println("Números ordenados:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        }
    }

    private static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
