package hw.ch20;

public class Main {

    // ANSI 색상 코드 상수
    // \u001B는 ANSI escape 문자의 Java 표현이다.
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);

        //  과제 테스트 조건에 맞춘 색상 순서
        String[] colorPattern = {
            RED, BLUE, GREEN, MAGENTA, CYAN, YELLOW, BLUE
        };

        //  입력 문자열 길이와 같은 colors 배열을 생성
        String[] colors = new String[args[0].length()];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = colorPattern[i % colorPattern.length];
        }

        bs.print(colors);
    }
}
