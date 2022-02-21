public class NewClass {
    public static void main(String args[]){
        Stack obj = new Stack();
        
        //push element in stack 
        obj.push(3);
        obj.push(2);
        obj.push(7);
        
        // traverse the stack
        obj.traverse();
        
        // delete element from stack
        int l = obj.pop();
        System.out.println("the delete value : " + l);
        
        // check for stack is empty or not
       boolean g =  obj.isEmpty();
       System.out.println(g);
       
       // return the peek element value
      int i =  obj.peek();
      System.out.println("The peek value of stack : " + i);
      
      // delete all value of stack at a time
      obj.delete();
      obj.traverse();
      
    }
}

class Node{
    int value;
    Node next;
}

class Stack{
   Node head;
   
   // push element in stack
   void push(int value){
       Node tempNode = new Node();
       if(head == null){
       tempNode.value = value;
       tempNode.next = null;
       head = tempNode;
       }else{
         tempNode.value = value;
         tempNode.next = head;
         head = tempNode;
       }
    }
   
   // delete element in stack
    int pop(){
       if(isEmpty()){
         return -1;   
       }else{
           Node tempNode = head;
           head = head.next;
           tempNode.next = null;
           return tempNode.value;
       }
     }
    
    // check for element is empty or not
    boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }
    
    // peek element of stack that only return value, will not deleted value
    int peek(){
        if(isEmpty()){
            return -1;
        }else{
            return head.value;
        }
    }
    
    // delete all value of stack at a time
    void delete(){
        head =  null;
    }
    
    // traverse the stack
    void traverse(){
        Node tempNode = head;
        if(isEmpty()){
            System.out.println("stack is empty");
        }else{
        while(tempNode != null){
            System.out.println(tempNode.value + " ");
            tempNode = tempNode.next;
        }
        }
    }
}
