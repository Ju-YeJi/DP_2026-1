package hw.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름 
    private char charname;

    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    // fontdata는 문자 모양 데이터이므로 BigChar 안에 저장되는 내재 상태이다.
    private String fontdata;

    //  ANSI 색상 리셋 코드
    private static final String RESET = "\u001B[0m";

    // 생성자 
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            
            Path path = Path.of("src", "hw", "ch20", filename);

            StringBuilder sb = new StringBuilder();

            for (String line: Files.readAllLines(path)) {
                sb.append(line);
                sb.append("\n");
            }

            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    // 기존 print() 메서드는 수정하지 않는다.
    public void print() {
        System.out.print(fontdata);
    }

    //  색상 코드를 외재 상태로 받아 큰 문자를 출력하는 오버로드 메서드
    public void print(String colorCode) {
        System.out.print(colorCode + fontdata + RESET);
    }
}