import java.util.Scanner;
import java.util.Stack;

public class DailyTaskManager {
    // Initialise variables
    static String[] arrayTasks = {"File a report to the Administrator",
    "Polish HEV Suit",
    "Write an Email to Dr. Vance",
    "Tidy up office desk",
    "Attend a meeting",
    "Cook a Casserole",
    "Spend time with the wife and kids"};

    // Initiate Stack for undo feature
    Stack<Integer> completedTasks = new Stack<>();
    
    // Initialise scanner object
    static Scanner scanner = new Scanner(System.in);
    static int selectionInt;
    static String selectionString;

    // Clearscreen function
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // Function to display all tasks within an array
    public static void displayTasks(){
        System.out.println("");
        System.out.println("Here are your current tasks: ");
        for (int i = 0; i < arrayTasks.length; i++) {
            System.out.println((i + 1) + ". " + arrayTasks[i]);
            }
        // System.out.println("You now have " + arrayTasks.length + " tasks.");
        // System.out.println("");
    }

    // Function to manipulate and update task
    public static void updateTaskValue(){
        while (true) {
            displayTasks();
            System.out.println("");
            System.out.println("Select task that you would like to update");
    
            try {
                System.out.print("Type in selection or '0' if you'd like to go back> ");
                selectionInt = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
    
                if (selectionInt == 0) {
                    break;
                    
                } else if (selectionInt > 0 && selectionInt <= arrayTasks.length) {
                    selectionInt--; // Adjust index for zero-based array
                    System.out.println("Selected task: " + arrayTasks[selectionInt]);
                    
                    System.out.print("Type in new task for the selected task> ");
                    selectionString = scanner.nextLine(); // Read string input correctly
    
                    arrayTasks[selectionInt] = selectionString; // Update task in array
                    System.out.println("Task updated!");
                    System.out.println("");
                    break;

                } else {
                    System.out.println("Invalid selection! Please enter a valid task number.");
                }
    
            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    //Function to mark a task completed
    public static void markTaskComplete(){
        while (true) {
            displayTasks();
            System.out.println("");
            System.out.println("Select task that you have completed");
    
            try {
                System.out.print("Type in selection or '0' if you'd like to go back> ");
                selectionInt = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
    
                if (selectionInt == 0) {
                    break;
                    
                } else if (selectionInt > 0 && selectionInt <= arrayTasks.length) {
                    selectionInt--; // Adjust index for zero-based array
                    System.out.println("Selected task: " + arrayTasks[selectionInt]);
                    
                    System.out.print("Type in new task for the selected task> ");
                    selectionString = scanner.nextLine(); // Read string input correctly
    
                    arrayTasks[selectionInt] = selectionString; // Update task in array
                    System.out.println("Task completed!");
                    System.out.println("");
                    break;

                } else {
                    System.out.println("Invalid selection! Please enter a valid task number.");
                }
    
            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    // Array version of task manager menu
    public static void arrayVerMenu(){
        while (true){
            System.out.println("=============================");
            System.out.println("Hoow can I help you today, User?");
            System.out.println("1. View all tasks");
            System.out.println("2. Update task");
            System.out.println("3. Quit");
            System.out.println("=============================");

            try {
                System.out.print("Type in selection> ");
                selectionInt = scanner.nextInt();

                if (selectionInt == 1) {
                    // Display all tasks in the array via looping
                    displayTasks();
                    System.out.println("");
                    
                } else if (selectionInt == 2) {
                    // Block of Linked List code
                    updateTaskValue();

                } else if (selectionInt == 3) {
                    // Block of Linked List code
                    System.out.println("See you next time!");
                    break;
                } else {
                    System.out.println("Invalid Input! Please check your input again.");
                    System.out.println("");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                scanner.nextLine();
            }
        }
        
    }    

    public static void selectVer(){
        while (true){
            System.out.println("=============================");
            System.out.println("Please select your selection");
            System.out.println("1. Array");
            System.out.println("2. Linked List");
            System.out.println("=============================");

            try {
                System.out.print("Type in selection> ");
                selectionInt = scanner.nextInt();

                if (selectionInt == 1) {
                    // Block of array code
                    clearScreen();
                    System.out.println("You selected Array.");
                    arrayVerMenu();
                } else if (selectionInt == 2) {
                    // Block of Linked List code
                    System.out.println("You selected Linked List.");
                } else {
                    System.out.println("Invalid Input! Please check your input again.");
                    System.out.println("");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                clearScreen();
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello and welcome to the program, User!");
        arrayVerMenu();
    }
}

/* Code references
 w3Schools, Java Tutorial, http://www.w3schools.com/java/
 How to clear console using Java, https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
 Java Program to print elements of an array, https://www.geeksforgeeks.org/java-program-to-print-the-elements-of-an-array/
 */