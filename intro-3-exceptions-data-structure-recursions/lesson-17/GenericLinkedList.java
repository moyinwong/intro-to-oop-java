import java.util.LinkedList;

public class GenericLinkedList<E> {
  private class Node<E> { // inner class
    E data;
    Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head; // the only instance variable of the list

  public GenericLinkedList() {

    head = null; // the list starts off empty
  }

  public boolean isEmpty() {
    return (head == null); // the list is empty if head is null
  }

  public void addToFront(E newData) {
    head = new Node<E>(newData, head);
  }

  public void addToRear(E newData) {
    Node<E> node = new Node<E>(newData, null);
    Node<E> current = head;
    if (isEmpty()) // point head to new node if list is empty
      head = node;
    else {
      while (current.next != null) { // the last node is the one with next = null
        current = current.next;
      }
      current.next = node;
    }
  }

  public String toString() {

    Node<E> current = head; // traversal starts at the front
    String result = ""; // result starts empty

    while (current != null) { // keep going until there's no more nodes to point to
      result = result + current.data.toString() + "\n";
      current = current.next; // move over to next node
    }
    return result;
  }

  public boolean contains(E target) {
    if (isEmpty()) { // empty lists can't contain the target
      return false;
    }

    boolean found = false;
    Node<E> current = head; // traversal starts at the front

    while ((current != null) && (!found)) {
      if (target.equals(current.data)) {
        found = true;
      } else {
        current = current.next;
      }
    }
    return found;
  }

  public static void main(String[] args) {
    GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
    favBabySongs.addToFront("Humpty Dumpty");
    favBabySongs.addToRear("Swing Low Sweet Chariot");
    favBabySongs.addToFront("Itsy Bitsy Spider");
    favBabySongs.addToRear("Twinkle, Twinkle Little Star");
    favBabySongs.addToFront("Wheels on the Bus");
    System.out.println(favBabySongs.toString());
    favBabySongs.removeFromFront();
    favBabySongs.removeFromRear();
    System.out.println(favBabySongs.toString());
    System.out.println(favBabySongs.contains("Humpty Dumpty"));
    System.out.println(favBabySongs.contains("Baby Shark"));

    LinkedList<Integer> list = new LinkedList<>();

    list.a
  }

  public E get(E target) {
    Node<E> current = head;

    while (current.next != null) {
      if (current.data.equals(target)) {
        return current.data;
      }
      current = current.next;
    }
    return null;
  }

  public E removeFromFront() {
    if (isEmpty()) {
      return null;
    }
    E front = head.data;
    head = head.next;
    return front;
  }

  public E removeFromRear() {
    if (isEmpty()) {
      return null;
    }

    if (head.next == null) {
      E rear = head.data;
      head = null;
      return rear;
    }
    Node<E> current = head;

    while (current.next.next != null) {
      current = current.next;
    }

    E rear = current.next.data;
    current.next = null;
    return rear;
  }

}
