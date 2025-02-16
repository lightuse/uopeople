package unit1;

import java.util.Scanner;

/** 
 * SimpleQuizGame is a console-based quiz game that asks the user a series of 
 * questions 
 * and calculates the final score based on the user's answers. 
 */ 
public class SimpleQuizGame { 
    /** 
     * The main method is the entry point of the program. 
     * It initializes the questions and answers, prompts the user for input, 
     * and calculates the final score. 
     * 
     * @param args Command line arguments (not used). 
     */ 
    public static void main(String[] args) { 
        // Array of questions 
        final String[] questions = { 
            "1. What is the largest mammal?\nA. Elephant\nB. Blue Whale\nC. Giraffe\nD. Lion", 
            "2. Who wrote 'Hamlet'?\nA. Charles Dickens\nB. William Shakespeare\nC. Mark Twain\nD. Jane Austen", 
            "3. What is the largest planet in our solar system?\nA. Earth\nB. Mars\nC. Jupiter\nD. Saturn", 
            "4. What is the chemical symbol for water?\nA. O2\nB. H2O\nC. CO2\nD. NaCl", 
            "5. Who painted the Mona Lisa?\nA. Vincent van Gogh\nB. Pablo Picasso\nC. Leonardo da Vinci\nD. Claude Monet" 
        }; 
        // Array of correct answers 
        final char[] answers = { 'B', 'B', 'C', 'B', 'C' }; 
        final int totalNumberQuestion = answers.length; 
        final Scanner scanner = new Scanner(System.in); 
        int score = 0; 
        // Loop through each question 
        for (int i = 0; i < totalNumberQuestion; i++) { 
            System.out.println(questions[i]); 
            char userAnswer; 
            while (true) { 
                System.out.print("Enter your answer (A, B, C, or D): "); 
                userAnswer = scanner.next().toUpperCase().charAt(0); 
                if (userAnswer == 'A' || userAnswer == 'B' || userAnswer == 'C' || userAnswer == 'D') { 
                    break; 
                } else { 
                    System.out.println("Invalid input. Please enter A, B, C, or D."); 
                } 
            } 
            // Check if the answer is correct 
            if (userAnswer == answers[i]) { 
                score++; 
            } 
        } 
        // Calculate and display the final score 
        System.out.println("Your final score is: " + score + "/" + totalNumberQuestion); 
        System.out.println("Your percentage is: " + ((double) score / totalNumberQuestion) * 100 + "%"); 
        scanner.close(); 
    } 
} 