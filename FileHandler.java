import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    public Map<Character, Integer> readFileAndCountFrequency(String inputFileName) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        File inputFile = new File(inputFileName);
        
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Файл не существует или другая ошибка");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int character;
            while ((character = reader.read()) != -1) {
                char ch = (char) character;
                // проверка на принадлежность к английскому алфавиту
                if (Character.isLetter(ch)) {
                    frequencyMap.put(Character.toLowerCase(ch), frequencyMap.getOrDefault(Character.toLowerCase(ch), 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
        
        return frequencyMap;
    }

    public void writeFrequencyToFile(Map<Character, Integer> frequencyMap, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Результаты в файле: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
