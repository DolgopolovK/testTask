// Импортируем классы ErrorHandler и Searcher из соответствующих пакетов
import errorHandler.ErrorHandler;
import searcher.Searcher;
import java.util.Scanner;
import java.io.IOException;

// Создаем класс App
public class App {

    // Создаем метод checkArguments с возможным исключением типа ErrorHandler
    private static void checkArguments(String[] args) throws ErrorHandler {
        // Проверяем, что количество аргументов не равно 0
        if (args.length == 0) {
            throw new ErrorHandler("Параметр не задан");
            // Проверяем, что количество аргументов равно 1 и что значение аргумента входит в заданный диапазон
        } else if (args.length == 1) {
            if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 14)
                throw new ErrorHandler("Некорректный номер колонки");
            // Если количество аргументов не равно 0 или 1, то генерируем исключение типа ErrorHandler
        } else {
            throw new ErrorHandler("Некорректное число параметров");
        }
    }

    // Создаем метод main
    public static void main(String[] args) {
        // Создаем объект класса Scanner
        Scanner in = new Scanner(System.in);
        try {
            // Проверяем аргументы с помощью метода checkArguments
            checkArguments(args);
            // Запускаем цикл, который будет принимать пользовательский ввод
            while (true) {
                // Выводим сообщение с запросом ввода строки
                System.out.print("Введите строку: ");
                // Считываем пользовательский ввод
                String userInput = in.nextLine();
                // Если пользователь ввел "!quit", то выходим из цикла
                if (userInput.equals("!quit"))
                    break;
                // Иначе вызываем метод findMatchingLines класса Searcher для поиска совпадений в строке и выводим результат на экран
                Searcher.findMatchingLines(userInput, Integer.parseInt(args[0]));
            }
            // Обрабатываем возможные исключения типов IOException или ErrorHandler
        } catch (IOException | ErrorHandler e) {
            e.printStackTrace();
            // В блоке finally закрываем объект Scanner
        } finally {
            in.close();
        }
    }
}