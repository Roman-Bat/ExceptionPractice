import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс, представляющий приложение для ввода данных пользователя и их записи в файл.
 */
public class UserDataApplication {

    /**
     * Основной метод приложения. Запрашивает данные пользователя, обрабатывает их и записывает в файл.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < 40; i++){
                System.out.print("-");
            }
            System.out.println("\nВведите данные через пробел:" +
                    "           \nФамилия Имя Отчество (без цифр)" +
                    "\nДата рождения в формате - dd.mm.yyyy" +
                    "\nНомер телефона в формате - 89162741675" +
                    "\nПол ж или м");
            System.out.println("Или введите \"Выход\" чтобы завершить запись");
            for (int i = 0; i < 40; i++){
                System.out.print("-");
            }
            System.out.println("\n");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("выход") || input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                UserData userData = parseInput(input);
                writeToFile(userData);
                System.out.println("Данные успешно записаны в файл.");
            } catch (InvalidDataFormatException | IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    /**
     * Метод для разбора введенных данных пользователя и создания объекта UserData.
     * @param input строка данных пользователя
     * @return объект UserData, содержащий введенные данные
     * @throws InvalidDataFormatException если данные не соответствуют ожидаемому формату
     */
    private static UserData parseInput(String input) throws InvalidDataFormatException {
        String[] parts = input.split(" ");

        if (parts.length != 6) {
            throw new InvalidDataFormatException("Неверное количество данных");
        }

        String surname = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];
        String birthDate = parts[3];
        String phoneNumberStr = parts[4];
        String genderStr = parts[5];

        // Проверяем наличие цифр в ФИО
        if (surname.matches(".*\\d.*") || firstName.matches(".*\\d.*") || middleName.matches(".*\\d.*")) {
            throw new InvalidDataFormatException("В ФИО не должно быть цифр");
        }

        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidDataFormatException("Неверный формат даты рождения dd.mm.yyyy - " + birthDate);
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(phoneNumberStr);
            if (phoneNumberStr.length() != 11) {
                throw new InvalidDataFormatException("Неверная длина номера телефона: " + phoneNumberStr);
            }
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Неверный формат номера телефона: " + phoneNumberStr);
        }

        if (!genderStr.equalsIgnoreCase("ж") && !genderStr.equalsIgnoreCase("м")) {
            throw new InvalidDataFormatException("Неверный формат пола М или Ж");
        }

        return new UserData(surname.substring(0, 1).toUpperCase() + surname.substring(1),
                firstName.substring(0, 1).toUpperCase() + firstName.substring(1),
                middleName.substring(0, 1).toUpperCase() + middleName.substring(1),
                birthDate, phoneNumber, genderStr.toUpperCase());
    }

    /**
     * Метод для записи данных пользователя в файл.
     *
     * @param userData объект UserData, содержащий данные пользователя
     * @throws IOException если возникает ошибка ввода-вывода при записи в файл
     */
    private static void writeToFile(UserData userData) throws IOException {
        String filename = "Записная книжка.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(userData.toString());
            writer.newLine();
        }
    }
}
