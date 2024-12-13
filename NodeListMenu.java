import java.util.Scanner;

public class NodeListMenu{
    
    public void nodeListMenu(){
        NodeList nodeList = new NodeList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== NodeList Menu ==========");
            System.out.println("1. Add Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Display List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data for the node: ");
                    int data = scanner.nextInt();
                    NodeList.Node newNode = new NodeList.Node(data);
                    nodeList.add(newNode);
                    System.out.println("Node added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the position to delete: ");
                    int position = scanner.nextInt();
                    if (nodeList.delete(position)) {
                        System.out.println("Node deleted successfully.");
                    } else {
                        System.out.println("Invalid position or list is empty.");
                    }
                    break;
                case 3:
                    System.out.println("Current list: ");
                    nodeList.display();
                    break;
                case 4:
                    new MainMenu();
                    System.out.println("Exiting Node List");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

    }
}


class NodeList {
    private int count;
    private Node head;

  
    public NodeList() {
        this.head = null;
        this.count = 0;
    }

 
    private boolean isEmpty() {
        return count == 0;
    }

 
    public boolean add(Node item) {
        Node node = new Node(item.data);

        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

        count++;
        return true;
    }

   
    public boolean delete(int location) {
        if (location < 1 || location > count || isEmpty()) {
            return false;
        }

        if (location == 1) {
            head = head.next; 
        } else {
            Node current = head;
            Node previous = null;
            for (int i = 1; i < location; i++) {
                previous = current;
                current = current.next;
            }
            if (previous != null) {
                previous.next = current.next; 
            }
        }

        count--;
        return true;
    }

    
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

