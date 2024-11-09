import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyDictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // узнаем имя файла
        System.out.print("Введите имя входного файла: ");
        String inputFileName = scanner.nextLine();
        
        // имя выходного файла
        System.out.print("Введите имя выходного файла: ");
        String outputFileName = scanner.nextLine();
        
        // создаем экземпляр FileHandler для работы с файлами
        FileHandler fileHandler = new FileHandler();
        
        // читаем файлик и считаем частоту символов
        Map<Character, Integer> frequencyMap = fileHandler.readFileAndCountFrequency(inputFileName);
        
        if (frequencyMap != null) {
            // записываем результаты в выходной файл
            fileHandler.writeFrequencyToFile(frequencyMap, outputFileName);
        }
        
        scanner.close();
    }
}
