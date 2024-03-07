package sort;

import java.math.BigInteger;

public class SelectionSort {
    public static void sort(BigInteger[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // 현재 인덱스 이후의 요소들 중에서 가장 작은 요소를 찾음
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 현재 인덱스와 가장 작은 요소를 스왑
            swap(array, i, minIndex);
        }
    }

    private static void swap(BigInteger[] array, int i, int j) {
        BigInteger temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
