package unit2;

import java.util.HashMap; 
import java.util.InputMismatchException; 
import java.util.Map; 
import java.util.Scanner; 
 
/** 
 * The LibrarySystem class provides a simple library management system. 
 * It allows adding books, borrowing books, returning books, and exiting the 
 * system. 
 */ 
public class LibrarySystem {  
    /** 
     * A map representing the library's collection of books. 
     * The key is the book's title, and the value is the Book object. 
     */ 
    private static Map<String, Book> library = new HashMap<>(); 
 
    /** 
     * The main method is the entry point of the program. 
     * It displays the menu, reads the user's choice, and performs the selected 
     * operation. 
     * 
     * @param args Command line arguments (not used). 
     */
    public static void main(String[] args) { 
        final Scanner scanner = new Scanner(System.in); 
        boolean running = true;
        while (running) { 
            displayMenu(); 
            final int choice = scanner.nextInt(); 
            // Consume newline 
            scanner.nextLine();
            try { 
                LibraryOption option = LibraryOption.fromValue(choice); 
                switch (option) { 
                    case ADD_BOOKS: 
                        addBooks(scanner); 
                        break; 
                    case BORROW_BOOKS: 
                        borrowBooks(scanner); 
                        break; 
                    case RETURN_BOOKS: 
                        returnBooks(scanner); 
                        break; 
                    case EXIT: 
                        System.out.println("Exiting the system. Goodbye!"); 
                        scanner.close();
                        running = false; 
                        return; 
                    default:
                        System.out.println("Invalid option. Please try again."); 
                } 
            } catch (IllegalArgumentException e) { 
                System.out.println("Invalid option. Please try again."); 
            }
        } 
    } 
 
    /** 
     * Adds books to the library. 
     * 
     * @param scanner the Scanner object to read user input 
     */ 
    private static void addBooks(Scanner scanner) { 
        addBookToLibrary(getBookDetails(scanner)); 
    } 
 
    /** 
     * Gets the details of a book from the user. 
     * 
     * @param scanner the Scanner object to read user input 
     * @return a Book object with the entered details 
     */ 
    private static Book getBookDetails(Scanner scanner) { 
        System.out.print("Enter book title: "); 
        final String title = scanner.nextLine(); 
        System.out.print("Enter book author: "); 
        final String author = scanner.nextLine(); 
        int quantity = -1; 
        while (quantity < 0) { 
            System.out.print("Enter quantity: "); 
            try { 
                quantity = scanner.nextInt(); 
                if (quantity < 0) { 
                    System.out.println("Quantity cannot be negative. Please enter a valid number."); 
                } 
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input. Please enter a number."); 
                // Clear the invalid input 
                scanner.nextLine(); 
            } 
        } 
        // Consume newline 
        scanner.nextLine(); 
 
        return new Book(title, author, quantity); 
    } 
 
    /** 
     * Adds a book to the library. 
     * 
     * @param book the Book object to add to the library 
     */ 
    private static void addBookToLibrary(Book book) { 
        final String key = generateKey(book.getTitle()); 
        if (library.containsKey(key)) { 
            final Book existingBook = library.get(key); 
            existingBook.setQuantity(existingBook.getQuantity() - book.getQuantity()); 
            System.out.println("The quantity of the existing book has been successfully updated."); 
        } else { 
            library.put(key, book); 
            System.out.println("The book has been successfully added to the library."); 
        } 
    } 
 
    /** 
     * Borrows books from the library. 
     * 
     * @param scanner the Scanner object to read user input 
     */ 
    private static void borrowBooks(Scanner scanner) { 
        System.out.print("Enter book title: "); 
        final String title = scanner.nextLine(); 
        final int quantity = getValidQuantity(scanner, "Enter quantity to borrow: "); 
        final String key = generateKey(title); 
        if (library.containsKey(key)) { 
            Book book = library.get(key); 
            if (book.getQuantity() >= quantity) { 
                book.setQuantity(book.getQuantity() - quantity); 
                System.out.println("You have successfully borrowed " + quantity + " copies of " + title + "."); 
            } else { 
                System.out.println("There are not enough copies available to borrow."); 
            } 
        } else { 
            System.out.println("The book could not be found in the library."); 
        } 
    } 
 
    /** 
     * Returns books to the library. 
     * 
     * @param scanner the Scanner object to read user input 
     */ 
    private static void returnBooks(Scanner scanner) { 
        System.out.print("Enter book title: "); 
        final String title = scanner.nextLine(); 
        final int quantity = getValidQuantity(scanner, "Enter quantity to return: "); 
        final String key = generateKey(title); 
        if (library.containsKey(key)) { 
            final Book book = library.get(key); 
            book.setQuantity(book.getQuantity() + quantity); 
            System.out.println("You have successfully returned " + quantity + " copies of " + title + "."); 
        } else { 
            System.out.println("The book could not be found in the library."); 
        } 
    } 
 
    /** 
     * Prompts the user to enter a valid quantity using the provided Scanner and 
     * prompt message. 
     * The method ensures that the entered quantity is a non-negative integer. 
     * 
     * @param scanner the Scanner object to read user input 
     * @param prompt  the message to prompt the user 
     * @return a valid non-negative integer quantity 
     */ 
    private static int getValidQuantity(Scanner scanner, String prompt) { 
        int quantity = -1; 
        while (quantity < 0) { 
            System.out.print(prompt); 
            try { 
                quantity = scanner.nextInt(); 
                if (quantity < 0) { 
                    System.out.println("Quantity cannot be negative. Please enter a valid number."); 
                } 
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input. Please enter a number."); 
                scanner.nextLine(); // Clear the invalid input 
            } 
        } 
        scanner.nextLine(); // Consume newline 
 
        return quantity; 
    } 
 
    /** 
     * Displays the library system menu. 
     */ 
    private static void displayMenu() { 
        System.out.println("Library System Menu:"); 
        System.out.println("1. Add Books"); 
        System.out.println("2. Borrow Books"); 
        System.out.println("3. Return Books"); 
        System.out.println("4. Exit"); 
        System.out.print("Choose an option: "); 
    } 
 
    /** 
     * Generates a unique key for a book based on its title and author. 
     * 
     * @param title the title of the book 
     * @return a unique key for the book 
     */ 
    private static String generateKey(String title) { 
        return title; 
    } 
} 