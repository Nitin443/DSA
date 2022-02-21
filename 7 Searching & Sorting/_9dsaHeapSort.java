public class NewClass {
   public static void main(String args[]){
       // int[] arr = new int[9];
      int arr[] = {45, 33, 23,88,99,43,76,100};
       HeapSort hs = new HeapSort(arr);
       hs.heapSort();
       hs.levelOrder();
   } 
}

class HeapSort{
    
    int arr[] = null;
    
    HeapSort(int[] arr){
        this.arr = arr;
    }
    
    void heapSort(){
        int[] brr = new int[9];
        int n = arr.length+1;
        
        //  step -1 insert function use
       BinaryHeap bh = new BinaryHeap(n);
       for(int i=0; i<arr.length; i++){
           bh.insert(arr[i], "min");
       }
       
       System.out.println("******************");
       // step 2 extract method use for store value in short order
       for(int i=0; i<arr.length; i++){
         arr[i] =   bh.extract("min");
       }
       
    }
    
    // display value
    void levelOrder(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    
}






// Binary heap class used for insertion and extraction

class BinaryHeap{
    int arr[];
    int sizeOfTree;
    
    BinaryHeap(int size){
        arr = new int[size];
        this.sizeOfTree = 0;
    }
    
    // check for empty
    boolean isEmpty(){
        if(sizeOfTree == 0){
            return true;
        }else{
            return false;
        }
    }
    
    // peek method
    Integer peek(){
        if(isEmpty()){
            System.out.println("Binary heap is empty");
            return null;
        }
        return arr[1];
    }
    
    // ****
    int sizeOfBinaryHeap(){
        return sizeOfTree;
    }
    
    // traverse level order
    void levelOrder(){
        for(int i=1; i<=sizeOfTree; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Heapify to insert [ Heapify Bottom to Top]
    void heapifyBottomToTop(int index, String heapType){
        int parent = index / 2;
        if(index <= 1){
            return;
        }
        
        if("min".equals(heapType)){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }else if("max".equals(heapType)){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
    }
    
    void insert(int value , String heapType){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println("Value " + value + "inserted sucessfully");
    }
    
     // Heapify to delete [ Heapify Top to Bottom]
    void heapifyTopToBottom(int index, String heapType){
        int left = index*2;
        int right = index*2 + 1;
        int swapChild = 0;
        
        if(sizeOfTree < left){
            return;
        }
        
        if("max".equals(heapType)){
            if(sizeOfTree == left){ // if it's have one child
                if(arr[index] < arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else {          // if it's have two child
                if(arr[left] > arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }
                if(arr[index] < arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }else if("min".equals(heapType)){
            if(sizeOfTree == left){ // if it's have one child
                if(arr[index] > arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else {          // if it's have two child
                if(arr[left] < arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }
                if(arr[index] > arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }
    
    // extract node from heap
    int extract(String heapType){
        if(isEmpty()){
            return -1;
        }else{
           int extractValue = arr[1];
           arr[1] = arr[sizeOfTree];
           sizeOfTree--;
           heapifyTopToBottom(1, heapType);
           return extractValue;
        }
    }
    
    // delete entire heap
    void delete(){
        arr = null;
        System.out.println("Binary Heap deleted sucessfully");
    }
}
