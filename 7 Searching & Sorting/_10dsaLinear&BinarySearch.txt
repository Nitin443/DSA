public class NewClass {
    public static void main(String args[]){
        Search s = new Search();
        int arr[]  = {43,64,33,54,223,54,6,43,7};
        s.linearSearch(arr, 33);
        
        int a[]  = {23,44,55,66,75,77,88,99};
         s.binarySearch(a, 66);
    }
}

class Search{
    
    void linearSearch(int arr[], int value){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value){
                System.out.println("Value found : " + value);
                return;
            }
        }
       System.out.println("Value not found : " + value);
       return;
    }
    
    void binarySearch(int arr[], int value){
        int start = 0;
        int end = arr.length-1;
        int middle = (start+end)/2;
        System.out.println(start + " " + middle + " " + end);
        
        while(arr[middle] != value && start <= end){
            if(value < arr[middle]){
                end = middle-1;
            }else{
                start = middle+1;
            }
            middle = (start+end)/2;
            System.out.println(start + " " + middle + " " + end);
        }
        
        if(arr[middle] == value){
            System.out.println("Value  found : " + value + " at position : " + middle);
        }else{
            System.out.println("Value not found : " + value);
        }
    }
}
