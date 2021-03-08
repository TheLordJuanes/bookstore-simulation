package model;

public class MyStack<T> implements MyStackInterface<T> {

    private Node<T> top;
    private int length;

    public MyStack() {
        length = 0;
    }

    @Override
    public T pop() {
        Node<T> temp = top.getPrevNode();
        Node<T> nodeDeleted = top;
        temp.setNextNode(null);
        top = temp;
        length--;
        return nodeDeleted.getValue();
    }

    @Override
    public void push(T t) {
        Node<T> newNode = new Node<>(t);
        if (!isEmpty()) {
            top.setNextNode(newNode);
            newNode.setPrevNode(top);
        }
        top = newNode;
        length++;
    }

    @Override
    public T peek() {
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }
}