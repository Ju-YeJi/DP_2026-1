package practice.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> { 
// public class BookShelf {
    private Book[] books; // 배열 선언
    private int last = 0; // 책의 마지막 위치

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; // 배열 생성
    }

    public Book getBookAt(int index) { // 책을 가져오는 메소드 (인덱스가 몇번에 있는 책인지)
        return books[index];
    }

    public void appendBook(Book book) { // 책 추가하는 메소드
        this.books[last] = book;
        last++; // 마지막위치 한칸 이동
    }

    public int getLength() { // 책의 개수를 반환하는 메소드(현재 책이 몇개 꽂혀 있는지)
        return last;
    }

    @Override
    public Iterator<Book> iterator() { // 자기자신(현재 책꽂이)의 Iterator를 생성해서 반환하는 메소드
        return new BookShelfIterator(this); // 현재 객체(책꽂이)를 가리킴
    }
}
