package Statistics;

import java.util.Arrays;
import java.util.Random;

public class Statistics {
    public static int nth_element(int[] arr, int first, int last, int n) {
        boolean i;
         for(;i = true;){ // запуск циклу до поки умова істинна
            int k = randomizedPartition(arr, first, last);
            if (n < k)
                last = k;
            else if (n > k)
                first = k + 1;
            else
                return k;
        }
        return first;
    }
    // далі відтворено метод вибору випадкових значень rnd. Застосування методу
    static Random rnd = new Random();
    // далі по ходу відтворення алгоритму представлено вже відомий метод циклічного розбиття та сортування масиву (на основі QuickSort) із деякими модифікаціями та удосконаленнями
    static int randomizedPartition(int[] arr, int first, int last) {
        swap(arr, first + rnd.nextInt(last - first), last - 1);
        int separator = arr[last - 1]; // запис у змінну separator значення з передостанньої комірки масиву
        int i = first - 1;
        for (int j = first; j < last; j++)
        if (arr[j] <= separator)
        swap(arr, ++i, j);
        return i;
    }
    // далі представлено метод заміни між собою більших та менших за значеннями елементів масиву у порядку зростання (метод заміни)
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // створення тимчасової змінної temp для збереження значення із комірки і
        arr[i] = arr[j]; // запис в комірку і значення з комірки j
        arr[j] = temp; // запис в комірку j значення з тимчасової змінної temp
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(6);
        }
        System.out.println(Arrays.toString(arr));
        int k = rnd.nextInt(5);
        nth_element(arr, 0, arr.length, k);

        System.out.println("Порядкова статистика масиву з iндексом " + k + " містить значення: " + arr[k]);

    }
}
