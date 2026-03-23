package practice.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> { 
    private BookShelf bookShelf;
    private int index; // 책꽂이에서 현재 위치를 나타내는 변수

    public BookShelfIterator(BookShelf bookShelf) { // 생성자
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() { // 다음에 읽을 책이 있는지 확인하는 메소드   
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {   // 다음에 읽을 책을 반환하는 메소드
        if (!hasNext()) {
            throw new NoSuchElementException(); // 더 이상 읽을 책이 없을 때 예외를 던짐
        }
        Book book = bookShelf.getBookAt(index); // 현재 위치에 있는 책을 가져옴
        index++;
        return book;
    }
}
