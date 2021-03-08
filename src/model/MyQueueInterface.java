package model;

import exceptions.MyQueueException;

public interface MyQueueInterface<T> {
    public void enqueue(T t);

    public boolean isEmpty();

    public T getFront() throws MyQueueException;

    public T dequeue() throws MyQueueException;

    public int getLength();
}