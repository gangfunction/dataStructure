package sort;

import java.math.BigInteger;

public class InsertionSort {
    public static void sort(int[] target){
        for(int i = 1; i < target.length; i++){
            int temp = target[i];
            int j = i - 1;
            while(j >= 0 && (target[j]>temp)){
                target[j + 1] = target[j];
                j--;
            }
            target[j + 1] = temp;
        }
    }
}
