package Laba5;

import java.util.*;
import java.util.stream.Collectors;

// Класс Точка
class Point {
    private int x;
    private int y;

    // Конструктор
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public int getX() { return x; }
    public int getY() { return y; }

    // toString()
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // equals() для сравнения точек
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

// Класс Линия
class Line {
    private Point start;
    private Point end;

    // Конструктор
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Геттеры
    public Point getStart() { return start; }
    public Point getEnd() { return end; }

    // toString()
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}

// Класс Ломаная
class Polyline {
    private List<Point> points;

    // Конструктор
    public Polyline(List<Point> points) {
        this.points = points;
    }

    // Геттер
    public List<Point> getPoints() { return points; }

    // toString()
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}

// Класс для задания 7.1
public class Class_7_1 {
    // Метод для обработки точек через Stream API
    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                .distinct() // Убираем точки с одинаковыми координатами
                .sorted(Comparator.comparingInt(Point::getX)) // Сортируем по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Делаем Y положительным
                .collect(Collectors.toList());

        return new Polyline(processedPoints);
    }

    // toString()
    @Override
    public String toString() {
        return "Класс для обработки точек через Stream API";
    }
}
