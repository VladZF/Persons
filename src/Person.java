import java.time.LocalDate;
import java.time.Period;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate dateOfBirth;
    private boolean isWoman;

    public Person(String lastName, String firstName, String middleName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);

        if (middleName.endsWith("на")) {
            isWoman = true;
        }
    }

    @Override
    public String toString() {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        String age = "Возраст: " + period.getYears() + (period.getDays() < 0 ? " лет до рождения" : " лет");
        String initials = "Фамилия и инициалы: " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0);
        String sex = "Пол: " + (isWoman ? "женский" : "мужской");
        return initials + "\n" + age + "\n" + sex;
    }
}
