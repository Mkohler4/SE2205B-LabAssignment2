public class LinkedListQueue<E> implements Queue<E>{
    SinglyLinkedList<E> lis = new SinglyLinkedList<>();
  public LinkedListQueue(){
  }
  public int size(){
      return lis.size();
  }
  public boolean isEmpty(){
      return lis.isEmpty();
  }
  public E first(){
      return lis.first();
  }
  public void enqueue(E node){
      lis.addLast(node);
  }
  public E dequeue(){
      return lis.removeFirst();
  }
}
