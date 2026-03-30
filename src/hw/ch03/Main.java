package hw.ch03;

public class Main {
    // 기존 코드
    public static void main(String[] args) {
        System.out.println("[3-1] 기본 테스트");
        // 'H'를 가진 CharDisplay 인스턴스를 하나 만든다 
        AbstractDisplay d1 = new CharDisplay('H');

        // "Hello, world."를 가진 StringDisplay 인스턴스를 하나 만든다 
        AbstractDisplay d2 = new StringDisplay("Hello, world.");

        // d1,d2 모두 같은 AbstractDisplay의 하위 클래스의 인스턴스이므로
        // 상속한 display 메소드를 호출할 수 있다
        // 실제 동작은 CharDisplay나 StringDisplay 클래스에서 정해진다
        d1.display();
        d2.display();
        System.out.println();

        //  [3-2] 반복 횟수 제어 테스트
        System.out.println("[3-2] 반복 횟수 제어 테스트");
        AbstractDisplay d3 = new CharDisplay('X', 3);
        AbstractDisplay d4 = new StringDisplay("Test", 7);

        d3.display();
        d4.display();
        System.out.println();

        // [3-3] 새로운 NumberDisplay 
        System.out.println("[3-3] 새로운 NumberDisplay 테스트");
        AbstractDisplay num = new NumberDisplay(42, 4);
        num.display();
    }
}

