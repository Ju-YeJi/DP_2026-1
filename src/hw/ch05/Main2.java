package hw.ch05;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("========== 방식 2: Synchronized Lazy ==========");

        LoggerSynchronizedLazy logger2a = LoggerSynchronizedLazy.getInstance();
        LoggerSynchronizedLazy logger2b = LoggerSynchronizedLazy.getInstance();

        logger2a.log("Synchronized Message 1");
        logger2b.log("Synchronized Message 2");

        if (logger2a == logger2b) {
            System.out.println("✓ 동일한 인스턴스");
        } else {
            System.out.println("✗ 다른 인스턴스");
        }

        System.out.println("\n========== 로그 출력 2 ==========");
        System.out.println("[LoggerSynchronizedLazy 로그]");
        System.out.println(logger2a.getLog());
    }
}