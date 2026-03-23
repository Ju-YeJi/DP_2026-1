package hw.ch01;

// 3개 필드 추가
public class Book {
    private final String name;
    private final String genre;
    private final int year;
    private final double price;

    public Book(String name) {
        this(name, "미분류", 0, 0.0);
    }

    // 새 필드를 받는 생성자 오버로딩
    public Book(String name, String genre, int year, double price) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}
