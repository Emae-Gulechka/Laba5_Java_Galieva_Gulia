package Laba5;

import java.util.*;
import java.io.*;

// Класс для представления ученика
class Student {
    private String lastName;
    private String firstName;
    private int[] scores;
    private int totalScore;

    // Конструктор
    public Student(String lastName, String firstName, int[] scores) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.scores = scores;
        this.totalScore = Arrays.stream(scores).sum();
    }

    // Геттеры
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int[] getScores() { return scores; }
    public int getTotalScore() { return totalScore; }

    // toString()
    @Override
    public String toString() {
        return lastName + " " + firstName + " " + Arrays.toString(scores) + " (Сумма: " + totalScore + ")";
    }
}

public class Class_4_3 {
    private List<Student> students;

    // Конструктор из списка студентов
    public Class_4_3(List<Student> students) {
        this.students = students;
    }

    // Конструктор для чтения из файла
    public Class_4_3(String filename) throws IOException {
        this.students = readStudentsFromFile(filename);
    }

    // Метод для чтения студентов из файла
    public static List<Student> readStudentsFromFile(String filename) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    String[] parts = line.split("\\s+");

                    if (parts.length < 6) {
                        System.out.println("Строка " + lineNumber + ": пропущена (недостаточно данных)");
                        continue;
                    }

                    String lastName = parts[0];
                    String firstName = parts[1];

                    int[] scores = new int[4];
                    for (int i = 0; i < 4; i++) {
                        scores[i] = Integer.parseInt(parts[i + 2]);
                        if (scores[i] < 0 || scores[i] > 10) {
                            System.out.println("Строка " + lineNumber + ": баллы должны быть 0-10");
                            throw new IllegalArgumentException();
                        }
                    }

                    students.add(new Student(lastName, firstName, scores));

                } catch (NumberFormatException e) {
                    System.out.println("Строка " + lineNumber + ": пропущена (некорректные числа)");
                } catch (IllegalArgumentException e) {
                    // Уже обработано выше
                }
            }
        }

        return students;
    }

    // Метод для получения топ-3 с учетом одинаковых баллов
    public List<Student> getTopThreeWithTies() {
        if (students.isEmpty()) {
            return new ArrayList<>();
        }

        List<Student> sorted = new ArrayList<>(students);
        sorted.sort((s1, s2) -> Integer.compare(s2.getTotalScore(), s1.getTotalScore()));

        int thirdPlaceScore = sorted.size() >= 3 ? sorted.get(2).getTotalScore() :
                sorted.size() >= 2 ? sorted.get(1).getTotalScore() :
                        sorted.get(0).getTotalScore();

        List<Student> result = new ArrayList<>();
        for (Student student : sorted) {
            if (student.getTotalScore() >= thirdPlaceScore) {
                result.add(student);
            }
        }

        return result;
    }

    // Метод для получения всех студентов
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }


    // toString()
    @Override
    public String toString() {
        return "Класс для работы с результатами школьного многоборья";
    }
}