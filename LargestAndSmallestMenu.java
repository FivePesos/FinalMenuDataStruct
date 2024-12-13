import java.util.Scanner;

public class LargestAndSmallestMenu{

    public void largestAndSmallestMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("=========== Number Menu ===========");
            System.out.println("1. Enter 3 numbers and find the largest and smallest");
            System.out.println("2. Exit");
            System.out.print("Enter Choice: ");
            
            
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid choice (1 or 2): ");
                scanner.nextLine(); 
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                
                System.out.println("Enter 3 numbers:");

                double[] numbers = new double[3];
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Please enter a valid number: ");
                        scanner.nextLine(); 
                    }
                    numbers[i] = scanner.nextDouble();
                }

                
                double largest = numbers[0];
                double smallest = numbers[0];

                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] > largest) {
                        largest = numbers[i];
                    }
                    if (numbers[i] < smallest) {
                        smallest = numbers[i];
                    }
                }

                
                System.out.println("The largest number is: " + largest);
                System.out.println("The smallest number is: " + smallest);
            } 
            else if (choice == 2) {
                System.out.println("Exiting the Largest And Smallest Menu.");
                break;
            } 
            else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }
}
