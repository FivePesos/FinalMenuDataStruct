import java.util.*;

public class QueueMenu {
    public void queueArrayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of the queue: ");

        int size = getValidInt(scan, 1, Integer.MAX_VALUE);
        QueueArray queue = new QueueArray(size);

        int choice;
        do {
            menuArray();
            choice = getValidInt(scan, 1, 5);

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    Object value = scan.nextLine();
                    if (queue.enQueue(value)) {
                        System.out.println("Successfully inserted.");
                    } else {
                        System.out.println("Queue is full.");
                    }
                    break;

                case 2:
                    if (queue.deQueue()) {
                        System.out.println("Successfully dequeued.");
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 3:
                    Object frontValue = queue.front();
                    System.out.println(frontValue != null ? "Front: " + frontValue : "Queue is empty.");
                    break;

                case 4:
                    System.out.println("Queue contents:");
                    queue.display();
                    break;

                case 5:
                    System.out.println("Exiting QueueArray menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public void queueListMenu() {
        Scanner scan = new Scanner(System.in);
        QueueNode queue = new QueueNode();

        int choice;
        do {
            menuNode();
            choice = getValidInt(scan, 1, 6);

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    Object value = scan.nextLine();
                    if (queue.enqueue(value)) {
                        System.out.println("Successfully inserted.");
                    }
                    break;

                case 2:
                    if (queue.dequeue()) {
                        System.out.println("Successfully dequeued.");
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 3:
                    System.out.println("Front: " + (queue.getFirst() != null ? queue.getFirst() : "Queue is empty."));
                    break;

                case 4:
                    System.out.println("Last: " + (queue.getLast() != null ? queue.getLast() : "Queue is empty."));
                    break;

                case 5:
                    System.out.println("Queue contents:");
                    queue.display();
                    break;

                case 6:
                    System.out.println("Exiting QueueNode menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void menuArray() {
        System.out.println("=========== QueueArray Menu ===========");
        System.out.println("1. Enqueue Item.");
        System.out.println("2. Dequeue Item.");
        System.out.println("3. Display Front.");
        System.out.println("4. Display All.");
        System.out.println("5. Exit.");
        System.out.print("Select choice: ");
    }

    private static void menuNode() {
        System.out.println("=========== QueueNode Menu ===========");
        System.out.println("1. Enqueue Item.");
        System.out.println("2. Dequeue Item.");
        System.out.println("3. Display Front.");
        System.out.println("4. Display Last.");
        System.out.println("5. Display All.");
        System.out.println("6. Exit.");
        System.out.print("Select choice: ");
    }

    private int getValidInt(Scanner scan, int min, int max) {
        while (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ": ");
            scan.nextLine();
        }
        int input = scan.nextInt();
        scan.nextLine(); // Consume newline
        while (input < min || input > max) {
            System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
            input = scan.nextInt();
            scan.nextLine(); // Consume newline
        }
        return input;
    }
}



class Node{
    Node next;
    Object value;

    public Node(Object value){
        this.value = value;
        next = null;
    }
}

class QueueNode{ 
    Node first;
    Node last;
    int count;

    public QueueNode(){
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmpty(){
        return first == null && last  == null; //returns true if first and last is equal to null
    }

    public boolean enqueue(Object value){

        //first = last = newNode;
        Node newNode = new Node(value);

        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        count++;
        return true;
    }

    public boolean dequeue(){
        if(!isEmpty()){
            if(first == last){
                first = null;
                last = null;
            }
            else{
                first = first.next;
            }
            count--;
            return true;
        }
        return false;
    }
    //toString
    public String toString(){
        String result = "";
        if(!isEmpty()){
    
            Node tempNode = first;
            while(tempNode != null){
                result += "[" + tempNode.value + "] ->";
                tempNode = tempNode.next;
            }
            result += "\n";
            return result;
        }
        return null;
    }
    
    public void display(){
        if(!isEmpty()){
            Node temp = first;
            while(temp != null){
                System.out.print("[" + temp.value + "] -> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }   
        else{
            System.out.println("Queue is empty");
        }
    }
    public Object getFirst(){
        if(!isEmpty()){
            return first.value;
        }
        return null;
    }

    public Object getLast(){
        if(!isEmpty()){
            return last.value;
        }
        return null;
    }
}

class QueueArray{
    private Object[] items;//create Array
    private int count;//create count
    
    public QueueArray(int size){//contructor
       items = new Object[size];
       count = 0;
    }
    
    public boolean isEmpty(){//checks if the array is empty
       if(count == 0){
          return true;
       }
       else
          return false;
    }
    
    public boolean isFull(){//checks if the array is full
       return count == items.length;
    }
    
    public boolean enQueue(Object val){
       if(!isFull()){// checks the array if its not full so it can add an value
          items[count++] = val;
          return true;
       }
       return false;// else it return to false
    }
    
    public boolean deQueue(){
       if(!isEmpty()){// checks the array if its not empty so it can delete a value 
          for(int i = 1; i<count; i++){
             items[i-1] = items[i];// item[0] = item[1] so in and so forth
          }
          items[count-1] = null; //at end, the max lenght of the array will minused and set the last array to null 
          count -= 1;
          return true;
       }
       return false;
    }
    
    public Object front(){//checks the 1st value of a array
       if(!isEmpty()){//if its not empty it will checks the item
          return items[0];
       }
       return null;
    }
    
    public void display(){
       if(!isEmpty()){//displays if the array is not empty
          for(int i = 0; i<count; i++){
             System.out.println("["+items[i]+"]");
          }
          System.out.println();
       }
       else
          System.out.println("Queue is Empty...... T^T womp womp");
    }
    
    
 }
