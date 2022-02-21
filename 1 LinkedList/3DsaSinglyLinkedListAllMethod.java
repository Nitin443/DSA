public class NewClass {
    public static void main(String args[]){
        SinglyLinkedList obj = new SinglyLinkedList();
        
        // 1 create singly linked list
        obj.createSinglyLinkedList(5); // time complexity of that function = 0(1)
       //  System.out.println(obj.head.value);
       //  System.out.println(obj.size);
         
       //  2  insert in singly linked list
         obj.insertInLinkedList(8,1);
         obj.insertInLinkedList(55,1); // it insert value at location 1 at which 8 was present. so 8 remove to next position and 55 set at location 1
      //   System.out.println(obj.head.next.value);
         obj.insertInLinkedList(2,3);
         obj.insertInLinkedList(4,4);
         obj.insertInLinkedList(9,5);
      //   System.out.println(obj.tail.value);
      
      // 3  traverse singly linked list
         obj.traverseSinglyLinkedList();
         
      // 4   search in singly linked list
      obj.searchNodeValue(8);
      
      // 5   Deletion in singly linked list
      obj.deletionOfNode(3); // deletion node of location 3
      
      obj.traverseSinglyLinkedList();

      // 6 delete entire linked list
      obj.deleteAllNode(); 
      
      obj.traverseSinglyLinkedList();
    
    }
    
}

class Node{ // creating Node data type by class
    int value;
    Node next;
}

class SinglyLinkedList{
    Node head;
    Node tail;
    int size;
    
    // singly linked list creation function
    void createSinglyLinkedList( int nodevalue){ // time complexity = O(1)
        Node node = new Node(); // it's a new node in which node value store
        node.next = null;
        node.value = nodevalue;
        head = node;
        tail = node;
        size = 1;
      //  return head;
    }
    
    // all type //  insertion function of linked list
    void insertInLinkedList(int nodeValue, int location){ // time complexiy = O(n)
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){ // if our linked list have no node then it will create new linked list.
            createSinglyLinkedList(nodeValue);
            return;
        }else if(location == 0){ // if we want to insert new value at begning of node then location should = 0
          node.next = head;                       // this method insert the new node value at begning
          head = node;
        }else if(location >= size){ // if we want to insert new node value in last of linked list then location 
         node.next = null;                           // should equal to size of linked list(in this case we know already size value of linked list)
         tail.next = node;                           // if we have not value of size then we run loop until last node then insert value at end of linked list
         tail = node;
        }else{// if we want to insert node value in between locations of linked list anywhere
         Node tempNode = head;                     // it insert the value at(not before or after) given location
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
    
    // Traversing function of linked list
    void traverseSinglyLinkedList(){  // time complexity = O(n)
        if(head == null){
           System.out.println("Singly linked list is empty"); 
        }else{
            Node tempNode = head;
            for(int i=0; i<size; i++){// if we donn't know size value then we will run while loop until tempNode.next != null
             System.out.print(tempNode.value + " ");           // like as while(tempNode.next !=null)
              tempNode = tempNode.next;
            }
            System.out.println(); 
        }
    }
    
      // Searching function of linked list
    boolean searchNodeValue(int searchValue){ // time complexity = O(n)
        if(head == null){
          System.out.println("Singly linked list is empty");    
            return false;
        }else{
            Node tempNode = head;
            for(int i=0; i<size; i++){// if we donn't know size value then we will run while loop until tempNode.next != null
             if(tempNode.value == searchValue){   // like as while(tempNode.next !=null)
                  System.out.println("value found at position : " + i); 
                 return true;
             }
             tempNode = tempNode.next;
            }
            
        }
        System.out.println("Search Value not found !");  
        return false;
    }
    
      // Deletion function of linked list
    void deletionOfNode(int location){ // time complexity = O(n)
        if(head == null){ // if our linked list have no node
        System.out.println("Singly linked list is empty"); 
        }else if(location == 0){ // if we want to delete first node
            head = head.next;
            size--;
            if(size == 0){// if we want to delete first node and our linked list have only one node then set also tail = null
                tail = null;
            }
        }else if(location >= size){ // if we want to delete last node
            Node tempNode = head;
            for(int i=0; i<size-1; i++){
               tempNode = tempNode.next;
            }
            if(tempNode == head){// if we want to delete last node and our linked list have only one node then set also head = null
                tail = head = null;
                 size--;
                 return;
            }
            tempNode.next = null;
            size--;
        }else{ // if we want to delete any ramdom position node of linked list
           Node tempNode = head;
           for(int i=0; i<location-1; i++){
               tempNode = tempNode.next; 
           }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }


     // Deletion entire  linked list
    void deleteAllNode(){
        head = null;
        tail = null;
        System.out.println("All node delete sucessfully"); 
        
        
    }
    
}    
   
