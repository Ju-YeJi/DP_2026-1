package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfGenreIterator implements Iterator<Book> {
    private final BookShelf bookShelf;
    private final String genre;
    private int index;

    public BookShelfGenreIterator(BookShelf bookShelf, String genre) {
        this.bookShelf = bookShelf;
        this.genre = genre;
        this.index = 0;

        // 생성 시점에 바로 "조건에 맞는 첫 번째 책" 위치로 이동한다.
        moveToNextMatchedIndex();
    }

    // 현재 index부터 시작해서,
    // 지정한 장르와 일치하는 다음 책 위치를 찾는다.
    private void moveToNextMatchedIndex() {
        while (index < bookShelf.getLength()) {
            Book currentBook = bookShelf.getBookAt(index);

            if (currentBook.getGenre().equals(genre)) {
                break;
            }

            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // 현재 위치의 책을 반환하고,
        // 다음 호출을 위해 다시 조건에 맞는 다음 위치를 찾는다.
        Book result = bookShelf.getBookAt(index);
        index++;
        moveToNextMatchedIndex();

        return result;
    }
}