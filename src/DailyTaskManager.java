import java.util.Scanner;
import java.util.LinkedList;

public class DailyTaskManager {
    // Initialise variables
    static String[] arrayTasks = {"File a report to the Administrator",
    "Polish HEV Suit",
    "Write an Email to Dr. Vance",
    "Tidy up office desk",
    "Attend a meeting",
    "Cook a Casserole",
    "Spend time with the wife and kids"};
    
    // Initialise scanner object
    static Scanner scanner = new Scanner(System.in);
    static int selection;

    // Clearscreen function
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
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
                selection = scanner.nextInt();

                if (selection == 1) {
                    // Display all tasks in the array via looping
                    System.out.println("");
                    System.out.println("Here are your current tasks: ");
                    for (int i = 0; i < arrayTasks.length; i++) {
                        System.out.println((i + 1) + ". " + arrayTasks[i]);
                    }
                    System.out.println("");

                } else if (selection == 2) {
                    // Block of Linked List code
                    System.out.println("You selected Linked List.");
                } else if (selection == 3) {
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
                selection = scanner.nextInt();

                if (selection == 1) {
                    // Block of array code
                    clearScreen();
                    System.out.println("You selected Array.");
                    arrayVerMenu();
                } else if (selection == 2) {
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
 */