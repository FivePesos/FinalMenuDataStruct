import java.util.*;

public class InfixToPostFixMenu{
    public void infixToPostFixMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== Infix to Postfix Menu ==========");
            System.out.println("1. Convert Infix to Postfix");
            System.out.println("2. Evaluate Postfix Expression");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter infix expression: ");
                    String infixExpression = scanner.nextLine();
                    System.out.print("Postfix expression: ");
                    new InfixToPostfixConverter(infixExpression);
                    break;
                case 2:
                    System.out.print("Enter postfix expression to evaluate: ");
                    String postfixExpression = scanner.nextLine();
                    new InfixToPostfixEvaluate(postfixExpression);
                    break;
                case 3:
                    System.out.println("Exiting Infix to Postfix");
                    new MainMenu();
                    break;
                default:
                    break;
            }
        } while (choice != 3);

    }
}
class InfixToPostfixConverter{
    private int precedence(char c){
        if(c == '^'){
            return 3;
        }else if(c == '*' || c == '/'){
            return 2;
        }else if(c == '-' || c == '+'){
            return 1;
        }else{
            return -1;
        }
    }
    public InfixToPostfixConverter(String value){
        Stack<Character> st = new Stack<>();
        String result = "";

        for(int i = 0; i < value.length(); i++){
            char c = value.charAt(i);

            if(Character.isLetterOrDigit(c)){
                result += c;
            }

            else if(c == '(' ){
                st.push(c);
            }else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    result += st.pop();
                }
                st.pop();
            }else{
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek())){
                    result += st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            result += st.pop();
        }

        System.out.println(result);
    }
}
class InfixToPostfixEvaluate {
    public InfixToPostfixEvaluate(String value) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            double ans = 0;

            if (Character.isDigit(c)) {
                st.push(c+""); // Push numeric values
            } else {
                double val2 = Double.parseDouble(st.pop());
                double val1 = Double.parseDouble(st.pop());

                switch (c) {
                    case '+':
                        ans = val1 + val2;
                        break;
                    case '-':
                        ans = val1 - val2;
                        break;
                    case '*':
                        ans = val1 * val2;
                        break;
                    case '/':
                        ans = val1 / val2;
                        break;
                    case '^':
                        ans = Math.pow(val1, val2);
                        break;
                }
                st.push(ans + "");
            }
        }
        System.out.println("Result: " + st.pop());
    }
}

