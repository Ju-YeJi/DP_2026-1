package hw.ch05;

public class LoggerSynchronizedLazy {
    // 처음에는 인스턴스를 만들지 않고 null로 초기화합니다.
    private static LoggerSynchronizedLazy instance = null;

    // 로그 내용을 저장할 버퍼
    private StringBuilder logBuffer;

    // 외부에서 new로 생성하지 못하게 private 생성자로 막기
    private LoggerSynchronizedLazy() {
        System.out.println("[LoggerSynchronizedLazy] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder(); // 로그 저장 공간 초기화
    }

    // synchronized를 붙여 여러 스레드가 동시에 호출해도 인스턴스가 하나만 생성되도록 보장
    public static synchronized LoggerSynchronizedLazy getInstance() {
        //  instance가 아직 없을 때만 객체를 한 번 생성
        if (instance == null) {
            instance = new LoggerSynchronizedLazy();
        }
        return instance;
    }

    // 메시지를 시간과 함께 버퍼에 누적 저장하고 화면에도 출력
    public void log(String message) {
        logBuffer.append("[")
                 .append(System.currentTimeMillis())
                 .append("] ")
                 .append(message)
                 .append("\n");
        System.out.println("[LoggerSynchronizedLazy] " + message);
    }

    // 지금까지 저장된 전체 로그를 반환
    public String getLog() {
        return logBuffer.toString();
    }
}