package sort.utils;

public class TimeMeasurement {
    private long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("메소드 실행 시간: " + duration + "ms");
    }

    public long getStartTime() {
        return startTime;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }
}
