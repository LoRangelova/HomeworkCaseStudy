//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String filename = name + "-answers.txt";

        try {
            FileWriter writer = new FileWriter(filename);

            for (int i = 1; i <= 5; i++) {
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);
                int correctAnswer = num1 + num2;

                System.out.print("Question " + i + ": What is " + num1 + " + " + num2 + "? ");
                int userAnswer = scanner.nextInt();

                boolean isCorrect = userAnswer == correctAnswer;


                writer.write("Q" + i + ": " + num1 + " + " + num2 + " = " + userAnswer);
                writer.write(" | Correct answer: " + correctAnswer);
                writer.write(" | " + (isCorrect ? "Correct" : "Incorrect") + "\n");
            }

            writer.close();
            System.out.println("Your answers have been saved to " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
