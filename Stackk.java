import java.util.*;

public class Stackk {
    public void stackMenu(int choice){
        Scanner scanner = new Scanner(System.in);
        if (choice == 1) {
            StackArray stackArray;
            int size;
            System.out.print("Enter size of the stack array: ");
            while(!scanner.hasNextInt()){
                System.out.println("Please enter a number: ");
                scanner.nextLine();
            }
    
            size = scanner.nextInt();
            stackArray = new StackArray(size);
            scanner.nextLine();
            
            do {
                System.out.println("\n========== Stack Array Menu ==========");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter a number to push: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Please enter a valid number.");
                            scanner.next();
                        }
                        int num = scanner.nextInt();
                        if (stackArray.push(num)) {
                            System.out.println("Number pushed successfully.");
                        } else {
                            System.out.println("Stack is full.");
                        }
                        break;
                    case 2:
                        if (stackArray.pop()) {
                            System.out.println("Number popped successfully.");
                        } else {
                            System.out.println("Stack is empty.");
                        }
                        break;
                    case 3:
                        int top = stackArray.peek();
                        if (top != 0) {
                            System.out.println("Top element is: " + top);
                        } else {
                            System.out.println("Stack is empty.");
                        }
                        break;
                    case 4:
                        System.out.println("Exiting Stack Array");
                        new MainMenu();
                        break;
                    default:
                        break;
                }
            } while (choice != 4);

        } else if (choice == 2) {
            StackList stackList = new StackList();
            do {
                System.out.println("\n========== Stack List Menu ==========");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter data to push: ");
                        String data = scanner.nextLine();
                        if (stackList.push(data)) {
                            System.out.println("Data pushed successfully.");
                        } else {
                            System.out.println("Error pushing data.");
                        }
                        break;
                    case 2:
                        String popped = stackList.pop();
                        if (popped != null) {
                            System.out.println("Popped: " + popped);
                        } else {
                            System.out.println("Stack is empty.");
                        }
                        break;
                    case 3:
                        String top = stackList.peek();
                        if (top != null) {
                            System.out.println("Top element is: " + top);
                        } else {
                            System.out.println("Stack is empty.");
                        }
                        break;
                    case 4:
                        System.out.println("Exiting StackList");
                        new MainMenu();
                        break;
                    default:
                        break;
                }
            } while (choice != 4);

        } else {
            System.out.println("Invalid stack type selected.");
        }
    }
}
class StackArray{

    private int[] size;
    private int count;

    public StackArray(int size){
        this.size = (size <= 0) ? new int[10] : new int[size];   
        count = 0;
    }
    public StackArray(){
        size = new int[10];
    }
    
    private boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull(){
        return count == size.length;
    }
    public boolean push(int num){
        if(!isFull()){
            size[count++] = num;
            return true;
        }
        return false;
    }
    public boolean pop(){
        if(!isEmpty()){
            size[count-1] = 0;
            count--;
            return true;
        }
        return false;
    }
    public int peek(){
        if(!isEmpty()){
            return size[count-1];
        }
        return 0;
    }

}
class StackNode {
    StackNode tail;
    String data;
    
    public StackNode(String data){
        this.data = data;
        tail = null;
    }
}
// SOAJHGIPAUSHG
class StackList {
    
    private StackNode top;
    private int count;

    public StackList(){
        top = null;
        count = 0;
    }

    private boolean isEmpty(){
        return count == 0;
    }

    public boolean push(String data){
        StackNode node = new StackNode(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }

    public String pop(){
        
        if(!isEmpty()){
            top = top.tail;
            count--;
            return peek();
        }
        return null;
    }

    public String peek(){
        if(!isEmpty()){
            return top.data;
        }
        return null;
    }
}

