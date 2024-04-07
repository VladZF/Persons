import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate dateOfBirth;
    private boolean isWoman;

    public Person(String lastName, String firstName, String middleName, String dateOfBirth) throws DateTimeParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        if (Period.between(this.dateOfBirth, LocalDate.now()).getDays() < 0)
            throw new DateTimeException("Такая дата еще не наступила");

        if (middleName.endsWith("на")) {
            isWoman = true;
        }
    }

    @Override
    public String toString() {
        int period = Period.between(dateOfBirth, LocalDate.now()).getYears();
        String age = "Возраст: " + period;
        if (5 <= period && period <= 20 || period % 10 >= 5 || period % 10 == 0)
            age += " лет";
        else if (period % 10 == 1)
            age += " год";
        else
            age += " года";
        String initials = "Фамилия и инициалы: " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0);
        String sex = "Пол: " + (isWoman ? "женский" : "мужской");
        return initials + "\n" + age + "\n" + sex;
    }
}
