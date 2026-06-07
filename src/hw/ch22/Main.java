package hw.ch22;

import hw.ch22.command.*;
import hw.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();

    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton clearButton = new JButton("clear");
    // 색상 변경 기능을 위해 red, green, blue 버튼 추가
    private JButton redButton = new JButton("red");
    private JButton greenButton = new JButton("green");
    private JButton blueButton = new JButton("blue");

    private JButton undoButton = new JButton("undo");
    //  undo로 취소한 명령을 다시 복원하기 위한 redo 버튼 추가
    private JButton redoButton = new JButton("redo");

    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        clearButton.addActionListener(e -> {
            history.clear();
            //  clear 후 기본 색상을 다시 빨간색으로 초기화
            // DrawCanvas.init() 안에서 빨간색 ColorCommand가 history에 다시 저장됨
            canvas.init();
            canvas.repaint();
        });

        redButton.addActionListener(e -> {
            //  red 버튼 클릭 시 현재 그리기 색상을 빨간색으로 변경
            // 색상 변경도 Command 객체로 만들어 history에 저장
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        });

        greenButton.addActionListener(e -> {
            //  green 버튼 클릭 시 현재 그리기 색상을 초록색으로 변경
            // 이 명령이 history에 저장되므로 undo/redo 시 색상 변경 순서도 복원 가능
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });

        blueButton.addActionListener(e -> {
            // blue 버튼 클릭 시 현재 그리기 색상을 파란색으로 변경
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        });

        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });

        redoButton.addActionListener(e -> {
            // redo 버튼 클릭 시 undo로 제거된 명령을 다시 history에 복원
            // 이후 repaint()를 호출하여 복원된 명령 기준으로 화면을 다시 그림
            history.redo();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        // 화면 상단에 색상 변경 버튼 배치
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        // 화면 상단에 redo 버튼 배치
        buttonBox.add(redoButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}