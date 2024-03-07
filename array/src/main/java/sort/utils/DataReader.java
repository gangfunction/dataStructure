package sort.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
    * This class is responsible for reading data from a file.
    * DataReader클래스 기능 명세
    * load함수가 호출될때마다 이전 데이터값은 사라진다. int[]를 반환한다.
    * add함수가 호출될때마다 이전 데이터값 + 입력한 데이터값이 사용된다. int[]을 입력받고 int[]을 반환한다.
    * write함수가 호출될때마다 이전 데이터값은 사라지고, 입력한 데이터값이 사용된다.
 */
public class DataReader {
    private long[] dataForProcess =null;
    static List<BigInteger> numbers = new ArrayList<>();

    public static BigInteger[] load(String url){
        try{
            File target = new File(url);
            FileReader fileReader = new FileReader(target);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                BigInteger number = new BigInteger(line);
                numbers.add(number);
            }
            BigInteger[] data = new BigInteger[numbers.size()];
            for(int i = 0; i < numbers.size(); i++){
                data[i] = numbers.get(i);
            }
            return data;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    public int[] add(int[] data){
        return null;
    }
    public void write(int[] data){

    }

    public DataReader() {
        /*
            * This is the constructor for the DataReader class.
         */
    }
}
