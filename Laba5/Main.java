package Laba5;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Демонстрация всех заданий
        Class_1_1(scanner);
        System.out.println();
        Class_2_1(scanner);
        System.out.println();
        Class_3_3(scanner);
        System.out.println();
        Class_4_3(scanner);
        System.out.println();
        Class_5_7(scanner);
        System.out.println();
        Class_6_2(scanner);
        System.out.println();
        Class_7_1(scanner);
        System.out.println();
        Class_7_2(scanner);

        scanner.close();
    }

    // Функция для демонстрации Class_1_1 (Задание 1.1 - Дроби)
    public static void Class_1_1(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 1.1: Дроби с кэшированием");
        System.out.println("════════════════════════════════════════════════");

        try {
            // Ввод первой дроби
            System.out.println("\nСоздание первой дроби:");
            System.out.print("Введите числитель: ");
            int num1 = getIntInput(scanner);
            System.out.print("Введите знаменатель (не ноль): ");
            int den1 = getNonZeroIntInput(scanner);

            Class_1_1 fraction1 = new Class_1_1(num1, den1);
            System.out.println("Дробь создана: " + fraction1);
            System.out.println("  Вещественное значение: " + fraction1.getDoubleValue());

            // Ввод второй дроби
            System.out.println("\nСоздание второй дроби:");
            System.out.print("Введите числитель: ");
            int num2 = getIntInput(scanner);
            System.out.print("Введите знаменатель (не ноль): ");
            int den2 = getNonZeroIntInput(scanner);

            Class_1_1 fraction2 = new Class_1_1(num2, den2);
            System.out.println("Дробь создана: " + fraction2);
            System.out.println("  Вещественное значение: " + fraction2.getDoubleValue());

            // Сравнение дробей
            System.out.println("\nСравнение дробей:");
            System.out.println("  Дробь " + fraction1 + " == Дробь " + fraction2 + "? " +
                    fraction1.equals(fraction2));

            // Демонстрация кэширования
            System.out.println("\nДемонстрация кэширования:");
            System.out.println("  Первое получение значения дроби 1: " + fraction1.getDoubleValue());
            System.out.println("  Второе получение значения дроби 1 (из кэша): " + fraction1.getDoubleValue());


            // Демонстрация работы с отрицательными значениями
            System.out.println("\nДемонстрация работы с отрицательными значениями:");
            Class_1_1 fraction3 = new Class_1_1(-3, -4);
            System.out.println("  Дробь -3/-4 после нормализации: " + fraction3);

            Class_1_1 fraction4 = new Class_1_1(3, -4);
            System.out.println("  Дробь 3/-4 после нормализации: " + fraction4);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Функция для демонстрации Class_2_1 (Задание 2.1 - Коты)
    public static void Class_2_1(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 2.1: Мяукающие коты");
        System.out.println("════════════════════════════════════════════════");

        System.out.print("\nВведите количество котов: ");
        int count = getPositiveIntInput(scanner);
        scanner.nextLine(); // очистка буфера

        Cat[] cats = new Cat[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Введите имя кота " + (i + 1) + ": ");
            String name = scanner.nextLine();
            cats[i] = new Cat(name);
        }

        System.out.println("\nСозданные коты:");
        for (Cat cat : cats) {
            System.out.println("  " + cat);
        }

        System.out.println("\nВызываем мяуканье через метод makeAllMeow():");
        Class_2_1.makeAllMeow(cats);

        System.out.println("\nКоличество мяуканий каждого кота:");
        for (Cat cat : cats) {
            System.out.println("  " + cat.getName() + ": " + cat.getMeowCount() + " раз(а)");
        }

        // Демонстрация повторного мяуканья
        System.out.println("\nДемонстрация дополнительного мяуканья:");
        if (cats.length > 0) {
            cats[0].meow();
            System.out.println("  Теперь у " + cats[0].getName() +
                    " общее количество мяуканий: " + cats[0].getMeowCount() + " раз(а)");
        }
    }

    // Функция для демонстрации Class_3_3 (Задание 3.3 - Слияние списков)
    public static void Class_3_3(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 3.3: Слияние упорядоченных списков");
        System.out.println("════════════════════════════════════════════════");

        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();

        // Ввод первого списка
        System.out.print("\nВведите количество элементов в первом списке: ");
        int n1 = getNonNegativeIntInput(scanner);
        if (n1 > 0) {
            System.out.println("Введите элементы первого списка:");
            for (int i = 0; i < n1; i++) {
                System.out.print("  Элемент " + (i + 1) + ": ");
                L1.add(getIntInput(scanner));
            }
        }

        // Ввод второго списка
        System.out.print("\nВведите количество элементов во втором списке: ");
        int n2 = getNonNegativeIntInput(scanner);
        if (n2 > 0) {
            System.out.println("Введите элементы второго списка:");
            for (int i = 0; i < n2; i++) {
                System.out.print("  Элемент " + (i + 1) + ": ");
                L2.add(getIntInput(scanner));
            }
        }

        // Сортируем списки (по условию они уже упорядочены)
        Collections.sort(L1);
        Collections.sort(L2);

        System.out.println("\nИсходные данные:");
        System.out.println("  Первый список L1: " + L1);
        System.out.println("  Второй список L2: " + L2);

        List<Integer> merged = Class_3_3.mergeSortedLists(L1, L2);
        System.out.println("\nРезультат слияния:");
        System.out.println("  Объединенный отсортированный список: " + merged);

        // Пример с предопределенными данными
        System.out.println("\nДополнительный пример:");
        List<Integer> demo1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> demo2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> demoResult = Class_3_3.mergeSortedLists(demo1, demo2);
        System.out.println("  L1 = " + demo1);
        System.out.println("  L2 = " + demo2);
        System.out.println("  Результат = " + demoResult);
    }

    // Функция для демонстрации Class_4_3 (Задание 4.3 - Школьное многоборье)
    public static void Class_4_3(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 4.3: Школьное многоборье (данные из файла Student.txt)");
        System.out.println("════════════════════════════════════════════════════════════");

        // Имя файла с данными
        String filename = "Student.txt";

        System.out.println("\nПроверка файла " + filename + "...");

        // Проверяем существование файла
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Файл не найден. Создаю тестовый файл...");
            createStudentFile(filename);
            System.out.println("Файл " + filename + " создан с тестовыми данными");
        } else if (file.length() == 0) {
            System.out.println("Файл пуст. Перезаписываю тестовыми данными...");
            createStudentFile(filename);
            System.out.println("Файл " + filename + " обновлен тестовыми данными");
        }

        try {
            // Читаем данные из файла
            System.out.println("\nЧтение данных из файла...");
            Class_4_3 competition = new Class_4_3(filename);
            List<Student> students = competition.getAllStudents();

            System.out.println("Успешно прочитано учеников: " + students.size());

            if (students.isEmpty()) {
                System.out.println("\nВ файле нет корректных данных об учениках");
                System.out.println("Проверьте формат файла и запустите программу снова");
                return;
            }

            // Показываем содержимое файла
            System.out.println("\nСодержимое файла " + filename + ":");
            System.out.println("--------------------------------------------------");
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                int lineNum = 1;
                while ((line = reader.readLine()) != null) {
                    System.out.printf("%2d. %s%n", lineNum++, line);
                }
            }
            System.out.println("--------------------------------------------------");

            // Показываем всех учеников с результатами
            System.out.println("\nВсе участники соревнований (отсортированы по сумме баллов):");
            System.out.println("--------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-20s %-10s%n",
                    "№", "Фамилия", "Имя", "Баллы", "Сумма");
            System.out.println("--------------------------------------------------");

            List<Student> sortedAll = new ArrayList<>(students);
            sortedAll.sort((s1, s2) -> Integer.compare(s2.getTotalScore(), s1.getTotalScore()));

            for (int i = 0; i < sortedAll.size(); i++) {
                Student s = sortedAll.get(i);
                System.out.printf("%-4d %-15s %-15s %-20s %-10d%n",
                        i + 1, s.getLastName(), s.getFirstName(),
                        Arrays.toString(s.getScores()), s.getTotalScore());
            }

            // Получаем лучших участников
            System.out.println("ОПРЕДЕЛЕНИЕ ЛУЧШИХ УЧАСТНИКОВ");

            List<Student> topStudents = competition.getTopThreeWithTies();

            System.out.println("\nЛучшие участники (топ-3 с одинаковыми баллами):");
            System.out.println("--------------------------------------------------");

            if (topStudents.isEmpty()) {
                System.out.println("  Нет участников");
            } else {
                for (int i = 0; i < topStudents.size(); i++) {
                    Student s = topStudents.get(i);
                    System.out.printf("  %2d. %-15s %-15s - %d баллов (баллы: %s)%n",
                            i + 1, s.getLastName(), s.getFirstName(),
                            s.getTotalScore(), Arrays.toString(s.getScores()));
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }


    // Функция для демонстрации Class_5_7 (Задание 5.7 - Уникальные буквы)
    public static void Class_5_7(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 5.7: Уникальные русские буквы в тексте");
        System.out.println("════════════════════════════════════════════════");

        // Создаем тестовый файл
        String testFilename = "text_russian.txt";
        createRussianTextFile(testFilename);

        System.out.println("\nСоздан файл: " + testFilename);
        System.out.println("Содержимое файла:");
        System.out.println("--------------------------------------------------");
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("  Не удалось прочитать файл");
        }
        System.out.println("--------------------------------------------------");

        try {
            int uniqueCount = Class_5_7.countUniqueRussianLetters(testFilename);
            System.out.println("\nРезультат:");
            System.out.println("  В тексте найдено " + uniqueCount + " уникальных русских букв");

            // Показываем все найденные буквы
            System.out.println("\nВсе русские буквы в тексте (отсортированные):");
            Set<Character> letters = getRussianLettersFromFile(testFilename);
            List<Character> sortedLetters = new ArrayList<>(letters);
            Collections.sort(sortedLetters);
            System.out.print("  ");
            for (char c : sortedLetters) {
                System.out.print(c + " ");
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Функция для демонстрации Class_6_2 (Задание 6.2 - Построение очереди)
    public static void Class_6_2(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 6.2: Построение очереди из списка");
        System.out.println("════════════════════════════════════════════════");

        System.out.println("Пример: из списка [1, 2, 3] строится очередь [1, 2, 3, 3, 2, 1]");

        List<Integer> list = new ArrayList<>();

        System.out.print("\nВведите количество элементов в списке: ");
        int n = getNonNegativeIntInput(scanner);

        if (n == 0) {
            System.out.println("Используем пример по умолчанию [1, 2, 3]");
            list = Arrays.asList(1, 2, 3);
        } else {
            System.out.println("Введите элементы списка:");
            for (int i = 0; i < n; i++) {
                System.out.print("  Элемент " + (i + 1) + ": ");
                list.add(getIntInput(scanner));
            }
        }

        System.out.println("\nИсходный список: " + list);

        Queue<Integer> queue = Class_6_2.buildQueueFromList(list);

        System.out.print("Результирующая очередь: ");
        printQueue(queue);

    }

    // Функция для демонстрации Class_7_1 (Задание 7.1 - Stream API для точек)
    public static void Class_7_1(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 7.1: Обработка точек через Stream API");
        System.out.println("════════════════════════════════════════════════");

        System.out.println("Задачи Stream:");
        System.out.println("  1. Взять все Point в разных координатах");
        System.out.println("  2. Убрать точки с одинаковыми X,Y");
        System.out.println("  3. Отсортировать по X");
        System.out.println("  4. Отрицательные Y сделать положительными");
        System.out.println("  5. Собрать в ломаную линию");

        List<Point> points = new ArrayList<>();

        System.out.print("\nВведите количество точек: ");
        int n = getNonNegativeIntInput(scanner);

        if (n == 0) {
            System.out.println("Используем пример по умолчанию:");
            points.add(new Point(5, -3));
            points.add(new Point(2, 4));
            points.add(new Point(5, -3)); // Дубликат
            points.add(new Point(2, 4));  // Дубликат
            points.add(new Point(1, -7));
            points.add(new Point(8, 2));
            points.add(new Point(3, -5));
            points.add(new Point(1, -7)); // Дубликат
        } else {
            System.out.println("Введите координаты точек (X Y через пробел):");
            for (int i = 0; i < n; i++) {
                System.out.print("  Точка " + (i + 1) + ": ");
                int x = getIntInput(scanner);
                int y = getIntInput(scanner);
                points.add(new Point(x, y));
            }
        }

        System.out.println("\nИсходные точки:");
        System.out.print("  ");
        points.forEach(p -> System.out.print(p + " "));
        System.out.println();

        System.out.println("\nОбработка через Stream API...");
        Polyline polyline = Class_7_1.processPoints(points);

        System.out.println("\nРезультирующая ломаная линия:");
        System.out.println("  " + polyline);

        // Пошаговая демонстрация
        System.out.println("\nПошаговая обработка:");

        // 1. Удаление дубликатов
        Set<Point> uniquePoints = new HashSet<>(points);
        System.out.println("  1. После удаления дубликатов (" + uniquePoints.size() + " точек):");
        System.out.print("     ");
        uniquePoints.forEach(p -> System.out.print(p + " "));
        System.out.println();

        // 2. Сортировка по X
        List<Point> sortedPoints = new ArrayList<>(uniquePoints);
        sortedPoints.sort(Comparator.comparingInt(Point::getX));
        System.out.println("  2. После сортировки по X:");
        System.out.print("     ");
        sortedPoints.forEach(p -> System.out.print(p + " "));
        System.out.println();

        // 3. Преобразование Y в положительные
        List<Point> positiveYPoints = new ArrayList<>();
        for (Point p : sortedPoints) {
            positiveYPoints.add(new Point(p.getX(), Math.abs(p.getY())));
        }
        System.out.println("  3. После преобразования Y в положительные:");
        System.out.print("     ");
        positiveYPoints.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    // Функция для демонстрации Class_7_2 (Задание 7.2 - Stream API для файла)
    public static void Class_7_2(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 7.2: Обработка файла с именами и номерами");
        System.out.println("════════════════════════════════════════════════");

        System.out.println("Задачи Stream:");
        System.out.println("  1. Чтение всех людей из файла");
        System.out.println("  2. Приведение имен к нижнему регистру с первой буквой в верхнем");
        System.out.println("  3. Убрать людей без номеров");
        System.out.println("  4. Группировать имена по номеру");

        // Создаем тестовый файл
        String testFilename = "people.txt";
        createPeopleDataFile(testFilename);

        System.out.println("\nСоздан файл: " + testFilename);
        System.out.println("Содержимое файла:");
        System.out.println("--------------------------------------------------");
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("  Не удалось прочитать файл");
        }
        System.out.println("--------------------------------------------------");

        try {
            Map<Integer, List<String>> result = Class_7_2.processFile(testFilename);

            System.out.println("\nРезультат группировки имен по номерам:");
            if (result.isEmpty()) {
                System.out.println("  Нет данных");
            } else {
                for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
                    System.out.printf("  Номер %d: %s%n", entry.getKey(), entry.getValue());
                }
            }


        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // ============= Вспомогательные методы =============

    private static void printQueue(Queue<?> queue) {
        System.out.print("[");
        Iterator<?> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static Set<Character> getRussianLettersFromFile(String filename) throws IOException {
        Set<Character> letters = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toLowerCase().toCharArray()) {
                    if ((c >= 'а' && c <= 'я') || c == 'ё') {
                        letters.add(c);
                    }
                }
            }
        }
        return letters;
    }

    private static void createRussianTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Съешь же ещё этих мягких французских булок, да выпей чаю.");
            writer.println("В чащах юга жил бы цитрус? Да, но фальшивый экземпляр!");
            writer.println("Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства.");
        } catch (IOException e) {
            System.out.println("Не удалось создать тестовый файл");
        }
    }

    private static void createPeopleDataFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Вася:5");
            writer.println("Петя:3");
            writer.println("Аня:5");
            writer.println("Маша:");
            writer.println("Коля:3");
            writer.println("Оля:7");
            writer.println("саша:2");
            writer.println("МИША:4");
            writer.println("Даша:");
            writer.println("Павел:2");
        } catch (IOException e) {
            System.out.println("Не удалось создать тестовый файл");
        }
    }

    // Метод для создания файла Student.txt с тестовыми данными
    private static void createStudentFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Добавляем данные в формате из задания
            writer.println("Иванова Мария 5 8 6 3");
            writer.println("Петров Сергей 9 9 5 7");
            writer.println("Сидорова Анна 10 10 10 10");
            writer.println("Козлов Иван 7 8 6 9");
            writer.println("Смирнова Елена 8 7 9 8");
            writer.println("Васильев Алексей 6 5 7 6");

        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    // ============= Методы для ввода с проверками =============

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: введите целое число: ");
            }
        }
    }

    private static int getNonZeroIntInput(Scanner scanner) {
        while (true) {
            int value = getIntInput(scanner);
            if (value != 0) {
                return value;
            }
            System.out.print("Ошибка: число не может быть нулем. Введите снова: ");
        }
    }

    private static int getPositiveIntInput(Scanner scanner) {
        while (true) {
            int value = getIntInput(scanner);
            if (value > 0) {
                return value;
            }
            System.out.print("Ошибка: число должно быть положительным. Введите снова: ");
        }
    }

    private static int getNonNegativeIntInput(Scanner scanner) {
        while (true) {
            int value = getIntInput(scanner);
            if (value >= 0) {
                return value;
            }
            System.out.print("Ошибка: число не может быть отрицательным. Введите снова: ");
        }
    }
}
