package model;

import exceptions.MyQueueException;

public class MyQueue<T> implements MyQueueInterface<T> {

    private Node<T> front;
    private Node<T> back;
    private int length;

    public MyQueue() {
        length = 0;
    }

    @Override
    public void enqueue(T t) {
        Node<T> newNode = new Node<T>(t);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            newNode.setNextNode(back);
            back.setPrevNode(newNode);
            back = newNode;
        }
        length++;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T getFront() throws MyQueueException {
        if (isEmpty())
            throw new MyQueueException("There is nothing in the queue");
        else
            return front.getValue();
    }

    @Override
    public T dequeue() throws MyQueueException {
        if (isEmpty())
            throw new MyQueueException("There is nothing in the queue");
        else {
            T t = front.getValue();
            if (getLength() == 1) {
                front = null;
                back = null;
            } else {
                front.getPrevNode().setNextNode(null);
                front = front.getPrevNode();
            }
            length--;
            return t;
        }
    }

    @Override
    public int getLength() {
        return length;
    }
}