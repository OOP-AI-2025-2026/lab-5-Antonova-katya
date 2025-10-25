package ua.opnu;

public class Student extends Person {
    private String group;
    private String studentID;

    // Конструктор
    public Student(String lastName, String firstName, int age, String group, String studentID) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentID = studentID;
    }

    // Гетери
    public String getGroup() {
        return group;
    }

    public String getStudentID() {
        return studentID;
    }

    // Сетери
    public void setGroup(String group) {
        this.group = group;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        // Ми використовуваємо поля lastName, firstName, age напряму, тому що вони оголошені як 'protected' у класі Person
        return "Студент групи " + group + ", " + lastName + " " + firstName + ", вік: " + age +
                ". Номер студентського квитка: " + studentID;
    }
}
