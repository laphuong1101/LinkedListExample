package util;

import entity.Book;

public class MyList {

    private Node head;
    private Node tail;

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    public MyList(Node node) {
        this.head = this.tail = node;
    }

    private void addFirstNode(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.setNext(head);
            this.head = node;
        }
    }

    private void addLastNode(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void addFirst(Book book) {
        Node node = new Node(book);
//        if (checkExistId(node.getData().getId())) {
//            System.out.println("Id Exist");
//        }
        this.addFirstNode(node);
    }

    public void addLast(Book book) {
        Node node = new Node(book);
//        if (checkExistId(node.getData().getId())) {
//            System.out.println("Id Exist");
//        }
        this.addLastNode(node);
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty !");
            return;
        }

        Node now = head;
        while (now != null) {
            now.printInfoNode();
            now = now.getNext();
        }
    }

    public int size() {
        int count = 0;
        if (head == null) {
            return count;
        }
        Node now = head;
        while (now != null) {
            count++;
            now = now.getNext();
        }
        return count;
    }

    public void search(String id) {
        if (head == null) {
            System.out.println("List is empty !");
            return;
        }

        Node now = head;
        while (now != null) {
            Book book = now.getData();
            if (book.getId().equals(id)) {
                now.printInfoNode();
            }
            now = now.getNext();
        }
    }

    public boolean checkExistId(String id) {
        if (head == null) {
            return false;
        }
        Node now = head;
        while (now != null) {
            Book book = now.getData();
            if (book.getId().equals(id)) {
                return true;
            }
            now = now.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void addAfter(int index, Book book) {
        if (checkExistId(book.getId()) == false) {
            if (isEmpty() && index == 0) {
                addFirst(book);
            } else if (index == size()) {
                addLast(book);
            } else if (index < size() && index >= 0) {
                prependANode(index, book);
            } else {
                System.out.println("Index is Invaild");
            }
        }
    }

    public void appendANode(int index, Book book) {
        if (isEmpty()) {
            System.out.println("List is empty !");
            return;
        }
        if (index >= size() || index < 0) {
            System.out.println("Index is Invaild");
            return;
        }
        Node nodeData = getNode(book);
        if (size() == 1) {
            addLast(book);
        } else {
            Node node = getNode(index);
            if (node != null) {
                Node temp = node.getNext();
                nodeData.setNext(temp);
                node.setNext(nodeData);
            } else {
                System.out.println("Index is Invaild");
            }
        }
    }

    public void prependANode(int index, Book book) {
        if (isEmpty()) {
            System.out.println("List is empty !");
            return;
        }
        if (index >= size() || index < 0) {
            System.out.println("Index is Invaild");
            return;
        }
        Node nodeData = getNode(book);
        if (index == 0) {
            addFirst(book);
        } else {
            Node node = getNode(index - 1);
            if (node != null && node.getNext() != null) {
                Node temp = node.getNext();
                nodeData.setNext(temp);
                node.setNext(nodeData);

            } else {
                System.out.println("Index is Invaild");
            }
        }
    }

    private Node getNode(Book book) {
        Node node = new Node(book);
        node.setNext(null);
        return node;
    }

    public Node getNode(int index) {
        if (index < 0) {
            return null;
        }
        int count = 0;
        Node now = head;
        if (index == 0) {
            return now;
        }
        while (now != null) {
            if (count == index) {
                return now;
            }
            count++;
            now = now.getNext();
        }

        return null;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        }else {
            Node temp = head;
            head = head.getNext();
            temp = null;
        }

    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        }else {
            for (Node now = head; now != null ; now = now.getNext()) {
                if (now.getNext() == tail) {
                    tail = null;
                    now.setNext(null);
                    tail = now;
                }
            }
        }
    }

    public void removeAfter(int index) {
        Node node = getNode(index);
        if (node != null) {
            Node afterNode = node.getNext();
            if (afterNode != null) {
                node.setNext(afterNode.getNext());
                afterNode = null;
            } else {
                System.out.println("Index is Vaild");
                return;
            }
        }else {
            System.out.println("Index is Vaild");
            return;
        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == (size() - 1)) {
            removeLast();
        } else {
            removeAfter(index - 1);
        }
    }


}
