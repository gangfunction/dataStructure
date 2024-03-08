package sort;


public class SelectionSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // 현재 인덱스 이후의 요소들 중에서 가장 작은 요소를 찾음
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 현재 인덱스와 가장 작은 요소를 스왑
            swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
