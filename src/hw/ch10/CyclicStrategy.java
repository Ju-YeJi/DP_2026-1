package hw.ch10;

public class CyclicStrategy implements Strategy {
    // 0이면 바위, 1이면 가위, 2이면 보
    private int handValue = 0;

    @Override
    public Hand nextHand() {
        // 현재 handValue에 해당하는 손을 가져옴
        Hand nextHand = Hand.getHand(handValue);

        // 다음 호출 때는 다음 손이 나오도록 값을 1 증가
        // 0 -> 1 -> 2 -> 0 순환이 되도록 % 3을 사용
        handValue = (handValue + 1) % 3;

        // 이번에 선택한 손을 반환
        return nextHand;
    }

    @Override
    public void study(boolean win) {
        // 무조건 바위 -> 가위 -> 보 순서로만 순환
    }
}