package unit3; 
 
import java.util.Scanner; 
 
/** 
 * Student Record Management System 
 */ 
public class Main { 
    /** 
     * Scanner object for user input 
     */ 
    private static Scanner scanner = new Scanner(System.in); 
 
    /** 
     * Main method to run the program
     *  
     * @param args command-line arguments (unused) 
     */ 
    public static void main(String[] args) {
        boolean isRunning = true; 
        while (isRunning) { 
            // Display the main menu
            displayMenu();
            // Get user choice
            final int choice = getIntInput("Enter your choice: "); 
            switch (choice) { 
                case 1 -> addStudent(); 
                case 2 -> updateStudent(); 
                case 3 -> viewStudent(); 
                case 4 -> viewAllStudents(); 
                case 5 -> System.out.println("Total students: " + StudentManagement.getTotalStudents()); 
                case 6 -> { 
                    isRunning = false;
                    System.out.println("Exiting the system. Goodbye!"); 
                    System.exit(0); 
                } 
                default -> System.out.println("Invalid choice. Please try again."); 
            } 
        } 
    } 
 
    /** 
     * Display the main menu 
     */ 
    private static void displayMenu() { 
        System.out.println("\n--- Student Record Management System ---"); 
        System.out.println("1. Add a new student"); 
        System.out.println("2. Update student information"); 
        System.out.println("3. View student details"); 
        System.out.println("4. View all students"); 
        System.out.println("5. Get total number of students"); 
        System.out.println("6. Exit"); 
    } 
 
    /** 
     * Add a new student to the system 
     */ 
    private static void addStudent() { 
        final String name = getStringInput("Enter student name: "); 
        final int id = getIntInput("Enter student ID: "); 
        final int age = getIntInput("Enter student age: "); 
        final char grade = getCharInput("Enter student grade: "); 
 
        StudentManagement.addStudent(name, id, age, grade); 
    } 
 
    /** 
     * Update student information 
     */ 
    private static void updateStudent() { 
        final int id = getIntInput("Enter student ID to update: "); 
        final String name = getStringInput("Enter new name: "); 
        final int age = getIntInput("Enter new age: "); 
        final char grade = getCharInput("Enter new grade: "); 
 
        StudentManagement.updateStudent(id, name, age, grade); 
    } 
 
    /** 
     * View student details 
     */ 
    private static void viewStudent() { 
        final int id = getIntInput("Enter student ID to view: "); 
        StudentManagement.viewStudent(id); 
    } 
 
    /** 
     * View all students in the system 
     */ 
    private static void viewAllStudents() { 
        StudentManagement.viewAllStudents(); 
    } 
 
    /** 
     * Get a string input from the user with a prompt 
     * @param prompt 
     * @return user input as a string 
     */ 
    private static String getStringInput(String prompt) { 
        System.out.print(prompt); 
        return scanner.nextLine(); 
    } 
 
    /** 
     * Get an integer input from the user with a prompt 
     * @param prompt 
     * @return user input as an integer 
     */ 
    private static int getIntInput(String prompt) { 
        while (true) { 
            try { 
                System.out.print(prompt); 
                return Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) { 
                System.out.println("Invalid input. Please enter a number."); 
            } 
        } 
    } 
 
    /** 
     * Get a single character input from the user with a prompt 
     * @param prompt 
     * @return user input as a character 
     */ 
    private static char getCharInput(String prompt) { 
        while (true) { 
            System.out.print(prompt); 
            final String input = scanner.nextLine(); 
            if (input.length() == 1) { 
                return input.charAt(0); 
            } 
            System.out.println("Invalid input. Please enter a single character."); 
        } 
    } 
} 