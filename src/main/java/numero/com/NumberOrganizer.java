package numero.com;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberOrganizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Write your numbers (write 'end' to finish):");
        while (true) {
            String entrance = scanner.nextLine();
            if (entrance.equalsIgnoreCase("end")) {
                break;
            }

            try {
                int number = Integer.parseInt(entrance);
                if (number != 4) {
                    numbers.add(number);
                } else {
                    System.out.println("Number 4 is not allowed.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ticket not valid.Please enter a number.");
            }
        }

        System.out.println("Select sort type: (1) Ascending (2) Descending");
        int orderType = scanner.nextInt();

        if (orderType == 1) {
            ordenarBurbuja(numbers, true);
        } else if (orderType == 2) {
            ordenarBurbuja(numbers, false);
        } else {
            System.out.println("Invalid selection.");
        }

        System.out.println("List of ordered numbers: " + numbers);
    }

    private static void ordenarBurbuja(ArrayList<Integer> numbers, boolean ascending) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? numbers.get(j) > numbers.get(j + 1) : numbers.get(j) < numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }
}
