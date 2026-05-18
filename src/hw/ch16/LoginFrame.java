package hw.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;


    // 로그인 가능 여부를 표시하는 Label Colleague
    private ColleagueLabel statusLabel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 4×2 그리드 - > 5x2 그리드로 변경
        setLayout(new GridLayout(5, 2));

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        //  마지막 행에 로그인 가능 여부 Label을 배치한다.
        // 왼쪽 한 칸은 비워두고, 오른쪽에 statusLabel을 배치한다.
        add(new Label(""));
        add(statusLabel);

        // 활성/비활성 초기 설정을 한다
        colleagueChanged();

        // 표시한다 
        pack();
        setVisible(true);
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // 로그인 상태 표시 Label 생성
        // 초기값은 과제 조건에 맞게 "로그인 불가"로 생성한다.
        statusLabel = new ColleagueLabel("● 로그인 불가");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // 새로 만든 statusLabel도 Mediator에 등록
        statusLabel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            // 게스트 로그인 
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);

            // Guest는 바로 로그인 가능하므로 Label도 가능 상태로 변경
            statusLabel.setColleagueEnabled(true);
        } else {
            // 사용자 로그인 
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser 또는 textPass의 변경이 있다
    // 각 Colleague의 활성/비활성을 판정한다
    private void userpassChanged() {
        // Username은 4자 이상
        if (textUser.getText().length() >= 4) {
            textPass.setColleagueEnabled(true);

            // Password도 4자 이상이어야 OK 버튼을 활성화
            if (textPass.getText().length() >= 4) {
                buttonOk.setColleagueEnabled(true);

                // OK 버튼이 활성화되는 조건과 동일하게 Label도 로그인 가능으로 변경
                statusLabel.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);

                // Password가 4자 미만이면 로그인 불가로 표시
                statusLabel.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);

            // Username이 4자 미만이면 로그인 불가로 표시
            statusLabel.setColleagueEnabled(false);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
