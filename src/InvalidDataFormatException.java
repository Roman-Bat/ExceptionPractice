/**
 * Это исключение выбрасывается, когда входные данные не соответствуют ожидаемому формату.
 */
public class InvalidDataFormatException extends Exception {

    /**
     * Конструирует новое исключение InvalidDataFormatException с указанным детальным сообщением.
     * @param message детальное сообщение (которое будет сохранено для последующего получения с помощью метода getMessage())
     */
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

