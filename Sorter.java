import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorter {
    private int[] array;
    private final Random random;
    
    public Sorter() {
        random = new Random();
        array = new int[0];
    }
    
    public void manualInsert(Scanner scanner) {
        System.out.print("Введите количество элементов: ");
        int count = Integer.parseInt(scanner.nextLine());
        
        if (count <= 0) {
            System.out.println("Количество элементов должно быть положительным числом...");
            return;
        }
        
        array = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Введите элемент " + (i + 1) + ": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Элементы успешно добавлены.");
    }
    
    public void randomInsertWithChoice(Scanner scanner) {
        System.out.print("Введите количество элементов: ");
        int count = Integer.parseInt(scanner.nextLine());
        
        if (count <= 0) {
            System.out.println("Количество элементов должно быть положительным числом.");
            return;
        }
        
        randomInsert(count);
    }
    
    public void randomInsert(int count) {
        array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("Добавлено " + count + " случайных элементов.");
    }
    
    public void printArray() {
        if (array.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }
        System.out.println("Текущий массив: " + Arrays.toString(array));
    }
    
    public void checkSorting() {
        if (array.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }
        
        boolean isSorted = true;
        int errorPosition = -1;
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                errorPosition = i;
                break;
            }
        }
        
        if (isSorted) {
            System.out.println("Массив отсортирован правильно.");
        } else {
            System.out.println("Обнаружена ошибка сортировки!");
            System.out.println("Элемент [" + errorPosition + "] = " + array[errorPosition] + 
                             " больше элемента [" + (errorPosition + 1) + "] = " + array[errorPosition + 1]);
        }
    }
    
    public void performBubbleSort() {
        if (array.length == 0) {
            System.out.println("Массив пуст. Сначала добавьте элементы.");
            return;
        }
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        bubbleSort(arrayToSort);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayToSort));
        System.out.println("Время сортировки: " + duration + " наносекунд (" + 
                          (duration / 1_000_000.0) + " миллисекунд)");
        
        // Обновляем основной массив
        array = arrayToSort;
    }
    
    public void performSelectionSort() {
        if (array.length == 0) {
            System.out.println("Массив пуст. Сначала добавьте элементы.");
            return;
        }
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        selectionSort(arrayToSort);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayToSort));
        System.out.println("Время сортировки: " + duration + " наносекунд (" + 
                          (duration / 1_000_000.0) + " миллисекунд)");
        
        // Обновляем основной массив
        array = arrayToSort;
    }
    
    public void performInsertionSort() {
        if (array.length == 0) {
            System.out.println("Массив пуст. Сначала добавьте элементы.");
            return;
        }
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        insertionSort(arrayToSort);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayToSort));
        System.out.println("Время сортировки: " + duration + " наносекунд (" + 
                          (duration / 1_000_000.0) + " миллисекунд)");
        
        // Обновляем основной массив
        array = arrayToSort;
    }
    
    private void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1]; // swap
                    arr[j + 1] = temp;
                    flag = true;
                } 
            }
                if (!flag){
                    System.out.println("Узбагойся");
                    break;
                }
            }
        }
    
    
    private void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Меняем найденный минимальный элемент с первым элементом
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    private void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Перемещаем элементы arr[0..i-1], которые больше key,
            // на одну позицию вперед от их текущей позиции
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public void deleteArray() {
        array = new int[0];
    }
}