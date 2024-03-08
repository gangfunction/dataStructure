package sort;

import sort.utils.DataReader;
import sort.utils.TimeMeasurement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
    /*
    성찰: BigInteger를 사용하는 경우는 내부 메서드 호출이 별개로 필요해서 추가적인 오버헤드 발생으로 int보다 효율적이지 못하다.
    이에 int로 변경.
     */

    public static void main(String[] args) throws InterruptedException {
        // 정렬할 데이터를 로드한다.
        System.out.println("데이터 로딩을 시작합니다...");
        String datasetUrl = "//Users/leegangju/Downloads/develop/IngoingProjects/dataStructure/array/src/main/java/sort/resource/large_int_dataset_1m.txt";
        int[] dataset = DataReader.load(datasetUrl);
        System.out.println("데이터 로딩이 완료되었습니다.");
        // 시간측정 도구를 준비한다.

        TimeMeasurement timeMeasurement = new TimeMeasurement();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 비동기 작업 제출 및 Future 객체 받기
        Future<?> future = executor.submit(() -> {
            timeMeasurement.start();
            // 정렬 알고리즘 실행
            SelectionSort.sort(dataset);
            timeMeasurement.stop();
        });

        // 비동기 작업이 진행되는 동안 경과 시간 업데이트
        while (!future.isDone()) {
            long elapsedTime = (System.currentTimeMillis() - timeMeasurement.getStartTime());
            System.out.println("정렬 실행 중... 경과 시간: " + convertMillisToReadableTime(elapsedTime));
            Thread.sleep(1000);  // 10초마다 업데이트
        }

        // 정렬 작업 완료 후 총 실행 시간
        long totalTime = timeMeasurement.getElapsedTime();
        System.out.println("정렬 완료! 총 실행 시간: " + convertMillisToReadableTime(totalTime));

        executor.shutdown();
    }
    public static String convertMillisToReadableTime(long millis) {
        if (millis < 1000) {
            return millis + " ms"; // 밀리초 단위
        } else if (millis < 60000) {
            return String.format("%.2f sec", millis / 1000.0); // 초 단위
        } else if (millis < 3600000) {
            return String.format("%.2f min", millis / 60000.0); // 분 단위
        } else {
            return String.format("%.2f hours", millis / 3600000.0); // 시간 단위
        }
    }

}


