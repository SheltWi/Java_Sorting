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
            System.out.println("Количество элементов должно быть положительным числом.");
            return;
        }
        
        array = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Введите элемент " + (i + 1) + ": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Элементы успешно добавлены.");
    }
    
    public void randomInsertWithChoiceAndRange(Scanner scanner) {
        System.out.print("Введите количество элементов: ");
        int count = Integer.parseInt(scanner.nextLine());
        
        if (count <= 0) {
            System.out.println("Количество элементов должно быть положительным числом.");
            return;
        }
        
        System.out.print("Введите минимальное значение: ");
        int min = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Введите максимальное значение: ");
        int max = Integer.parseInt(scanner.nextLine());
        
        if (min >= max) {
            System.out.println("Минимальное значение должно быть меньше максимального.");
            return;
        }
        
        randomInsert(count, min, max);
    }
    
    public void randomInsert(int count, int min, int max) {
        array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        System.out.println("Добавлено " + count + " случайных элементов в диапазоне [" + min + ", " + max + "]");
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
    
    public void performShakerSort() {
        if (array.length == 0) {
            System.out.println("Массив пуст. Сначала добавьте элементы.");
            return;
        }
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        shakerSort(arrayToSort);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayToSort));
        System.out.println("Время сортировки: " + duration + " наносекунд (" + 
                          (duration / 1_000_000.0) + " миллисекунд)");
        
        // Обновляем основной массив
        array = arrayToSort;
    }
    
    public void performQuickSort() {
        if (array.length == 0) {
            System.out.println("Массив пуст. Сначала добавьте элементы.");
            return;
        }
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayToSort));
        System.out.println("Время сортировки: " + duration + " наносекунд (" + 
                          (duration / 1_000_000.0) + " миллисекунд)");
        
        // Обновляем основной массив
        array = arrayToSort;
    }
    
    public void performMergeSort() {
        if (array.length == 0) {
            System.out.println("Массив пуст. Сначала добавьте элементы.");
            return;
        }
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        
        long startTime = System.nanoTime();
        mergeSort(arrayToSort, 0, arrayToSort.length - 1);
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
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    private void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean swapped = true;
        
        while (swapped) {
            swapped = false;
            
            // Проход слева направо
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) break;
            
            right--;
            swapped = false;
            
            // Проход справа налево
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }
            
            left++;
        }
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
    
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public void deleteArray() {
        array = new int[0];
    }
}