public class NewClass {
    public static void main(String args[]){
        // intialize array
        BinaryTree bt = new BinaryTree(5);
        
        // insert value in tree
        bt.insert("N1");
        bt.insert("N2");
        bt.insert("N3");
        bt.insert("N4");
        bt.insert("N5");
        bt.insert("N6");
        System.out.println();
        
        //all traversal
        bt.preOrder(1);
        System.out.println();
        bt.inOrder(1);
        System.out.println();
        bt.postOrder(1);
        System.out.println();
        bt.levelOrder();
        
        // search
        int k = bt.search("N4");
        System.out.print(k);
        
        // delete
        bt.delete("N3");
        
        // delete tree
        bt.deleteAll();
    }

}

class BinaryTree{
    String[] arr;
    int lastUsedIndex;
    
    public BinaryTree(int size){
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Binary Tree of size " + size + " has been created");
    }
    
    // check tree array is full or not
    boolean isFull(){
        if(arr.length-1 == lastUsedIndex){
            return true;
        }else{
            return false;
        }
    }
    
    // insertion in tree array
    void insert( String value){
        if(!isFull()){
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("The value of " + value + " has been inserted");
        }else{
            System.out.println("Binary tree is full");
        }
    }
    
    // preOrder traversal
    void preOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
       System.out.print(arr[index] + " ");
       preOrder(index *2);
       preOrder(index * 2 + 1);
       
    }
    
    // inOrder traversal
    void inOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
        preOrder(index *2);
        System.out.print(arr[index] + " ");
        preOrder(index * 2 + 1);
        
    }
    
    // postOrder traversal
    void postOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
       preOrder(index *2);
       preOrder(index * 2 + 1);
       System.out.print(arr[index] + " ");
      
    }
    
    // level order traversal
    void levelOrder(){
        for(int i=1; i<=lastUsedIndex; i++){
          System.out.print(arr[i] + " ");  
        }
    }
    
    // search
    int search(String value){
        for(int i=1; i<lastUsedIndex; i++){
          if(arr[i] == value){
            System.out.println("The given value find at location : " + i);
            return i;
          } 
        }
        //  System.out.println("The given value not find");
          return -1;
    }
    
    // delete given Node
    void delete(String value){
        int location = search(value);
        if(location == -1){
            return;
        }else{
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("Node delete sucessfully");
        }
    }
    
    // delete all Node
    void deleteAll(){
        try{
            arr = null;
            System.out.println("Tree has deleted sucessfully");
        }catch(Exception e){
            System.out.println("There was a problem in deleting tree");
        }
    }
}
