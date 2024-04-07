import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public void addAtIndex(T data, int index) {
    if (index < 0 || index > this.size) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    if (data == null) {
      throw new IllegalArgumentException("You cannot add null data to the list");
    }

    if (index == 0) {
      this.head = new Node<T>(data, head);

      if (this.size == 0) {
        this.tail = head;
      }
    } else if (index == this.size) {
      Node<T> nextTail = new Node<T>(data);

      if (this.tail != null) {
        this.tail.setNext(nextTail);
      }
      this.tail = nextTail;
    } else {
      int currentIndex = 0;
      Node<T> current = this.head;
      Node<T> prev = this.head;

      while (currentIndex < index) {
        if (currentIndex == index - 1) {
          prev = current;
        }
        current = current.getNext();
        currentIndex++;
      }

      Node<T> nodeToAdd = new Node<T>(data, current);
      prev.setNext(nodeToAdd);
    }

    this.size++;

  }

  @Override
  public T getAtIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    int currentIndex = 0;
    Node<T> current = head;
    while (currentIndex < index) {
      current = current.getNext();
      currentIndex++;
    }

    return current.getData();
  }

  @Override
  public T removeAtIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    Node<T> nodeToBeRemoved = head;
    if (index == 0) {
      nodeToBeRemoved = this.head;
      this.head = this.head.getNext();

      if (this.size == 1) {
        this.tail = null;
      }
    } else if (index == this.size - 1) {
      int currentIndex = 0;
      Node<T> current = head;
      while (currentIndex < index - 1) {
        current = current.getNext();
        currentIndex++;
      }

      nodeToBeRemoved = current.getNext();
      current.setNext(null);
      this.tail = current;
    } else {
      int currentIndex = 0;
      Node<T> prev = head;
      Node<T> current = head;

      while (currentIndex < index) {
        if (currentIndex == index - 1) {
          prev = current;
        }
        current = current.getNext();
        currentIndex++;
      }

      nodeToBeRemoved = current;
      prev.setNext(current.getNext());
    }

    this.size--;
    return nodeToBeRemoved.getData();
  }

  @Override
  public T remove(T data) {
    if (data == null) {
      throw new IllegalArgumentException("You cannot remove null data from the list");
    }

    Node<T> current = head;
    int currentIndex = 0;
    Integer foundIndex = null;

    while (current != null && foundIndex == null) {
      if (current.getData().equals(data)) {
        foundIndex = currentIndex;
      }
      current = current.getNext();
      currentIndex++;
    }

    if (foundIndex == null) {
      throw new NoSuchElementException("The data is not present in the list.");
    }
    return removeAtIndex(foundIndex);
  }

  @Override
  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  public Node<T> getHead() {
    return this.head;
  }

  public Node<T> getTail() {
    return this.tail;
  }

  @Override
  public String toString() {
    String res = "";
    Node<T> current = head;
    while (current != null) {
      res += current.getData().toString() + "\n";
      current = current.getNext();
    }
    return res;
  }

  // public static void main(String[] args) {
  // LinkedList<Integer> list = new LinkedList<>();
  // list.addAtIndex(0, 0);
  // list.addAtIndex(1, 1);
  // list.addAtIndex(2, 2);
  // list.addAtIndex(3, 3);
  // list.addAtIndex(4, 4);
  // list.addAtIndex(5, 5);
  // list.addAtIndex(6, 6);
  // list.addAtIndex(7, 7);
  // list.addAtIndex(8, 8);
  // list.addAtIndex(9, 9);

  // System.out.println("after adding: ");
  // System.out.println(list);

  // list.removeAtIndex(5);

  // System.out.println("after removing 5");
  // System.out.println(list);

  // list.addAtIndex(10, 9);
  // System.out.println("after adding 10");
  // System.out.println(list);

  // Integer ele = list.getAtIndex(5);
  // System.out.println("getting at index 5: " + ele);

  // list.remove(10);
  // System.out.println("after removing element 10");
  // System.out.println(list);
  // }
}
