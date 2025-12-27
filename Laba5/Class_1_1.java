package Laba5;

import java.util.Objects;

// Интерфейс для дроби
interface FractionInterface {
    double getDoubleValue();
    void setNumerator(int numerator);
    void setDenominator(int denominator);
}

public class Class_1_1 implements FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedValue; // Для кэширования вещественного значения

    // Конструктор
    public Class_1_1(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    // Приведение дроби к нормальному виду
    private void normalize() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        // Сокращение дроби
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        cachedValue = null; // Сбрасываем кэш при изменении дроби
    }

    // Наибольший общий делитель
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Метод интерфейса: получение вещественного значения (с кэшированием)
    @Override
    public double getDoubleValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    // Метод интерфейса: установка числителя
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        normalize();
    }

    // Метод интерфейса: установка знаменателя
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        normalize();
    }

    // Геттеры
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    // toString() для строкового представления
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // equals() для сравнения дробей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class_1_1 fraction = (Class_1_1) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
