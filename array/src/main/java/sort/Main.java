package sort;

import sort.utils.DataReader;
import sort.utils.TimeMeasurement;

import java.math.BigInteger;

public class Main {

    /*
    정렬용 데이터 준비.
    1. 정렬할 데이터의 크기를 정한다. (소규모 데이터 셋, 대규모 데이터 셋을 하나씩 준비한다.)
    2. Main 클래스의 main 메소드에서 정렬할 데이터를 로드한다.
    3. 정렬알고리즘을 실행하기전에 시간 측정도구를 사용하여 정렬 알고리즘의 성능을 측정한다.
     */

    /*
    예시1) - 향후 예시가 추가될수 있습니다.
    숫자형 uuid 10만건을 정렬하는데 걸리는시간
    bubblesort : 64565ms O(n^2)
    insertionsort : 19566ms O(n^2)
    mergesort : 32ms O(nlogn)
    quicksort : 37ms O(nlogn)
    selectionsort : 48121ms O(n^2)
     */
    public static void main(String[] args) {
        // 정렬할 데이터를 로드한다.
        String datasetUrl = "/Users/leegangju/Downloads/develop/IngoingProjects/dataStructure/array/src/main/java/sort/resource/numeric_uuids_sample.txt";
        BigInteger[] dataset = DataReader.load(datasetUrl);

        // 시간측정 도구를 준비한다.
        TimeMeasurement timeMeasurement = new TimeMeasurement();
        // 정렬 알고리즘을 실행한다.
        sort(timeMeasurement, dataset);


    }

    private static void sort(TimeMeasurement timeMeasurement, BigInteger[] dataset) {
        timeMeasurement.start();
        // 정렬 알고리즘을 실행한다.
        SelectionSort.sort(dataset);
        // 시간측정 도구를 사용하여 정렬 알고리즘의 성능을 측정한다.
        timeMeasurement.stop();
    }
}
