package sort;


public class QuickSort {
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            // 분할된 부분 리스트에 대해 재귀적으로 퀵 정렬 수행
            sort(array, low, partitionIndex - 1);
            sort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // 피벗을 기준으로 작은 값은 왼쪽으로 이동
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // 피벗 위치를 결정
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
