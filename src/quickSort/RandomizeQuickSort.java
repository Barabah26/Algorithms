package quickSort;

import java.util.Scanner;

public class RandomizeQuickSort {
    static int randomPartition(int[] array, int first, int last){
        int random =(int)(Math.random()*(last - first) + first);

        int temp = array[random];
        array[random] = array[last];
        array[last] = temp;

        int pivot = array[last];
        int i = (first - 1);

        for (int j = first; j < last; j++){
            if (array[j] <= pivot){
                i++;

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        temp = array[last];
        array[last] = array[i + 1];
        array[i + 1] = temp;

        return i + 1;

    }

    static void quickRandomSort(int[] array, int first, int last) {
        if (first < last) {
            int pi = randomPartition(array, first, last);
            quickRandomSort(array, first, pi - 1);
            quickRandomSort(array, pi + 1, last);
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

        quickRandomSort(array, 0, array.length - 1);


        System.out.println("Залікові книжки студентів групи " + s + ": ");
        for (int i = 0; i < array.length; i++){
            System.out.println("- " + array[i] + "; ");
        }
    }

}
