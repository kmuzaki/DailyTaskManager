import java.util.Scanner;
import java.util.LinkedList;

public class DailyTaskManager {

    String[] tasks = {"File a report to the Administrator",
    "Polish HEV Suit",
    "Write an Email to Dr. Vance",
    "Tidy up office desk",
    "Attend a meeting",
    "Cook a Casserole",
    "Spend time with the wife and kids"};

    

    public static void selectVer(){
        // Initialise scanner for user input
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true){
            System.out.println("=============================");
            System.out.println("Please select your selection");
            System.out.println("1. Array");
            System.out.println("2. Linked List");
            System.out.println("=============================");

            System.out.print("Type in selection> ");
            input = scanner.next();

            if (input.equals("1")){
                //Block of array code

            } else if (input.equals("2")){
                //Block of Linked List code
            
            } else {
                System.out.println("Invalid Input! Please check your input again.");
                System.out.println("");
            }

        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello and welcome to the program, User!");
        selectVer();
    }
}