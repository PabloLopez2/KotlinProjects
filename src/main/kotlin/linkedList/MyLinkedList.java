package linkedList;

import java.util.ArrayList;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private final ArrayList<Node<T>> ramMemory = new ArrayList<>();
    private final Node<T> firstNode = new Node<>(null, null, null);
    private final Node<T> secondNode = new Node<>(null, null, null);
    private final Node<T> thirdNode = new Node<>(null, null, null);

    public MyLinkedList() {
        size();
        get(size);
        set(null, null);
        remove(null);
        addFirst(null);
        addLast(null);
        popFirst();
        popLast();
    }

    // FUNCIONS COMUNES

    /**
     * Returns the of this collection
     */
    public int size() {
        return ramMemory.size();
    }

    /**
     * Get the value at given index
     *
     * @throws IndexOutOfBoundsException the collection doesn't contain the requested element
     */
    public T get(Integer index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> nodeActual = null;
        for (int i = 0; i < index; i++) {
            nodeActual = nodeActual.next;
        }
        return firstNode.content;
    }

    /**
     * Adds the element at index
     *
     * @throws IndexOutOfBoundsException the collection doesn't contain the requested element
     */
    public void set(Integer index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> nodeActual2 = null;
        for (int i = 0; i < index; i++) {
            nodeActual2 = secondNode.next;
        }
        nodeActual2.content = element;
    }

    /**
     * Removes the element at index
     *
     * @throws IndexOutOfBoundsException the collection doesn't contain the requested element
     */
    public void remove(Integer index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else {
            Node<T> nodeActual3 = null;
            for (int i = 0; i < index; i++) {
                nodeActual3 = thirdNode.next;
            }
            nodeActual3.previous.next = nodeActual3.next;
            if (nodeActual3.next != null) {
                nodeActual3.next.previous = nodeActual3.previous;
            }
        }
        size--;
    }

    // PILES I CUES

    /**
     * Adds the element at the fist position
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element, null, head);
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds the element at the last position
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    /**
     * Get and remove the element at the first position
     */
    public T popFirst() {
        if (head == null) {
            return null;
        }
        T element = head.content;
        head = head.next;
        if (head != null) {
            head.previous = null;
        }
        size--;
        if (size == 0) {
            tail = null;
        }
        return element;
    }

    /**
     * Get and remove the element at the last position
     */
    public T popLast() {
        if (tail == null) {
            return null;
        }
        T element = tail.content;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        if (size == 0) {
            head = null;
        }
        return element;
    }
}
