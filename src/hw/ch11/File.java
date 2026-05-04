package hw.ch11;

import java.util.ArrayList; //  검색 결과를 담을 리스트 생성용
import java.util.List;      //  search() 반환 타입용


public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    //  File은 Leaf 역할이므로 자기 자신만 검사
    // 파일 이름에 keyword가 포함되어 있으면 자기 자신을 결과 리스트에 넣고 반환
    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();

        if (name.contains(keyword)) {
            result.add(this);
        }

        return result;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
