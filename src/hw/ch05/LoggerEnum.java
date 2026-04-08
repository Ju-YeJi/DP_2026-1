package hw.ch05;

public enum LoggerEnum {
    // 유일한 싱글턴 객체
    INSTANCE;

    // 로그 내용을 저장할 버퍼
    private StringBuilder logBuffer;

    // enum 생성자는 INSTANCE가 만들어질 때 한 번만 호출
    LoggerEnum() {
        System.out.println("[LoggerEnum] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder(); // 로그 저장 공간 초기화
    }

    // 메시지를 시간과 함께 버퍼에 누적 저장하고 화면에도 출력
    public void log(String message) {
        logBuffer.append("[")
                 .append(System.currentTimeMillis())
                 .append("] ")
                 .append(message)
                 .append("\n");
        System.out.println("[LoggerEnum] " + message);
    }

    // 지금까지 저장된 전체 로그를 반환합니다.
    public String getLog() {
        return logBuffer.toString();
    }
}