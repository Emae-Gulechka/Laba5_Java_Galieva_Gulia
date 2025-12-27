package Laba5;

import java.util.*;

public class Class_6_2 {
    // Метод для построения очереди по списку L (пример: [1,2,3] -> [1,2,3,3,2,1])
    public static <T> Queue<T> buildQueueFromList(List<T> list) {
        Queue<T> queue = new LinkedList<>();

        // Добавляем элементы в прямом порядке
        for (T item : list) {
            queue.add(item);
        }

        // Добавляем элементы в обратном порядке
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }

        return queue;
    }

    // toString()
    @Override
    public String toString() {
        return "Класс для построения очереди из списка";
    }
}
