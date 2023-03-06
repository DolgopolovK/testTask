// определение пакета, в котором находится класс
package errorHandler;

// Объявление конструктора класса ErrorHandler, принимающего строку сообщения об ошибке
public class ErrorHandler extends Exception {
    // Вызов конструктора суперкласса Exception с передачей ему сообщения об ошибке
    public ErrorHandler(String message) {
        super(message);
    }
}