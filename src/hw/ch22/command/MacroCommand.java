package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;


public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    // undo로 삭제된 명령을 redo에서 다시 복원하기 위해 임시 보관하는 Deque
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        //descendingIterator()를 사용하여 가장 먼저 저장된 명령부터 순서대로 재실행
        Iterator<Command> it = commands.descendingIterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }


    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
        // undo 후 새 명령이 실행되면 기존 redo 이력은 더 이상 사용할 수 없음
        commandsForRedo.clear();
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            //  최근 명령을 그냥 삭제하지 않고, redo에서 다시 복원할 수 있도록 commandsForRedo에 저장
            Command cmd = commands.pop();
            commandsForRedo.push(cmd);
        }
    }

     //  undo로 제거했던 명령을 다시 실행 이력에 복원
    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            // commandsForRedo에서 가장 최근에 undo된 명령을 꺼냄
            Command cmd = commandsForRedo.pop();

            commands.push(cmd);
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
        commandsForRedo.clear();
    }
}
