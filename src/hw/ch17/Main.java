package hw.ch17;

public class Main {
    public static void main(String[] args) {
        // EvenNumberGenerator(0, 30)을 생성한다.
        // 0부터 시작해서 30 미만까지 짝수만 생성하므로 실제 출력되는 값은 0, 2, 4, ..., 28이다.
        NumberGenerator generator = new EvenNumberGenerator(0, 30);

        // 기존 Observer: 숫자를 그대로 출력한다.
        Observer observer1 = new DigitObserver();

        // 기존 Observer: 숫자만큼 * 그래프를 출력한다.
        Observer observer2 = new GraphObserver();

        // 새로 추가한 Observer: 숫자의 범위를 Low, Mid, High로 출력한다.
        Observer observer3 = new RangeObserver();

        // 생성된 숫자가 바뀔 때마다 통지받을 Observer들을 등록한다.
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);

        // 숫자 생성을 실행한다.
        // execute() 내부에서 notifyObservers()가 호출되며, 등록된 세 Observer가 차례대로 update()를 수행한다.
        generator.execute();
    }
}