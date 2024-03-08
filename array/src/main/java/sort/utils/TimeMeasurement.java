package sort.utils;

public class TimeMeasurement {
    private long startTime;

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
