package insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        double[] array = new double[10];
        array[0] = 26.068;
        array[1] = 26.067;
        array[2] = 26.064;
        array[3] = 26.069;
        array[4] = 26.072;
        array[5] = 26.074;
        array[6] = 26.071;
        array[7] = 26.065;
        array[8] = 26.061;
        array[9] = 26.063;
        double[] sortedArray = insertionSort(array);
        System.out.println("Відсортований список залікових книжок студентів групи КН23с: ");
        for (int i = 0; i < sortedArray.length; i++){
            System.out.println("- " + sortedArray[i] + "; ");
        }

    }
    public static double[] insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double newValue = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > newValue) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = newValue;
        }
        return array;
    }
}
