public class NewClass {
    public static void main(String args[]){
        circularSinglyLinkedList obj = new circularSinglyLinkedList();
        // 1 ceate  circular Singly Linked List
        System.out.println("ceate  circular Singly Linked List"); 
        obj.createCircularSinglyLinkedList(4);
      //  System.out.println(obj.head.value);
      
      // 2 insertion in circular Singly Linked List
      System.out.println("insertion  circular Singly Linked List"); 
        obj.insertInCircularLinkedList(43, 1);
        obj.insertInCircularLinkedList(12, 2);
        obj.insertInCircularLinkedList(33, 3);
        obj.insertInCircularLinkedList(6, 77);
        obj.insertInCircularLinkedList(56, 400);
        obj.insertInCircularLinkedList(67, 46);
        obj.insertInCircularLinkedList(1, 654);
        
        // 3 Traversing in circular Singly Linked List
        System.out.println("traverse  circular Singly Linked List"); 
        obj.traverseInCircularLinkedList();
       obj.traverseInCircularLinkedList2();
       
       // 4 Searching in circular Singly Linked List
       System.out.println("search  circular Singly Linked List"); 
       obj.searchInCircularLinkedList(56);
       
      // 5 Deletion in circular Singly Linked List
      System.out.println("deletion  circular Singly Linked List"); 
      obj.deletionInCircularLinkedList(4); // location start from 0
      obj.deletionInCircularLinkedList(2);
      obj.deletionInCircularLinkedList(1);
      obj.deletionInCircularLinkedList(34);
      obj.traverseInCircularLinkedList();
      obj.traverseInCircularLinkedList2();
      
      // 6 Deletion of entire  circular Singly Linked List
     // obj.deleteAllCircularLinkedListTogether();
      //obj.traverseInCircularLinkedList2();
    }
    
    
}

class Node{ // creating Node data type by class
    int value;
    Node next;
}

class circularSinglyLinkedList{
    Node head;
    Node tail;
    int size;
    
     // circular linked list creation function
    void createCircularSinglyLinkedList( int nodevalue){ // time complexity = O(1)
        Node node = new Node(); // it's a new node in which node value store
        node.value = nodevalue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
      
    }
    
    // all type //  insertion function of linked list
    void insertInCircularLinkedList(int nodeValue, int location){ // time complexity = O(n)
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){ // when linked list is empty
          createCircularSinglyLinkedList(nodeValue);
          return;
        }else if(location == 0){// insertion at beginning
            node.next = head;
            head = node;
            tail.next = head;
        }else if(location >= size){ // insertion at last position
         tail.next = node;
         tail = node;
         tail.next = head;
        }else{ // insertion at any random position
          Node tempNode = head;
          int index = 0;
          while(index < location-1){
              tempNode = tempNode.next;
              index++;
          }
          node.next = tempNode.next;
          tempNode.next = node;
        }
        size++;
    }
    
    // traversing in circular  linked list
    void traverseInCircularLinkedList(){ // time complexity = O(n)
        Node tempNode = head;
        if(head == null){
           System.out.println("Singly linked list is empty"); 
        }else{
           for(int i=0; i<size; i++){ // when we know size of linked list(already know no of node)
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
            } 
        }
        
        System.out.println();
    }
    
        void traverseInCircularLinkedList2(){ // time complexity = O(n)
        Node tempNode = head;
         if(head == null){
           System.out.println("Singly linked list is empty"); 
        }else{
             while(tempNode.next != head ){ // when we donnot know no. of node(size) in linked list then use this method 
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        } 
           //  System.out.print(tempNode.value + " ");
             System.out.println();
         }
    }
        
        void searchInCircularLinkedList(int searchValue){ // time complexity = O(n)
            Node tempNode = head;
                if(head == null){
                System.out.println("Singly linked list is empty");    
                }else if(head != null){
                    for(int i=0; i<size; i++){ // when we know size of linked list(already know no of node)
                        if(tempNode.value == searchValue){
                       System.out.println(searchValue + " at position " + i); 
                        return;
                        }
                        tempNode = tempNode.next;
                    }
                }else{
                    System.out.println("value not found !");
                }
            
        }
      
        void deletionInCircularLinkedList(int location){ // time complexity = O(n)
            if(head == null){
              System.out.println("Singly linked list is empty");   
              return;
            }else if(location == 0){// if we want to delete first node
            head = head.next;
            tail.next = head;
            size--;
            if(size == 0){
                tail = null;
                head.next = null;
                head = null;
            }
        }else if(location >= size){// if we want to delete last node
            Node tempNode = head;
            for(int i=0; i<size-1; i++){
                tempNode = tempNode.next;
            }
            if(tempNode == head){// if we want to delete last node and in linked list have only one node then folllow that condition
               head.next = null;
                head = tail = null;
               size--;
               return;
            }else{
                tempNode.next = head;
                tail = tempNode;
                size--;
               
            }
        }else{// if we want to delete any ramdom position node of linked list
            Node tempNode = head;
            for(int i=0; i<location-1; i++){
               tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
        
   void deleteAllCircularLinkedListTogether(){  // time complexity = O(1)
       head.next = null;
       tail = null;
       head = null;
       System.out.println("Sucessfully deleted entire circular linked list");
   }
       
        
}    
