package practice.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // 학번
        System.out.println("학번: 20211233 이름: 주예지");
        
        // 책 테스트
        Book book = new Book("Java Programming");
        System.out.println("Book name: " + book.getName());

        // 책장 테스트
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book("Java Programming"));
        bookShelf.appendBook(new Book("Design Patterns"));
        bookShelf.appendBook(new Book("Effective Java"));

        // 책장에 꽂혀 있는 책의 개수 출력

        // 방법1: 클라이언트가 책장에 꽂혀 있는 책의 개수를 직접 계산하는 방법
        for (int i = 0; i < bookShelf.getLength(); i++) {
            System.out.println("Book" + (i+1) + " : " + bookShelf.getBookAt(i).getName());
        }
        
        //방법2: Iterator를 사용하는 방법
        // iterator를  얻어옴
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            System.out.println("Book : " + it.next().getName());
        }

        // 방법3: 확장 for문을 사용하는 방법
        // 이게 가능한 이유는 Bookself 가 Iterable 인터페이스를 구현했기 때문
        for (Book b : bookShelf) { // 형식: for (요소타입 변수명 : 컬렉션) { ...}
            System.out.println("Book : " + b.getName());
        }
    }
}