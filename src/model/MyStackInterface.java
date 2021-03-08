package model;

public interface MyStackInterface<T> {

    public T pop();

    public void push(T t);

    public T peek();

    public boolean isEmpty();

}