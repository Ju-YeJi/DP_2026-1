package hw.ch20;

public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars;

    // 생성자 
    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }

    // 각 문자 위치에 대응하는 색상 배열을 받아 출력하는 오버로드 메서드
    public void print(String[] colors) {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print(colors[i]);
        }
    }
}
    
