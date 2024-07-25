package modul3;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort_221 {
    public static void main(String[] args) {
        int[] arr = {0, 45, 78, 5, -2891, 3, 9, 4, 818, 616, 7, 0};
        int begin = 0;
        int end = arr.length-1;
        mergeSort(arr, begin, end);
        System.out.println("Sorted array:"+ Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int begin, int end){
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }
    }

    public static void merge(int[] arr, int begin, int mid, int end ){
        int leftArr[] = new int[mid - begin + 1];
        int rightArr[] = new int[end - mid];

        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = arr[begin + i];
        for (int j = 0; j < rightArr.length; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = begin;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}

