package hw.ch22.drawer;

import java.awt.Color;

public interface Drawable {
    // 시작 시 또는 clear 후 기본 상태로 초기화하기 위한 메소드
    public abstract void init();

    public abstract void draw(int x, int y);

    //  ColorCommand가 현재 그리기 색상을 변경할 수 있도록 하는 메소드
    public abstract void setColor(Color color);
}