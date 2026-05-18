package hw.ch16;

import java.awt.Color;
import java.awt.Label;

// 로그인 가능 여부를 표시하는 새로운 Colleague 클래스
public class ColleagueLabel extends Label implements Colleague {
    private Mediator mediator;

    public ColleagueLabel(String text) {
        super(text);
    }

    // Mediator를 저장
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    //  로그인 가능 여부에 따라 텍스트와 글자색을 변경
    @Override
    public void setColleagueEnabled(boolean enabled) {
        if (enabled) {
            setText("● 로그인 가능");
            setForeground(Color.blue);
        } else {
            setText("● 로그인 불가");
            setForeground(Color.gray);
        }
    }
}