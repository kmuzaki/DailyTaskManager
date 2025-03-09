import java.util.Scanner;
import java.util.Stack;
import java.nio.channels.Pipe.SourceChannel;
import java.util.LinkedList;

public class DailyTaskManager {
    // Initialise array of tasks
    static String[] arrayTasks = {"File a report to the Administrator",
    "Polish HEV Suit",
    "Write an Email to Dr. Vance",
    "Tidy up office desk",
    "Attend a meeting",
    "Cook a Casserole",
    "Spend time with the wife and kids"};

    // Initialise Linkedlist for tasks
    static LinkedList<String> llTasks = new LinkedList<String>();

    // Initialise tasks for the LinkedList
    static {
        llTasks.add("File a report");
        llTasks.add("Cook");
        llTasks.add("Attend meeting");
    }

    // Initiate Stack for undo feature
    static Stack<Integer> completedTasks = new Stack<>();
    
    // Initialise scanner objects
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
        System.out.println("You have " + completedTasks.size() + " out of " + arrayTasks.length + " tasks completed.");
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
                    if (completedTasks.search(selectionInt) == -1) {
                        completedTasks.push(selectionInt);
                        System.out.println("Task " + arrayTasks[selectionInt] + " completed!");
                        System.out.println("");
                        break;
                    } else {
                        System.out.println("Task already marked completed");
                        System.out.println("");
                    }
                } else {
                    System.out.println("Invalid selection! Please enter a valid task number.");
                }
    
            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    // Undo Function
    public static void undoTask(){
        if (completedTasks.isEmpty() == true) { // Checks if the stack is empty or not
            System.out.println("You don't have any completed tasks yet");
            System.out.println("");
        } else {
            System.out.println("Undo marking task " + arrayTasks[completedTasks.pop()] + " completed."); // Pops recently completed task if there is an element in the stack
        }
    }

    // Add task to LinkedList function
    public static void addTask(){
        scanner.nextLine(); //Consume leftover newline
        System.out.print("Type in new task to be added> ");
        selectionString = scanner.nextLine(); // Read string input correctly
        llTasks.add(selectionString);
        System.out.println("New task added! ");
        
    }

    // Function to display all tasks in LinkedList
    public static void displayTasksLL(){
        System.out.println("Here are your current tasks: ");
        for (int i = 0; i < llTasks.size(); i++) {
            System.out.println((i + 1) + ". " + llTasks.get(i));
            }
        
    }

    // Function to delete a task within the LinkedList
    public static void deleteTask(){
        while (true) {
            displayTasksLL();
            System.out.println("");
            System.out.println("Select task that you would like to delete");
    
            try {
                System.out.print("Type in selection or '0' if you'd like to go back> ");
                selectionInt = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
    
                if (selectionInt == 0) {
                    break;
                    
                } else if (selectionInt > 0 && selectionInt <= (llTasks.size())) {
                    selectionInt--; // Adjust index for zero-based array
                    System.out.println("Task " + llTasks.get(selectionInt) + " deleted!");

                    llTasks.remove(selectionInt);
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

    /* 
    public static void displayCompletedTasks(){
        if (completedTasks.isEmpty() == true) {
            System.out.println("You don't have any completed tasks yet");
            System.out.println("");
        } else {
            System.out.println("Here are your completed tasks: ");
            for (int i = 0; i < completedTasks.length; i++) {
                System.out.println((i + 1) + ". " + arrayTasks[i]);
            }
        }

    } */

    // Linked List version of task manager menu
    public static void arrayVerMenu(){
        while (true){
            if (completedTasks.isEmpty() == false) {
                System.out.println("Recently completed task: " + arrayTasks[completedTasks.peek()]);
            }    
            System.out.println("=============================");
            System.out.println("How can I help you today, User?");
            System.out.println("1. View all tasks");
            System.out.println("2. Update task");
            System.out.println("3. Mark task complete");
            System.out.println("4. Undo completed task");
            System.out.println("0. Quit");
            System.out.println("=============================");

            try {
                System.out.print("Type in selection> ");
                selectionInt = scanner.nextInt();

                if (selectionInt == 1) {
                    // Display all tasks in the array via looping
                    displayTasks();
                    System.out.println("");
                    
                } else if (selectionInt == 2) {
                    updateTaskValue();
                    System.out.println("");

                } else if (selectionInt == 3) {
                    markTaskComplete();
                    System.out.println("");

                } else if (selectionInt == 4) {
                    undoTask();
                    System.out.println("");

                } else if (selectionInt == 0) {
                    clearScreen();
                    break;

                }else {
                    System.out.println("Invalid Input! Please check your input again.");
                    System.out.println("");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                scanner.nextLine();
            }
        }
        
    }
    
    public static void linkedListVerMenu(){
        while (true){
            if (completedTasks.isEmpty() == false) {
                System.out.println("Recently completed task: " + arrayTasks[completedTasks.peek()]);
            }    
            System.out.println("=============================");
            System.out.println("How can I help you today, User?");
            System.out.println("1. Add new task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            // System.out.println("1. View all tasks");
            // System.out.println("2. Update task");
            // System.out.println("3. Mark task complete");
            // System.out.println("4. Undo completed task");
            System.out.println("0. Quit");
            System.out.println("=============================");

            try {
                System.out.print("Type in selection> ");
                selectionInt = scanner.nextInt();

                if (selectionInt == 1) {
                    // Display all tasks in the array via looping
                    addTask();
                    System.out.println("");
                    
                } else if (selectionInt == 2) {
                    deleteTask();
                    System.out.println("");

                } else if (selectionInt == 3) {
                    displayTasksLL();
                    System.out.println("");

                // } else if (selectionInt == 4) {
                //     undoTask();
                //     System.out.println("");

                } else if (selectionInt == 0) {
                    clearScreen();
                    break;

                }else {
                    System.out.println("Invalid Input! Please check your input again.");
                    System.out.println("");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                scanner.nextLine();
            }
        }
    }

    public static void mainMenu(){
        while (true){
            System.out.println("=============================");
            System.out.println("Please select your selection");
            System.out.println("1. Array");
            System.out.println("2. Linked List");
            System.out.println("3. Exit Application");
            System.out.println("=============================");

            try {
                System.out.print("Type in selection> ");
                selectionInt = scanner.nextInt();

                if (selectionInt == 1) {
                    // Block of array code
                    clearScreen();
                    // System.out.println("You selected Array.");
                    arrayVerMenu();
                } else if (selectionInt == 2) {
                    // Block of Linked List code
                    clearScreen();
                    linkedListVerMenu();
                } else if (selectionInt == 3) {
                    System.out.println("See you next time!");
                    break;
                }else {
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
        mainMenu();
    }
}

/* Code references
 w3Schools, Java Tutorial, http://www.w3schools.com/java/
 How to clear console using Java, https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
 Java Program to print elements of an array, https://www.geeksforgeeks.org/java-program-to-print-the-elements-of-an-array/
 Stack class in Java, https://www.geeksforgeeks.org/stack-class-in-java/
 Stack search method in Java, https://www.geeksforgeeks.org/stack-search-method-in-java/
 Stack size method in Java with example, https://www.geeksforgeeks.org/stack-size-method-in-java-with-example/
 Linked list in Java, https://www.geeksforgeeks.org/linked-list-in-java/
 */