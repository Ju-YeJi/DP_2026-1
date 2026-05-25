package hw.ch19;

public class ClosingState implements State {
    // Singleton 패턴을 적용하여 인스턴스가 하나만 생성되도록 한다.
    private static ClosingState singleton = new ClosingState();

    // 생성자를 private으로 선언하여 외부에서 new ClosingState()를 호출하지 못하게 한다.
    private ClosingState() {
    }

    //  유일하게 생성된 ClosingState 인스턴스를 반환한다.
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        //  현재 시간이 17시보다 작으면 마감 시간이 아니므로 주간 상태로 전환한다.
        if (hour < 17) {
            context.changeState(DayState.getInstance());

        //  현재 시간이 20시 이상이면 마감 시간이 끝났으므로 야간 상태로 전환한다.
        } else if (20 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        // 마감 상태에서 금고를 사용하면 경비 센터에 마감 금고 점검을 통보한다.
        // SafeFrame의 callSecurityCenter()에서 앞에 call! 이 자동으로 붙는다.
        context.callSecurityCenter("마감 금고 점검");
    }

    @Override
    public void doAlarm(Context context) {
        //  마감 상태에서 비상벨이 눌리면 경비 센터에 비상벨 상황을 보고한다.
        context.callSecurityCenter("비상벨(마감)");

        // 비상벨 발생 후에는 상태를 비상시 상태로 전환한다.
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        //  마감 상태에서 일반 통화를 하면 퇴근 확인 통화로 기록한다.
        // SafeFrame의 recordLog()에서 앞에 record ... 가 자동으로 붙는다.
        context.recordLog("퇴근 확인 통화(마감)");
    }

    @Override
    public String toString() {
        // 상태 전환 메시지에서 [마감]으로 출력되도록 한다.
        return "[마감]";
    }
}