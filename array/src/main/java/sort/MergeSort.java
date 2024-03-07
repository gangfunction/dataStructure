package sort;

import java.math.BigInteger;

public class MergeSort {
    public static void sort(BigInteger[] array) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;
        BigInteger[] leftArray = new BigInteger[mid];
        BigInteger[] rightArray = new BigInteger[array.length - mid];

        // 원본 배열을 두 부분으로 나누기
        System.arraycopy(array, 0, leftArray, 0, mid);
        if (array.length - mid >= 0) System.arraycopy(array, mid, rightArray, 0, array.length - mid);

        // 두 부분을 재귀적으로 정렬
        sort(leftArray);
        sort(rightArray);

        // 정렬된 두 부분을 합병
        merge(leftArray, rightArray, array);
    }
    private static void merge(BigInteger[] leftArray, BigInteger[] rightArray, BigInteger[] array) {
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

        // 두 부분을 비교하여 합병
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if ( rightArray[rightIndex].compareTo(leftArray[leftIndex]) >= 0){
                array[arrayIndex++] = leftArray[leftIndex++];
            } else {
                array[arrayIndex++] = rightArray[rightIndex++];
            }
        }

        // 남은 요소들을 합병
        while (leftIndex < leftArray.length) {
            array[arrayIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            array[arrayIndex++] = rightArray[rightIndex++];
        }
    }
}
