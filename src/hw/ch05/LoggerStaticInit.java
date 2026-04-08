package hw.ch05;

public class LoggerStaticInit {
    private static final LoggerStaticInit instance = new LoggerStaticInit();
    private StringBuilder logBuffer;

    private LoggerStaticInit() {
        System.out.println("[LoggerStaticInit] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    public static LoggerStaticInit getInstance() {
        return instance;
    }

    public void log(String message) {
        logBuffer.append("[")
                 .append(System.currentTimeMillis())
                 .append("] ")
                 .append(message)
                 .append("\n");
        System.out.println("[LoggerStaticInit] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}