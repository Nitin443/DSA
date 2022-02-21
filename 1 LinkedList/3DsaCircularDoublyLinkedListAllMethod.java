public class NewClass {
    public static void main(String args[]){
       circularDoublyLinkedList obj = new circularDoublyLinkedList(); 
        // 1 create circular doubly linked list
        System.out.println("create circular doubly linked list !");
      //  obj.createCDLL(5);
       obj.createCircularDoublyLinkedList(5);
       
                // 2 insertion in Circular doubly linked list
         System.out.println("insertion in  Circulardoubly linked list !");
         obj.insertionInCircularDoublyLinkedList(23, 1); // location start from 0
         obj.insertionInCircularDoublyLinkedList(44, 2);
         obj.insertionInCircularDoublyLinkedList(67, 3);
        obj.insertionInCircularDoublyLinkedList(74, 2);
         obj.insertionInCircularDoublyLinkedList(98, 1);
 
         // 3 traversing in Circular Doubly linked list
         System.out.println("traverse in Circular doubly linked list !");
        obj.traverseInCircularDoublyLinkedList();
         
         // 4 Reverse order traversing in  Doubly linked list
         System.out.println(" Reverse order traverse in Circular doubly linked list !");
         obj.reverseOrderTraverseInCircularDoublyLinkedList();
         
          // 5  searching in circular Doubly linked list
          System.out.println(" Searching in circular doubly linked list !");
          obj.searchIncircularDoublyLinkedList(67);
          
           // 6 Deletion  in doubly linked list
          System.out.println(" Deletion in Circular doubly linked list !");
          obj.deletionInCircularDoublyLinkedList(2);
          obj.deletionInCircularDoublyLinkedList(3);
          obj.traverseInCircularDoublyLinkedList(); 
          
           // 7. delete entire doubly linked list
          obj.deleteEntireCircularDoublyLinkedList();
          obj.traverseInCircularDoublyLinkedList();  
          System.out.println("Sucessfully  Deleted Entire Circular doubly linked list ! "); 
      
       
    }
}


class Node{ // crate node data type by class
    int value;
    Node next;
    Node prev;
}


class circularDoublyLinkedList{
    Node head;
    Node tail;
    int size;
    
     // create circular doubly linked list
    void createCircularDoublyLinkedList(int nodeValue){ // time complexity = O(1)
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        node.prev = node;
        head = node;
        tail = node;
        size = 1;
        
    }
    
         // insertion in circular doubly linked list
    void insertionInCircularDoublyLinkedList(int insertValue, int location){ // time complexity = O(n)
        Node node = new Node();
        node.value = insertValue;
        if(head == null){// insertion in empty list
          createCircularDoublyLinkedList(insertValue);  
        }else if(location == 0){ // insertion at beginning
           // Node tempNode = head;
            node.next = head;
            node.prev = tail;
            head.prev = node;
            head = node;
            tail.next = head;
        }else if(location >= size){  // insertion at last position
            tail.next  = node;
            node.prev = tail;
            node.next = head;
            head.prev = node;
            tail = node;
        }else{
            Node tempNode = head;
            for(int i=0; i<location-1; i++){
                tempNode = tempNode.next;
            }
              node.prev = tempNode;
              node.next = tempNode.next;
              tempNode.next.prev = node;
              tempNode.next = node;
             
        }
           size++; 
    }
    
        //  traversing in circular Doubly linked list
    void traverseInCircularDoublyLinkedList(){       // time complexity = 0(n)
        Node tempNode = head;
        if(head == null){
            System.out.println("Circular Doubly linked list is empty !");
        }else{
            for(int i=0; i<size; i++){
              System.out.print(tempNode.value + " ");
              tempNode = tempNode.next;
            }
        }
        System.out.println();
    }
    
         //  traversing in reverse order in circular Doubly linked list
        void reverseOrderTraverseInCircularDoublyLinkedList(){       // time complexity = 0(n)
        Node tempNode = tail;
        if(head == null){
            System.out.println(" Circular Doubly linked list is empty !");
        }else{
            for(int i=0; i<size; i++){
              System.out.print(tempNode.value + " ");
              tempNode = tempNode.prev;
            }
        }
        System.out.println();
    }
        
                //  searching in circular Doubly linked list
        void searchIncircularDoublyLinkedList(int searchValue){       // time complexity = 0(n) 
            if(head == null){
                System.out.println("circular Doubly linked list is empty");
                return;
            }else{
                Node tempNode = head;
                for(int i=0; i<size; i++){
                    if(tempNode.value == searchValue){
                       System.out.println(searchValue + "  found at position  " + i); 
                       return;
                    }
                    tempNode = tempNode.next;
                }
                System.out.println(" Search value not found in Circular Doubly linked list !");
            }
        }
        
            //  Deletion  in  Doubly linked list
        void deletionInCircularDoublyLinkedList(int location){       // time complexity = 0(n) 
              Node tempNode = head;
            if(head == null){
                  System.out.println("Doubly Circular linked list is empty");  
               }else if(location == 0){   //  Deletion  at start position
                 tempNode.next.prev = tail;
                 head = tempNode.next;
                 size--;
                 if(size == 0){
                     head = tail = null;
                 }
                 
               }else if(location >= size){   //  Deletion  at last position
                   for(int i=0; i<size-1; i++){
                       tempNode = tempNode.next;
                   }
                   if(tempNode == head){  // if only one node in list then follow that condition
                       head.next = null;
                       head = tail = null;
                       size--;
                       return;
                   }else{
                       tempNode.next = tail;
                       tail = tempNode;
                       size--;
                   }
               }else{
                 //  Node tempNode = head;
                   for(int i=0; i<location-1; i++){ // deletion at any random position
                       
                       tempNode = tempNode.next;
                   }
                   tempNode.next.next.prev = tempNode;
                   tempNode.next = tempNode.next.next;
                   
                   size--;
               }
        }
        
        
        void deleteEntireCircularDoublyLinkedList(){    // time complexity = 0(1)
                Node tempNode = head;
           for (int i=0; i<size; i++) {
               tempNode.prev = null;
               tempNode = tempNode.next;
    }
                head = null;
                tail = null;
         System.out.println("The CDLL has been deleted!");
        
}
    
    
}
