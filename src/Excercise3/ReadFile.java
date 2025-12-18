package Excercise3;

import java.io.*;
import java.util.*;


public class ReadFile {
    static void main() {

        HashMap<String, String> countries = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Excercise3/countries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String country = parts[0];
                    String capital = parts[1];
                    for (int i = 2; i < parts.length; i++) {
                        capital += " " + parts[i];
                    }
                    countries.put(country.trim(), capital.trim());

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //game

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        List<String> countryList = new ArrayList<>(countries.keySet());
        Random random = new Random();
        int score = 0;
        int questions = 0;

        while (questions < 10) {
            String country = countryList.get(random.nextInt(countryList.size()));
            System.out.print("What is the capital of " + country + "? ");
            String userAnswer = scanner.nextLine();
            String correctAnswer = countries.get(country);

            if (userAnswer.equalsIgnoreCase(countries.get(country).replace("_", " "))) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The capital is: " + countries.get(country).replace("_", " "));
            }
            questions++;
        }

        if (questions == 10) {
            System.out.println("Game Over! " + userName + ", your score is: " + score + "/10");
        }
        if (score == 10) {
            System.out.println("Perfect Score! " + userName);
        }
            scanner.close();

            try (FileWriter writer = new FileWriter("src/Excercise3/classificacio.txt", true)) {
                writer.write(userName + ": " + score + "/10\n");
            } catch (IOException e) {
                System.out.println("Error saving score.");
            }
        }
    }

