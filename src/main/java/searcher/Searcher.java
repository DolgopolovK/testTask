// Указываем, что класс Searcher находится в пакете searcher
package searcher;

// Импортируем классы BufferedReader, FileReader, IOException, Map, TreeMap из пакетов
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

// Создаем класс Searcher
public class Searcher {


    // Создаем статическую переменную - объект класса TreeMap
    private static Map<String, String> сorrespondingLines = new TreeMap<>();

    // Создаем метод printCorrespondingLines, который выводит на экран соответствующие строки
    public static void printCorrespondingLines() {
        // Итерируемся по элементам TreeMap
        for (Map.Entry<String, String> entry : сorrespondingLines.entrySet()) {
            // Выводим ключ и значение элемента
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    // Создаем метод findMatchingLines, который находит строки, соответствующие пользовательскому вводу
    public static void findMatchingLines(String userInput, int column) throws IOException {
        // Получаем текущее время
        long start = System.currentTimeMillis();

        // Инициализируем переменную lineCounter, которая будет считать количество найденных строк
        int lineCounter = 0;
        String line;
        // Создаем объекты BufferedReader и FileReader для чтения данных из файла airports.csv
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/airports.csv"))) {
            // Считываем каждую строку из файла
            while ((line = br.readLine()) != null) {
                // Разбиваем строку на части с помощью метода split, указывая разделитель ","
                String[] tokens = line.split(",");
                // Если колонка является строковой, то удаляем первую кавычку
                if ((column >= 2 && column <= 6) || (column >= 11 && column <= 14)) {
                    tokens[column - 1] = tokens[column - 1].substring(1);
                }
                // Если значение в колонке начинается с пользовательского ввода, то добавляем строку в TreeMap
                if (tokens[column - 1].toLowerCase().startsWith(userInput.toLowerCase())) {
                    сorrespondingLines.put(tokens[column - 1], "[" + line + "]");
                    lineCounter++;
                }
            }
        }

        // Получаем текущее время
        long finish = System.currentTimeMillis();
        // Вычисляем время, затраченное на поиск
        long elapsed = finish - start;

        // Выводим на экран найденные строки
        printCorrespondingLines();
        // Выводим количество найденных строк и время, затраченное на поиск
        System.out.println("Количество найденных строк: " + lineCounter);
        System.out.println("Время, затраченное на поиск: " + elapsed + " мс");
    }
}
