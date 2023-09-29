package utils;

import java.util.Iterator;

public class GenericLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> temp;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTemp() {
        return temp;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void setTemp(Node<E> temp) {
        this.temp = temp;
    }

    public void addElement(E c) {
        head = new Node<>(head, c);
        temp=head;
    }

    public E get(int e){
        Node<E> node = head;
        for (int i = 0; i < e; i++){
            node = node.next;
        }
        return node.getContents();
    }

    public void clearList() {
        head=null;
    }

    public void remove(int index) {
        index = listLength() - index - 1;
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }
    }

    public String printList() {
        String List = "";
        Node<E> currentNode = head;

        while(currentNode != null){
            List = List + currentNode.getContents() + "\n";
            currentNode = currentNode.next;
        }
        return List;
    }

    public boolean isEmpty(){

        if(listLength() <= 0){
            return false;
        }
        else{
            return true;
        }
    }

    public int listLength()
    {
        Node temp = head; // make a copy of the head
        int counter = 0;
        while (temp != null)  //while there is a node after the head
        {
            counter++; //the counter will start counting
            temp = temp.next; //then when the head
        }
        return counter;  // when there is nothing in front of the head it returns how many nodes were counted
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<E>(head);
    }

}

