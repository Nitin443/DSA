public class NewClass {
    public static void main(String args[]){
        // creating object of stack class and initialized size of array using constructor
        Stack obj = new Stack(5);
         // check for stack is empty or not
      boolean val =   obj.isEmpty();
      System.out.println("The stack is empty or not : " + val);
       // check for stack is full or not
      boolean val1 =   obj.isFull();
       System.out.println("The stack is full or not : " + val1);
       // push element in stack
       obj.push(9);
       obj.push(4);
       obj.push(13);
       
       //pop element in stack
       obj.pop();
       // peek element of stack
       int n = obj.peek();
       System.out.println("The peek value of stack is : " + n);
       // print all values of stack
       obj.traverse();
       // deleted all stack values at a time
       obj.delete();
       obj.traverse();
    }
}

class Stack{
    int[] arr;
    int topOfStack;
    
    // initialized array size
    Stack(int size){      // using constructor
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The Stack is created with size : " + size);
    }
    
    // check for stack is empty or not
    boolean isEmpty(){
        if(topOfStack == -1){
            return true;
        }else{
            return false;
        }
    }
    
    // check for stack is full or not
    boolean isFull(){
        if(topOfStack == arr.length - 1 ){
            return true;
        }else{
            return false;
        }
    }
    
    // push method
    void push(int n){
        if(isFull()){
            System.out.println("The stack is full");
        }else{
        arr[topOfStack + 1] = n;
          topOfStack++;
        System.out.println("Inserted vaule in stack : " + arr[topOfStack]);
        }
    }
    
    // pop method
      int pop(){
         if(isEmpty()){
           System.out.println("The stack is full"); 
           return 0;
         }else{
        int deleteValue = arr[topOfStack];
        topOfStack--;
        System.out.println("the delete value is : " + deleteValue);
        return deleteValue;
         }
    }
    
    // peek method that only return last insert value in stack
      int peek(){
          if(isEmpty()){
              System.out.println("The stack is empty"); 
              return -1;
          }else{
          int peekValue = arr[topOfStack];
          return peekValue;
          }
      }
    
      // delete all stack values at a time
      void delete(){
         topOfStack = -1;
         arr = null;
         System.out.println("The stack all values sucessfully deleted");
      }
      
      // print all value of stack
      void traverse(){
           for(int i=0; i<=topOfStack; i++){
              System.out.print(arr[i] + " ");
          }
           System.out.println();
      }
    
}
