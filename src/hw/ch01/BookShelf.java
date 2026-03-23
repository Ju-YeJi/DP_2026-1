package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    // 특정 장르의 책만 순회하는 Iterator를 반환
    public Iterator<Book> iteratorByGenre(String genre) {
        return new BookShelfGenreIterator(this, genre);
    }


    // 출판연도 역순으로 순회하는 Iterator를 반환
    public Iterator<Book> iteratorByYear() {
        return new BookShelfYearIterator(this);
}
}

