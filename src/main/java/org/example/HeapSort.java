package org.example;

// Реализация пирамидальной сортировки на Java
public class HeapSort {
    public int sort(int arr[]) {
        int count = 0;
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            count += heapify(arr, n, i);
        }
        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            count += heapify(arr, i, 0);
        }

        return count;
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
    int heapify(int arr[], int n, int i) {
        int count = 0;
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            count++; // Увеличиваем счетчик при каждом обмене элементов

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            count += heapify(arr, n, largest);
        }
        return count;
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}