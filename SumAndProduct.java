import java.util.*;

public class SumAndProduct {   
    public void sumAndProductMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== Sum and Product Menu ==========");
            System.out.println("1. Calculate Sum of Two Numbers");
            System.out.println("2. Calculate Product of Two Numbers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.println("Sum: " + (num1 + num2));
                    break;
                case 2:
                    System.out.print("Enter the first number: ");
                    double num3 = scanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    double num4 = scanner.nextDouble();
                    System.out.println("Product: " + (num3 * num4));
                    break;
                case 3:
                    System.out.println("Exiting Sum and Product");
                    new MainMenu();
                    break;
                default:
                    break;
            }
        } while (choice != 3);

    }
}
