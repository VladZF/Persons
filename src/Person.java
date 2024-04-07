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
        Period period = Period.between(dateOfBirth, LocalDate.now());
        String age = "Возраст: " + period.getYears() + (period.getYears() % 10 == 1 ? " год" :
                2 <= period.getYears() % 10 && period.getYears() % 10 <= 4 ? " года" : " лет");
        String initials = "Фамилия и инициалы: " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0);
        String sex = "Пол: " + (isWoman ? "женский" : "мужской");
        return initials + "\n" + age + "\n" + sex;
    }
}
