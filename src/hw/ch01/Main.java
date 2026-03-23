package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // 학번
        System.out.println("학번: 20211233 이름: 주예지");
        System.out.println();

        BookShelf bookShelf = new BookShelf(10);
        bookShelf.appendBook(new Book("클린코드", "기술", 2008, 30000));
        bookShelf.appendBook(new Book("해리포터와 마법사의 돌", "소설", 1997, 15000));
        bookShelf.appendBook(new Book("사피엔스", "역사", 2011, 18000));
        bookShelf.appendBook(new Book("이펙티브 자바", "기술", 2018, 36000));
        bookShelf.appendBook(new Book("객체지향의 사실과 오해", "기술", 2015, 20000));
        bookShelf.appendBook(new Book("레미제라블", "소설", 1862, 12000));
        bookShelf.appendBook(new Book("총균쇠", "역사", 1997, 22000));
        bookShelf.appendBook(new Book("리팩터링", "기술", 2018, 34000));
        bookShelf.appendBook(new Book("로마인 이야기", "역사", 1992, 25000));
        bookShelf.appendBook(new Book("어린왕자", "소설", 1943, 9000));

        // 명시적으로 Iterator를 사용하는 방법
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 확장 for문을 사용하는 방법
        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();

        // 장르 필터 Iterator
        System.out.println("===== 장르 필터 Iterator : 기술 장르만 출력 =====");
        Iterator<Book> genreIterator = bookShelf.iteratorByGenre("기술");
        while (genreIterator.hasNext()) {
            printBook(genreIterator.next());
        }

        System.out.println();

        // 출판연도 역순 Iterator
        System.out.println("===== 출판연도 역순 Iterator : 최신 책부터 출력 =====");
        Iterator<Book> yearIterator = bookShelf.iteratorByYear();
        while (yearIterator.hasNext()) {
            printBook(yearIterator.next());
        }
    }

    // 출력
    private static void printBook(Book book) {
        System.out.printf(
            "제목: %-15s | 장르: %-4s | 출판연도: %4d | 가격: %.0f원%n",
            book.getName(),
            book.getGenre(),
            book.getYear(),
            book.getPrice()
        );
    }
}