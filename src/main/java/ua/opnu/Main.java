package ua.opnu;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[4];

        people[0] = new Student("Петренко", "Поліна", 21, "АК-245", "КВ12345678");
        people[1] = new Lecturer("Руденко", "Владислав", 29, "ООП", 20000.0);
        people[2] = new Student("Антонова", "Катерина", 18, "АІ-243", "KB87654321");
        people[3] = new Person("Шеремета", "Марія", 36);

        System.out.println("Список людей у масиві:");
        System.out.println("----------------------------------------");

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
