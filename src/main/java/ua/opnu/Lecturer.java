package ua.opnu;

public class Lecturer extends Person {
    private String department;
    private double salary;

    // Конструктор
    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age);
        this.department = department;
        this.salary = salary;
    }

    // Гетери
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Сетери
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Викладач кафедри " + department + ", " + lastName + " " + firstName +
                ", вік: " + age + ". Зарплата: " + salary;
    }
}
