package hw.ch03;

public abstract class AbstractDisplay {

    //  반복 횟수를 저장하는 필드
    private int repeatCount;

    // 기본 생성자 (기존 코드 호환성 유지, 기본 5회)
    public AbstractDisplay() {
        this.repeatCount = 5;
    }

    // 반복 횟수를 받을 수 있는 생성자
    public AbstractDisplay(int repeatCount) {
        this.repeatCount = repeatCount;
    }
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    public final void display() {
        open();
        //for (int i = 0; i < 5; i++) {
        for (int i = 0; i < repeatCount; i++) {
            print();
        }
        close();
    }
}
