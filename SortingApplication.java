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
                    shakerSortMenu();
                    break;
                case 5:
                    quickSortMenu();
                    break;
                case 6:
                    mergeSortMenu();
                    break;
                case 7:
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
        System.out.println("4. Шейкерная сортировка");
        System.out.println("5. Быстрая сортировка");
        System.out.println("6. Сортировка слиянием");
        System.out.println("7. Выход");
    }
    
    private void showSortingSubMenu(String sortName) {
        System.out.println("\n=== МЕНЮ " + sortName.toUpperCase() + " ===");
        System.out.println("1. Вставка элементов (ручной ввод)");
        System.out.println("2. Рандомная вставка элементов с выбором количества и диапазона");
        System.out.println("3. Рандомная вставка 100 элементов (диапазон 0-999)");
        System.out.println("4. Рандомная вставка 1000 элементов (диапазон 0-999)");
        System.out.println("5. Вывод массива");
        System.out.println("6. Проверка сортировки массива");
        System.out.println("7. Выполнение сортировки с выводом отсортированного массива и затраченного времени");
        System.out.println("8. Удалить массив и вернуться к выбору сортировки");
        System.out.println("9. Завершить программу");
    }
    
    private void handleSortingMenu(String sortType) {
        while (true) {
            showSortingSubMenu(sortType);
            int choice = getIntInput("Выберите опцию: ");
            
            switch (choice) {
                case 1:
                    sorter.manualInsert(scanner);
                    break;
                case 2:
                    sorter.randomInsertWithChoiceAndRange(scanner);
                    break;
                case 3:
                    sorter.randomInsert(100, 0, 999);
                    break;
                case 4:
                    sorter.randomInsert(1000, 0, 999);
                    break;
                case 5:
                    sorter.printArray();
                    break;
                case 6:
                    sorter.checkSorting();
                    break;
                case 7:
                    switch (sortType) {
                        case "Сортировка пузырьком":
                            sorter.performBubbleSort();
                            break;
                        case "Сортировка выбором":
                            sorter.performSelectionSort();
                            break;
                        case "Сортировка вставкой":
                            sorter.performInsertionSort();
                            break;
                        case "Шейкерная сортировка":
                            sorter.performShakerSort();
                            break;
                        case "Быстрая сортировка":
                            sorter.performQuickSort();
                            break;
                        case "Сортировка слиянием":
                            sorter.performMergeSort();
                            break;
                    }
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
    
    private void bubbleSortMenu() {
        handleSortingMenu("Сортировка пузырьком");
    }
    
    private void selectionSortMenu() {
        handleSortingMenu("Сортировка выбором");
    }
    
    private void insertionSortMenu() {
        handleSortingMenu("Сортировка вставкой");
    }
    
    private void shakerSortMenu() {
        handleSortingMenu("Шейкерная сортировка");
    }
    
    private void quickSortMenu() {
        handleSortingMenu("Быстрая сортировка");
    }
    
    private void mergeSortMenu() {
        handleSortingMenu("Сортировка слиянием");
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