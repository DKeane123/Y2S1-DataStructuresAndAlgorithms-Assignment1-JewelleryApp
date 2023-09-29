package utils;


public class Node<Data> {

    public Node<Data> next=null;
    public Data contents;

    public Node(Node<Data> next, Data contents) {
        this.next = next;
        this.contents = contents;
    }

    public Node<Data> getNext() {
        return next;
    }

    public Data getContents() {
        return contents;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setContents(Data c) {
        contents = c;
    }
}
