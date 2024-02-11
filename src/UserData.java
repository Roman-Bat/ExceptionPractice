/**
 * Класс, представляющий данные пользователя.
 */
public class UserData {
    private String surname;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private String gender;

    /**
     * Конструктор для создания объекта UserData с заданными данными пользователя.
     *
     * @param surname    фамилия пользователя
     * @param firstName  имя пользователя
     * @param middleName отчество пользователя
     * @param birthDate  дата рождения пользователя в формате dd.mm.yyyy
     * @param phoneNumber номер телефона пользователя
     * @param gender     пол пользователя (f - женский, m - мужской)
     */
    public UserData(String surname, String firstName, String middleName, String birthDate, long phoneNumber, String gender) {
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    /**
     * Получить фамилию пользователя.
     * @return фамилия пользователя
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Представить данные пользователя в виде строки.
     *
     * @return строковое представление данных пользователя
     */
    @Override
    public String toString() {
        return surname + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
