import java.time.DateTimeException;
import java.util.Scanner;

public class Main {

    public static boolean isNotValidName(String part, String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("ОШИБКА: " + part + " не может быть пустым");
            return true;
        }

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!Character.isLetter(ch)) {
                System.out.println("ОШИБКА: " + part + " не может содержать символы, отличные от букв");
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastName;
        String firstName;
        String middleName;

        do {
            System.out.print("Введите фамилию: ");
            lastName = scanner.nextLine().trim();
        } while (isNotValidName("фамилия", lastName));

        if (Character.isLowerCase(lastName.charAt(0))) {
            lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
        }

        do {
            System.out.print("Введите имя: ");
            firstName = scanner.nextLine().trim();
        } while (isNotValidName("имя", firstName));

        if (Character.isLowerCase(firstName.charAt(0))) {
            firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);
        }

        do {
            System.out.print("Введите отчество: ");
            middleName = scanner.nextLine().trim();
        } while (isNotValidName("отчество", middleName));

        if (Character.isLowerCase(middleName.charAt(0))) {
            middleName = Character.toUpperCase(middleName.charAt(0)) + middleName.substring(1);
        }

        System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
        String birthDateStr = scanner.next().trim();

        do {
            try {
                Person person = new Person(lastName, firstName, middleName, birthDateStr);
                System.out.println(person);
                break;
            } catch (DateTimeException e) {
                System.out.println("ОШИБКА: " + (e.getMessage().startsWith("Text") ? "Некорректная дата" : e.getMessage()));
                System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                birthDateStr = scanner.next().trim();
            }
        } while (true);

        scanner.close();
    }
}