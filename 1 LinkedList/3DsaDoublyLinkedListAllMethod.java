public class NewClass {
    public static void main(String args[]){
        doublyLinkedList obj = new doublyLinkedList();
        
        // 1 create doubly linked list
        System.out.println("create doubly linked list !");
        obj.createDoublyLinkedList(5);
     
         // 2 insertion in doubly linked list
         System.out.println("insertion in doubly linked list !");
         obj.insertionInDoublyLinkedList(23, 0); // location start from 0
         obj.insertionInDoublyLinkedList(44, 1);
         obj.insertionInDoublyLinkedList(67, 2);
         obj.insertionInDoublyLinkedList(74, 45);
         obj.insertionInDoublyLinkedList(98, 1);
 
         // 3 traversing in Doubly linked list
         System.out.println("traverse in doubly linked list !");
         obj.traverseInDoublyLinkedList();
         
         // 4 Reverse order traversing in Doubly linked list
         System.out.println(" Reverse order traverse in doubly linked list !");
         obj.reverseOrderTraverseInDoublyLinkedList();
         
         // 5  searching in  Doubly linked list
          System.out.println(" Searching in doubly linked list !");
          obj.searchInDoublyLinkedList(44);
          
          // 6 Deletion  in doubly linked list
          System.out.println(" Deletion in doubly linked list !");
          obj.deletionInDoublyLinkedList(2);
          obj.deletionInDoublyLinkedList(3);
          obj.traverseInDoublyLinkedList(); 
          
          // 7. delete entire doubly linked list
          obj.deleteEntireDoublyLinkedList();
          obj.traverseInDoublyLinkedList();  
          System.out.println("Sucessfully  Deleted Entire doubly linked list ! "); 
    }
}


class Node{
    int value;
    Node next;
    Node prev;
}

class doublyLinkedList{
    Node head;
    Node tail;
    int size;
    
    // create doubly linked list
    void createDoublyLinkedList(int nodeValue){ // time complexity = O(1)
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
        size = 1;
        
    }
    
     // insertion in doubly linked list
    void insertionInDoublyLinkedList(int insertValue, int location){ // time complexity = O(n)
        Node node = new Node();
        node.value = insertValue;
        if(head == null){// insertion in empty list
          createDoublyLinkedList(insertValue);  
        }else if(location == 0){ // insertion at start position
            Node tempNode = head;
            node.prev = null;
            node.next = tempNode;
            tempNode.prev = node;
            head = node;
        }else if(location >= size){ // insertion at last position
            Node tempNode = tail;
            node.next = null;
            node.prev = tempNode;
            tempNode.next = node;
            tail = node;
        }else{
           Node tempNode = head; // insertion at random position
           int index = 0;
           while(index < location -1){
             tempNode = tempNode.next;
             index++;
           }
           node.prev = tempNode;
           node.next = tempNode.next;
           tempNode.next.prev = node;
           tempNode.next = node;
          
        }
        size++;
    }
   
    //  traversing in Doubly linked list
    void traverseInDoublyLinkedList(){       // time complexity = 0(n)
        Node tempNode = head;
        if(head == null){
            System.out.println("Doubly linked list is empty !");
        }else{
            for(int i=0; i<size; i++){
              System.out.print(tempNode.value + " ");
              tempNode = tempNode.next;
            }
        }
        System.out.println();
    }
    
     //  traversing in reverse order in  Doubly linked list
        void reverseOrderTraverseInDoublyLinkedList(){       // time complexity = 0(n)
        Node tempNode = tail;
        if(head == null){
            System.out.println("Doubly linked list is empty !");
        }else{
            for(int i=0; i<size; i++){
              System.out.print(tempNode.value + " ");
              tempNode = tempNode.prev;
            }
        }
        System.out.println();
    }
        
        //  searching in  Doubly linked list
        void searchInDoublyLinkedList(int searchValue){       // time complexity = 0(n) 
            if(head == null){
                System.out.println("Doubly linked list is empty");
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
                System.out.println(" Search value not found in Doubly linked list !");
            }
            
        }
        
            //  Deletion  in  Doubly linked list
        void deletionInDoublyLinkedList(int location){       // time complexity = 0(n) 
              Node tempNode = head;
            if(head == null){
                  System.out.println("Doubly linked list is empty");  
               }else if(location == 0){   //  Deletion  at start position
                 tempNode.next.prev = null;
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
                       tempNode.next = null;
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
        
        void deleteEntireDoublyLinkedList(){    // time complexity = 0(n)
           Node tempNode = head;
         for (int i=0; i<size; i++) {
              tempNode.prev = null;
              tempNode = tempNode.next;
         }
           head = null;
           tail = null;
            System.out.println("The DLL has been deleted!");
    }   
}
