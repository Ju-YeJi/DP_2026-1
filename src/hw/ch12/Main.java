package hw.ch12;

public class Main {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();

        // 3개의 문자열을 MultiStringDisplay에 추가
        // MultiStringDisplay는 가장 긴 문자열 길이에 맞춰 짧은 문자열 뒤에 공백을 자동으로 채운다.
        md.add("Hello, Java!");
        md.add("Decorator Pattern");
        md.add("is powerful.");

        System.out.println("[2-1] 원본 출력");
        md.show();

        System.out.println();

        System.out.println("[2-2] NumberedBorder 단독 적용");
        // 기존 MultiStringDisplay를 수정하지 않고 NumberedBorder로 감싸서 각 행 앞에 번호를 붙인다.
        Display d1 = new NumberedBorder(md);
        d1.show();

        System.out.println();

        System.out.println("[2-3] FullBorder + NumberedBorder 조합");
        // NumberedBorder로 먼저 행 번호를 붙인 결과를 FullBorder가 다시 감싸서 상하좌우 테두리를 만든다.
        Display d2 = new FullBorder(new NumberedBorder(md));
        d2.show();

        System.out.println();

        System.out.println("[2-4] SideBorder + NumberedBorder + FullBorder 3단 중첩");
        // FullBorder(md)를 먼저 만든 뒤, 그 결과에 NumberedBorder를 적용하고, 마지막으로 SideBorder가 양쪽에 '*' 장식을 붙인다.
        Display d3 = new SideBorder(new NumberedBorder(new FullBorder(md)), '*');
        d3.show();
    }
}