import java.util.Scanner;

public class SortingApplication {
    private final Scanner scanner;
    private final Sorter sorter;
    
    public SortingApplication() {
        scanner = new Scanner(System.in);
        sorter = new Sorter();
    }
    
    public static void main(String[] args) {
        SortingApplication app = new SortingApplication();
        app.run();
    }
    
    public void run() {
        while (true) {
            showMainMenu();
            int choice = getIntInput("Выберите опцию: ");
            
            switch (choice) {
                case 1:
                    bubbleSortMenu();
                    break;
                case 2:
                    selectionSortMenu();
                    break;
                case 3:
                    insertionSortMenu();
                    break;
                case 4:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    
    private void showMainMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Сортировка пузырьком");
        System.out.println("2. Сортировка выбором");
        System.out.println("3. Сортировка вставкой");
        System.out.println("4. Выход");
    }
    
    private void bubbleSortMenu() {
        while (true) {
            System.out.println("\n=== МЕНЮ СОРТИРОВКИ ПУЗЫРЬКОМ ===");
            System.out.println("1. Вставка элементов (ручной ввод)");
            System.out.println("2. Рандомная вставка элементов с выбором количества");
            System.out.println("3. Рандомная вставка 100 элементов");
            System.out.println("4. Рандомная вставка 1000 элементов");
            System.out.println("5. Вывод массива");
            System.out.println("6. Проверка сортировки массива");
            System.out.println("7. Выполнение сортировки с выводом отсортированного массива и затраченного времени");
            System.out.println("8. Удалить массив и вернуться к выбору сортировки");
            System.out.println("9. Завершить программу");
            
            int choice = getIntInput("Выберите опцию: ");
            
            switch (choice) {
                case 1:
                    sorter.manualInsert(scanner);
                    break;
                case 2:
                    sorter.randomInsertWithChoice(scanner);
                    break;
                case 3:
                    sorter.randomInsert(100);
                    break;
                case 4:
                    sorter.randomInsert(1000);
                    break;
                case 5:
                    sorter.printArray();
                    break;
                case 6:
                    sorter.checkSorting();
                    break;
                case 7:
                    sorter.performBubbleSort();
                    break;
                case 8:
                    sorter.deleteArray();
                    System.out.println("Массив удален. Память освобождена.");
                    return;
                case 9:
                    System.out.println("Завершение программы...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    
    private void selectionSortMenu() {
        while (true) {
            System.out.println("\n=== МЕНЮ СОРТИРОВКИ ВЫБОРОМ ===");
            System.out.println("1. Вставка элементов (ручной ввод)");
            System.out.println("2. Рандомная вставка элементов с выбором количества");
            System.out.println("3. Рандомная вставка 100 элементов");
            System.out.println("4. Рандомная вставка 1000 элементов");
            System.out.println("5. Вывод массива");
            System.out.println("6. Проверка сортировки массива");
            System.out.println("7. Выполнение сортировки с выводом отсортированного массива и затраченного времени");
            System.out.println("8. Удалить массив и вернуться к выбору сортировки");
            System.out.println("9. Завершить программу");
            
            int choice = getIntInput("Выберите опцию: ");
            
            switch (choice) {
                case 1:
                    sorter.manualInsert(scanner);
                    break;
                case 2:
                    sorter.randomInsertWithChoice(scanner);
                    break;
                case 3:
                    sorter.randomInsert(100);
                    break;
                case 4:
                    sorter.randomInsert(1000);
                    break;
                case 5:
                    sorter.printArray();
                    break;
                case 6:
                    sorter.checkSorting();
                    break;
                case 7:
                    sorter.performSelectionSort();
                    break;
                case 8:
                    sorter.deleteArray();
                    System.out.println("Массив удален. Память освобождена.");
                    return;
                case 9:
                    System.out.println("Завершение программы...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    
    private void insertionSortMenu() {
        while (true) {
            System.out.println("\n=== МЕНЮ СОРТИРОВКИ ВСТАВКОЙ ===");
            System.out.println("1. Вставка элементов (ручной ввод)");
            System.out.println("2. Рандомная вставка элементов с выбором количества");
            System.out.println("3. Рандомная вставка 100 элементов");
            System.out.println("4. Рандомная вставка 1000 элементов");
            System.out.println("5. Вывод массива");
            System.out.println("6. Проверка сортировки массива");
            System.out.println("7. Выполнение сортировки с выводом отсортированного массива и затраченного времени");
            System.out.println("8. Удалить массив и вернуться к выбору сортировки");
            System.out.println("9. Завершить программу");
            
            int choice = getIntInput("Выберите опцию: ");
            
            switch (choice) {
                case 1:
                    sorter.manualInsert(scanner);
                    break;
                case 2:
                    sorter.randomInsertWithChoice(scanner);
                    break;
                case 3:
                    sorter.randomInsert(100);
                    break;
                case 4:
                    sorter.randomInsert(1000);
                    break;
                case 5:
                    sorter.printArray();
                    break;
                case 6:
                    sorter.checkSorting();
                    break;
                case 7:
                    sorter.performInsertionSort();
                    break;
                case 8:
                    sorter.deleteArray();
                    System.out.println("Массив удален. Память освобождена.");
                    return;
                case 9:
                    System.out.println("Завершение программы...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    
    private int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            }
        }
    }
}