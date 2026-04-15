package hw.ch06.framework;

public interface Product extends Cloneable {
    // public interface Product {
    public abstract void use(String s);
    public abstract Product createCopy(); // 복제 메서드
}
