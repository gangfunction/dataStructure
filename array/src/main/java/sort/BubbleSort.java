package sort;
/*
    * 버블 정렬
    * 인접한 두 요소를 비교하여 정렬하는 방식
    * 시간 복잡도: O(n^2)
    * 공간 복잡도: O(n)
    * 장점: 구현이 간단하다
    * 단점: 시간 복잡도가 크다
    * 특징: 정렬이 거의 되어있는 상태에서는 가장 빠르다
 */
/*
    개선점 1: swap을 통해 이미 정렬이 되어있는 경우에는 더 이상 정렬하지 않도록 개선
 */

public class BubbleSort {
    public static void sort(int[] target){
        boolean swap;
        for(int i = 0; i < target.length - 1; i++){
            swap = false;
            for(int j = 0; j < target.length - 1 - i; j++){
                if(target[j]>target[j+1]){
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;

        }

    }
}
