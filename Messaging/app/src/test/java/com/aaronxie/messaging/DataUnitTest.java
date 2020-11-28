package com.aaronxie.messaging;

import org.junit.Test;

import java.util.Arrays;

/**
 * create by Aaron Xie
 * on 2020/9/8
 * description:
 */
public class DataUnitTest {
    @Test
    public void bubbleSort() {
        int[] arr = {7, -1, 5, 6, 2, 8, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectSort() {
        int[] arr = {7, -1, 5, 6, 2, 8, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertSort() {
        int[] arr = {7, -1, 5, 6, 2, 8, 5};
        for (int index = 1; index < arr.length; index++) {
            int temp = arr[index];
            int leftIndex = index - 1;
            while (leftIndex >= 0 && arr[leftIndex] > temp) {
                arr[leftIndex + 1] = arr[leftIndex];
                leftIndex--;
            }
            arr[leftIndex + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertSort02() {
        int[] arr = {7, -1, 5, 6, 2, 8, 5};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void quickSort() {
        int[] arr = {7, -1, 5, 6, 2, 8, 5};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            sort(arr, 0, index - 1);
            sort(arr, index + 1, high);
        }
    }

    private int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] > temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    @Test
    public void search() {
        int[] arr = {7, -1, 5, 6, 2, 8, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int result = searchTarget(arr, 5);
        System.out.println(result);
    }

    private int searchTarget(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
