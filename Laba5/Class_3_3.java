package Laba5;

import java.util.*;

public class Class_3_3 {
    // Метод для вставки элементов L2 в L1 с сохранением порядка
    public static List<Integer> mergeSortedLists(List<Integer> L1, List<Integer> L2) {
        List<Integer> result = new ArrayList<>(L1);
        result.addAll(L2);
        Collections.sort(result);
        return result;
    }

    // toString()
    @Override
    public String toString() {
        return "Класс для слияния двух отсортированных списков";
    }
}
