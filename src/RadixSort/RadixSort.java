package RadixSort;

import java.util.Scanner;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
        public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countingSort(int arr[], int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть групу: ");
        String s = scanner.nextLine();
        System.out.println("Введіть кількість залікових книжок: ");
        int num = scanner.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < array.length; i++){
            System.out.println("Введіть номер залікової книжки: ");
            array[i] = scanner.nextInt();
        }

        RadixSort.radixSort(array);


        System.out.println("Залікові книжки студентів групи " + s + ": ");
        for (int i = 0; i < array.length; i++){
            System.out.println("- " + array[i] + "; ");
        }
    }
}


//getMax - метод, який знаходить максимальний елемент у масиві.
// Він перебирає всі елементи масиву, порівнює їх з максимальним елементом і оновлює максимальний елемент, якщо знайдений елемент більший.

//countingSort - метод, який використовує алгоритм підрахунку для сортування елементів за певним розрядом.
// Він створює три масиви: output, count і arr.
// Масив output зберігає відсортований масив, масив count зберігає кількість елементів з кожною цифрою, а масив arr зберігає вихідний масив, який потрібно відсортувати.
// Спочатку метод проходить по масиву arr і збільшує count[digit], де digit - це цифра за розрядом exp в елементі arr[i].
// Потім метод проходить по масиву count і додає кожний елемент до попереднього, щоб отримати кількість елементів, які повинні бути меншими за певну цифру.
// Нарешті, метод проходить по масиву arr з кінця і додає кожен елемент до масиву output відповідно до кількості елементів з певною цифрою.

//radixSort - метод, який викликає countingSort для кожного розряду, починаючи з найменшого розряду і закінчуючи найбільшим.
// Кожен крок включає сортування елементів за певним розрядом використовуючи countingSort.




