package ua.opnu;

public class TimeSpan {

    // 1. Модифікатори доступу: поля тепер приватні (private)
    private int hours;
    private int minutes;

    //  Перевантажені конструктори

    // Завдання 1.1: Конструктор без аргументів (0 годин, 0 хвилин).
    public TimeSpan() {
        this(0, 0);
    }

    // Завдання 1.2: Конструктор з 1 аргументом (хвилини).
    public TimeSpan(int minutes) {
        if (minutes < 0) {
            minutes = 0;
        }
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    // Завдання 1.3: Конструктор з 2 аргументами (години та хвилини).
    public TimeSpan(int hours, int minutes) {
        if (hours < 0) {
            hours = 0;
        }
        if  (minutes < 0) {
            minutes = 0;
        }
        int totalMinutes = (hours * 60) + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Завдання 1.4: Конструктор копіювання (з 1 аргументом типу TimeSpan).
    public TimeSpan(TimeSpan other) {
        this.hours = other.hours;
        this.minutes = other.minutes;
    }

    // Методи-геттери

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    //Перевантажені методи додавання (add)

    // Завдання 1.5: Метод додавання (години та хвилини).
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return;
        }
        int totalMinutes = this.getTotalMinutes() + (hours * 60) + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Завдання 1.6: Метод додавання (тільки хвилини).
    public void add(int minutes) {
        if (minutes < 0) return;
        int totalMinutes = getTotalMinutes() + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Завдання 1.7: Метод додавання (інший TimeSpan).
    public void add(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Перевантажені методи віднімання

    // Завдання 1.8: Метод віднімання (години та хвилини).
    public void subtract(int hours, int minutes) {
        int totalMinutes = getTotalMinutes() - (hours * 60 + minutes);
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
            return;
        }
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Завдання 1.9: Метод віднімання (тільки хвилини).
    public void subtract(int minutes) {
        int totalMinutes = getTotalMinutes() - minutes;
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
            return;
        }
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Завдання 1.10: Метод віднімання (інший TimeSpan).
    public void subtract(TimeSpan span) {
        subtract(span.getHours(), span.getMinutes());
    }

    public void scale(int factor) {
        if (factor <= 0)
            return;
        int totalMinutes = getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
