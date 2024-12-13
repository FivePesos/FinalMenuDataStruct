import java.util.*;
public class OddorEvenMenu {
    public void oddorEvenMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== Odd or Even Menu ==========");
            System.out.println("1. Input 10 Numbers and Determine Odd or Even");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int[] numbers = new int[10];
                    System.out.println("Enter 10 numbers:");
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Number " + (i + 1) + ": ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Please enter a valid integer.");
                            scanner.next();
                        }
                        numbers[i] = scanner.nextInt();
                    }

                    System.out.println("\nResults:");
                    for (int i = 0; i < 10; i++) {
                        if (numbers[i] % 2 == 0) {
                            System.out.println("Number " + numbers[i] + " is Even.");
                        } else {
                            System.out.println("Number " + numbers[i] + " is Odd.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Exiting Odd or Even Menu");
                    new MainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 2);
    }
}
