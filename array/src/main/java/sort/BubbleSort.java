package sort;


public class BubbleSort {
    public static void sort(int[] target){
        for(int i = 0; i < target.length - 1; i++){
            for(int j = 0; j < target.length - 1 - i; j++){
                if(target[j]>target[j+1]){
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }

    }
}
