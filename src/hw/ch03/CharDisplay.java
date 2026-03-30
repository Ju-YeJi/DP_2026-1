package hw.ch03;

public class CharDisplay extends AbstractDisplay {
    private char ch; // 표시해야 하는 문자 

    // 생성자 
    public CharDisplay(char ch) {
        super(); // 기본 반복 횟수(5) 사용
        this.ch = ch;
    }

    //  반복 횟수를 받을 수 있는 생성자 추가
    public CharDisplay(char ch, int repeatCount) {
        super(repeatCount); // 상위 클래스에 반복 횟수 전달
        this.ch = ch;
    }

    @Override
    public void open() {
        // 시작 문자열 "<<"를 표시한다
        System.out.print("<<");
    }

    @Override
    public void print() {
        // 필드에 기억해 둔 문자를 1회 표시한다 
        System.out.print(ch);
    }

    @Override
    public void close() {
        // 종료 문자열 ">>"를 표시한다 
        System.out.println(">>");
    }
}
