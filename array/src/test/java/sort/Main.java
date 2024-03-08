package sort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;
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
    100만건의 int범위의 정수를 나열한 결과
    selectionsort : 6.65min O(n^2)
    mergesort : 1.04sec O(nlogn)
     */

/*
성찰: BigInteger를 사용하는 경우는 내부 메서드 호출이 별개로 필요해서 추가적인 오버헤드 발생으로 int보다 효율적이지 못하다.
이에 int로 변경.
 */
/*
성찰: 데이터 로드부터 측정에 있어서는 JMH를 활용하는편이 성능측정에 더 정확하다.
 */
@State(Scope.Thread)
public class Main {


    private int[] dataset;

    @Param({"1000000"})
    private int datasetSize;

    @Setup
    public void setup() {
        Random random = new Random();
        dataset = new Random().ints(datasetSize, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkMergeSort() {
        // 복사된 배열을 사용하여 원본 데이터를 보존
        int[] copiedDataset = dataset.clone();
        MergeSort.sort(copiedDataset);
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}


