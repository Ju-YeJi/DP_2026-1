package hw.ch12;

public class NumberedBorder extends Border {

    public NumberedBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        // 행 번호 장식은 "%2d| " 형식
        return 4 + display.getColumns();
    }

    @Override
    public int getRows() {
        // NumberedBorder는 행 개수를 늘리지 않고, 기존 내용물의 각 행 앞에 번호만 붙인다. 내용물의 행 수와 동일하다.
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        // row는 0부터 시작하므로 실제 출력 번호는 row + 1로 계산한다.
        // "%2d| "는 두 자리 폭의 번호, | 문자, 공백을 붙이는 형식
        // display.getRowText(row)를 호출해서 실제 내용물의 해당 행을 가져온다.
        return String.format("%2d| %s", row + 1, display.getRowText(row));
    }
}