package org.example;

public class NodeObj<T> {

    private T info;
    private NodeObj<T> next;

    public NodeObj(T info) {
        this.info = info;
        this.next = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeObj<T> getNext() {
        return next;
    }

    public void setNext(NodeObj<T> next) {
        this.next = next;
    }
}

