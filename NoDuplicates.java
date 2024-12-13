import java.util.Scanner;

public class NoDuplicates {

    public void noDuplicatesMenu() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int count = 0;
        int choice = 0;

        System.out.println("=========== No Duplicates Menu ===========");
        System.out.println("1. Start");
        System.out.println("2. Exit");
        System.out.print("Enter Choice: ");

        
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid choice (1 or 2): ");
            scanner.nextLine(); 
        }

        choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            int j = 0;
            while (j < 10) {
                System.out.print("Enter number " + (j + 1) + " of 10: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number: ");
                    scanner.nextLine();
                }

                int number = scanner.nextInt();

                boolean isDuplicate = false;
                for (int i = 0; i < count; i++) {
                    if (numbers[i] == number) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    numbers[count] = number;
                    count++;
                    j++;  
                }else{
                    j++;
                }
            }

         
            System.out.println("\nHere are your unique numbers:");
            for (int i = 0; i < count; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

        } else if (choice == 2) {
            System.out.println("Exiting No Duplicates");
            
            new MainMenu();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }

      
    }
}
