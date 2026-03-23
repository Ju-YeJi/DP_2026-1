package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfYearIterator implements Iterator<Book> {
    private final Book[] sortedBooks;
    private int index;

    public BookShelfYearIterator(BookShelf bookShelf) {
        int length = bookShelf.getLength();
        sortedBooks = new Book[length];

        // 원본 BookShelf의 순서를 직접 바꾸지 않기 위해
        // 내부 배열을 복사해서 별도로 정렬한다.
        for (int i = 0; i < length; i++) {
            sortedBooks[i] = bookShelf.getBookAt(i);
        }

        // 출판연도 기준 내림차순 정렬
        // (최신 책 -> 오래된 책)
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sortedBooks[i].getYear() < sortedBooks[j].getYear()) {
                    Book temp = sortedBooks[i];
                    sortedBooks[i] = sortedBooks[j];
                    sortedBooks[j] = temp;
                }
            }
        }

        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < sortedBooks.length;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return sortedBooks[index++];
    }
}