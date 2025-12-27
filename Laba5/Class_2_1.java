package Laba5;

// Интерфейс для мяукающих объектов
interface Meowable {
    void meow();
}

// Класс Кот (нельзя изменять по условию)
class Cat implements Meowable {
    private String name;
    private int meowCount;

    // Конструктор
    public Cat(String name) {
        this.name = name;
        this.meowCount = 0;
    }

    // Геттеры
    public String getName() { return name; }
    public int getMeowCount() { return meowCount; }

    // Метод мяуканья
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    // toString()
    @Override
    public String toString() {
        return "кот: " + name;
    }
}


public class Class_2_1 {
    // Метод, который вызывает мяуканье у всех объектов
    public static void makeAllMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }

    // toString()
    @Override
    public String toString() {
        return "Класс для работы с мяукающими объектами";
    }
}
