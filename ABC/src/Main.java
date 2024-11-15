import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //чтение всех строк из файла
            List<String> lines = Files.readAllLines(Paths.get("F:\\fl.txt"));

            int maxLength = 0;

            //обработка каждой строки
            for (String line : lines) {
                //замена "AB" и "CB" на "." и удаление "A", "B", "C"
                String modifiedLine = line.replaceAll("AB|CB", ".").replaceAll("[ABC]", " ");

                //разделение строки на массив строк, удаление пустых строк
                String[] array = modifiedLine.trim().split("\s+");

                //поиск максимальной длины строк
                for (String n : array) {
                    if (n.length() > maxLength) {
                        maxLength = n.length();
                    }
                }
            }

            System.out.println(maxLength);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
