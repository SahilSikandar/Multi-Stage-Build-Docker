import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        
        // Prompt user for the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        
        // Prompt user for the operation
        System.out.print("Choose an operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        double result = 0;
        
        // Perform the operation based on user input
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator! Please use +, -, *, or /.");
                return;
        }
        
        // Display the result
        System.out.println("The result is: " + result);
        
        // Close the scanner
        scanner.close();
    }
}
