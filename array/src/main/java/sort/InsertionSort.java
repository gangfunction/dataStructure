package sort;

import java.math.BigInteger;

public class InsertionSort {
    public static void sort(BigInteger[] target){
        for(int i = 1; i < target.length; i++){
            BigInteger temp = target[i];
            int j = i - 1;
            while(j >= 0 && (target[j].compareTo(temp) > 0)){
                target[j + 1] = target[j];
                j--;
            }
            target[j + 1] = temp;
        }
    }
}
