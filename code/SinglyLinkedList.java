public class SinglyLinkedList<E>{
Node<E> head = null;
Node<E> tail = null;
int size = 0;
  private static class Node<E>{
    E element = null;
    Node<E> next = null;
    public Node(E e, Node<E> n){
      element = e;
      next = n;
    }
    public E getElement(){
      return element;
    }
    public Node<E> getNext(){
      return next;
    }
    public void setNext(Node<E> n){
      next = n;
    }
  }
  
  public SinglyLinkedList(){

  }
  
  public int size(){
    return this.size;
  }
  
  public boolean isEmpty(){
    if(this.size == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public E first(){
    return head.element;
  }
  
  public E last(){
    return tail.element;
  }
  
  public void addFirst(E element){
    head = new Node(element, head);
    if(this.size == 0)
    {
      tail = head;
    }
    this.size++;
  }
  
  public void addLast(E element){
    Node<E> node = new Node(element, null);
    if(size == 0)
    {
      tail = node;
      head = node;
    }
    else
    {
      tail.next = node;
      tail = node;
    }
    this.size++;
  }
  
  public E removeFirst(){
    if(size == 0)
    {
      return null;
    }
    else {
      E temp = head.element;
      head = head.next;
      --size;
      return temp;
    }
  }

}