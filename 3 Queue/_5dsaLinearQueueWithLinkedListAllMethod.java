public class NewClass {
    public static void main(String args[]){
        Queue obj = new Queue();
        
        // insert element in queue
        obj.enqueue(5);
        obj.enqueue(9);
        obj.enqueue(1);
        
        //
    }
}

class Node{
    int value;
    Node next;
}

class Queue{
    Node head;
    Node tail;
    
    // check for empty or not
    boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }
    
    // insert element in queue
  void enqueue(int n){
      Node tempNode = new Node();
      tempNode.value = n;
      tempNode.next = null;
      if(head == null){
          head = tempNode;
          tail = tempNode;
      }else{
          tail.next = tempNode;
          tail = tempNode;
      }
  }  

  // delete element from queue
  int dequeue(){
      if(isEmpty()){
          return -1;
      }else{
          Node ret = head;
          head = head.next;
          ret.next = null;
          return ret.value;
      }
  }  
  
  // peek element
  int peek(){
      if(isEmpty()){
          return -1;
      }else{
          return head.value;
      }
  }
  
  //delete all value of queue at a time
  void deleteAll(){
      if(isEmpty()){
          System.out.println("Queue is empty already");
      }else{
          head = tail= null;
      }
  }
}
