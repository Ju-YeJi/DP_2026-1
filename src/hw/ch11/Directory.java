package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

     // Directory는 Composite 역할이므로 자기 자신도 검사하고, 내부에 들어 있는 모든 Entry의 search() 결과를 재귀적으로 병합
    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();

        // 1. 디렉토리 자기 자신의 이름도 검색 대상에 포함한다.
        if (name.contains(keyword)) {
            result.add(this);
        }

        // 2. 자식 Entry들을 하나씩 꺼내 search()를 호출한다.
        // entry가 File이면 File.search()가 실행되고,
        // entry가 Directory이면 Directory.search()가 재귀적으로 실행된다.
        for (Entry entry : directory) {
            result.addAll(entry.search(keyword));
        }

        return result;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        entry.setParent(this);
        return this;
    }
}
