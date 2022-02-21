public class NewClass {
    public static void main(String args[]){
        // initialize queue in memory using constructor
       Queue obj = new Queue(3);
       
       // check queue is full or not
       boolean a = obj.isFull();
       System.out.println(a);
       
       // check queue is empty or not
       boolean b = obj.isEmpty();
       System.out.println(b);
       
       // insert value in queue
       obj.enqueue(5);
       obj.enqueue(6);
       obj.enqueue(9);
       obj.enqueue(5);
       
        // delete value from queue
        int c = obj.dequeue();
        System.out.println(c);
       
       // peek value of queue 
        int d = obj.peek();
        System.out.println(d);
        
        // delete all value of queue
        obj.delete();
    }
}


class Queue {
    int arr[];
    int front, rear;
    
    // initialize queue in memory using constructor
       Queue(int size){
         this.arr = new int[size];
         rear = front = -1;
         System.out.println("Queue is created of size : " + size);
    }
       
   // check queue is full or not
       boolean isFull(){
           if(rear == arr.length-1){
               return true;
           }else{
               return false;
           }
       }
     
      // check queue is empty or not
       boolean isEmpty(){
           if(front == -1 || front == arr.length){
               return true;
           }else{
               return false;
           }
       }  
       
      // insert value in queue
       void enqueue(int n){
           if(isFull()){
               System.out.println("Queue is full");
           }else if(isEmpty()){
               front = 0;
               rear++;
               arr[rear] = n;
               System.out.println("The value is insert in queue : " + n);
           }else{
               rear++;
               arr[rear] = n;
               System.out.println("The value is insert in queue : " + n);               
           }
       }
       
       // delete value from queue
       int dequeue(){
          if(isEmpty()){
              return -1;
          }else if(front == arr.length-1){
              int k = arr[front];
             arr[front] = 0;
              front = rear = -1;
              System.out.println(" The last value of queue has delete");
              return k;
          }else{
              int k = arr[front];
              arr[front] = 0;
              front++;
              System.out.println(" The  value of queue has delete");
              return k;
          }
       }
       
       //return peek value of queue
       int peek(){
          if(isEmpty()){
              return -1;
          }else{
              int k = arr[front];
              System.out.println("The peek value of queue : ");
              return k;
          }           
       }
      
       // delete all queue value
       void delete(){
          if(isEmpty()){
            System.out.println("Queue is already empty");  
          }else{
              arr = null;
              System.out.println("Queue all value has deleted");
              
          }           
       }
}
