import java.util.*;

public class MainMenu{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        
        menu();
        while(!scan.hasNextInt()){
            System.out.println("Please enter a number: ");
            scan.nextLine();
        }

        choice = scan.nextInt();

        while(choice <= 0 || choice > 11){
            System.out.println("Invalid input.");
            System.out.print("Please enter size: ");
            choice = scan.nextInt();
        }

        scan.nextLine();

        while (choice != 11) {
            switch (choice) {
                case 1:
                    QueueMenu queueMenu = new QueueMenu();
                    queueMenu.queueListMenu();
                    break;
                case 2:
                    QueueMenu queueMenu2 = new QueueMenu();
                    queueMenu2.queueArrayMenu();
                case 3:
                    NodeListMenu nodeListMenu = new NodeListMenu();
                    nodeListMenu.nodeListMenu();
                    break;
                case 4:
                    InfixToPostFixMenu itop = new InfixToPostFixMenu();
                    itop.infixToPostFixMenu();
                    break;
                case 5:
                    SumAndProduct sumAndProduct = new SumAndProduct();
                    sumAndProduct.sumAndProductMenu();
                    break;
                case 6:
                    OddorEvenMenu oddorEvenMenu = new OddorEvenMenu();
                    oddorEvenMenu.oddorEvenMenu();
                    break;
                case 7:
                    Stackk stack = new Stackk();
                    stack.stackMenu(1);
                    break;
                case 8:
                    Stackk stack2 = new Stackk();
                    stack2.stackMenu(2);
                    break;
                case 9:
                    NoDuplicates noDuplicates = new NoDuplicates();
                    noDuplicates.noDuplicatesMenu();
                    break;

                case 10:
                    LargestAndSmallestMenu largestAndSmallestMenu = new LargestAndSmallestMenu();
                    largestAndSmallestMenu.largestAndSmallestMenu();
                    break;
                default:
                    break;
            }
        
            // Prompt user for the next choice
            menu();
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a number: ");
                scan.nextLine();
            }
            choice = scan.nextInt();
            scan.nextLine();
        }
        
    }

    public static void menu(){
        System.out.println("=========== Main Menu ===========");
        System.out.println("1.\tQueue Node.");
        System.out.println("2.\tQueue Array.");
        System.out.println("3.\tNodeList.");
        System.out.println("4.\tInfix to PostFix");
        System.out.println("5.\tSum and Product");
        System.out.println("6.\tOdd and Even");
        System.out.println("7.\tStack Array");
        System.out.println("8.\tStack Node ");
        System.out.println("9.\tNo Duplicates");
        System.out.println("10.\tLargest Smallest");
        System.out.println("11.\tExit.");
        System.out.print("Select choice: ");
    }
}
        
