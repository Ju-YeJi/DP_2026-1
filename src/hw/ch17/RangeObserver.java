package hw.ch17;

public class RangeObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        // 관찰 대상 NumberGenerator에서 현재 생성된 숫자를 가져온다.
        // 여기서는 EvenNumberGenerator 같은 구체 클래스 이름을 직접 사용하지 않는다.
        // 즉, NumberGenerator 추상 타입에만 의존하므로 Observer 패턴의 확장성을 유지한다.
        int number = generator.getNumber();

        // 숫자의 범위에 따라 출력할 레이블을 결정한다.
        // 0 이상 10 미만: Low
        // 10 이상 20 미만: Mid
        // 20 이상: High
        String label;
        if (number < 10) {
            label = "Low";
        } else if (number < 20) {
            label = "Mid";
        } else {
            label = "High";
        }

        // 과제에서 제시한 출력 형식에 맞게 출력한다.
        System.out.println("RangeObserver: [" + label + "] " + number);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}