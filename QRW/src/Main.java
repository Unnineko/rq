import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("F:\\1.txt"))) {
            String line = bf.readLine();

            int maxLength = 0;
            int currentLength = 0;
            char prevChar = ' ';

            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                boolean isValidChar = "QRW124".indexOf(currentChar) != -1;

                if (!isValidChar) continue;


                boolean adjacent = false;
                if (Character.isLetter(currentChar) && Character.isLetter(prevChar)) adjacent = true;
                if (Character.isDigit(currentChar) && Character.isDigit(prevChar)) adjacent = true;

                if (adjacent) {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                } else {
                    currentLength++;
                }
                prevChar = currentChar;
            }
            maxLength = Math.max(maxLength, currentLength);

            System.out.println(maxLength);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
