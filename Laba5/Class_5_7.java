package Laba5;

import java.io.*;
import java.util.*;

public class Class_5_7 {
    // Метод для подсчета уникальных русских букв в тексте
    public static int countUniqueRussianLetters(String filename) throws IOException {
        Set<Character> uniqueLetters = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toLowerCase().toCharArray()) {
                    if (isRussianLetter(c)) {
                        uniqueLetters.add(c);
                    }
                }
            }
        }

        return uniqueLetters.size();
    }

    // Проверка, является ли символ русской буквой
    private static boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }

    // toString()
    @Override
    public String toString() {
        return "Класс для подсчета уникальных русских букв в тексте";
    }
}
