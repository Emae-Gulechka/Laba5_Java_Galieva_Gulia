package Laba5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Класс для представления человека
class Person {
    private String name;
    private Integer number;

    // Конструктор
    public Person(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    // Геттеры
    public String getName() { return name; }
    public Integer getNumber() { return number; }

    // toString()
    @Override
    public String toString() {
        return name + (number != null ? ":" + number : "");
    }
}

// Класс для задания 7.2
public class Class_7_2 {
    // Метод для обработки файла через Stream API
    public static Map<Integer, List<String>> processFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines()
                    .map(line -> {
                        String[] parts = line.split(":");
                        String name = parts[0];
                        Integer number = parts.length > 1 && !parts[1].isEmpty() ?
                                Integer.parseInt(parts[1]) : null;
                        return new Person(name, number);
                    })
                    .filter(p -> p.getNumber() != null) // Убираем людей без номеров
                    .collect(Collectors.groupingBy(
                            Person::getNumber,
                            Collectors.mapping(
                                    p -> p.getName().substring(0, 1).toUpperCase() +
                                            p.getName().substring(1).toLowerCase(),
                                    Collectors.toList()
                            )
                    ));
        }
    }

    // toString()
    @Override
    public String toString() {
        return "Класс для обработки файла с именами и номерами через Stream API";
    }
}
