package hw.ch17;

public class EvenNumberGenerator extends NumberGenerator {
    private int number; // 현재 생성된 숫자를 저장한다.
    private int end;    // 종료값이다. 이 값은 포함하지 않는다.

    public EvenNumberGenerator(int start, int end) {
        // 과제 조건에서 start는 짝수여야 한다.
        // 홀수가 들어오면 잘못된 사용이므로 예외를 발생시킨다.
        if (start % 2 != 0) {
            throw new IllegalArgumentException("start는 짝수여야 합니다.");
        }

        // 시작값과 종료값을 필드에 저장한다.
        this.number = start;
        this.end = end;
    }

    @Override
    public int getNumber() {
        // Observer들이 현재 숫자를 확인할 수 있도록 반환한다.
        return number;
    }

    @Override
    public void execute() {
        // start부터 end 미만까지 반복한다.
        // 증가폭은 항상 2로 고정되어 있으므로 짝수만 생성된다.
        while (number < end) {
            // 현재 숫자가 생성되었음을 등록된 모든 Observer에게 알린다.
            // 이 호출로 DigitObserver, GraphObserver, RangeObserver의 update()가 실행된다.
            notifyObservers();

            // 다음 짝수로 이동한다.
            number += 2;
        }
    }
}