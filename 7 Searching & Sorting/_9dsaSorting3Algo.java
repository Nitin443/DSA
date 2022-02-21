public class NewClass {
    public static void main(String args[]){
       Sort sort = new Sort();
       int arr[]  = {87,33,65,35,98,2,54};
     //  sort.bubbleSort(arr);
       // sort.display(arr); 
      //  sort.selectionSort(arr);
      //  sort.display(arr); 
      //  sort.insertionSort(arr);
      //  sort.display(arr); 
    }
}



class Sort{
    
    // bubble sort
    void bubbleSort(int arr[]){        // time com = O(n^2) & space = O(1)
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    // selection sort
    void selectionSort(int arr[]){  // time com = O(n^2) & space = O(1)
        int n = arr.length;
        for(int i=0; i<n; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
               int temp = arr[i];
               arr[i]  = arr[minIndex];
               arr[minIndex]  = temp;
            }
        }
    }
    
    // insertion sort
    void insertionSort(int arr[]){   // time com = O(n^2) & space = O(1)
        for(int i=1; i<arr.length; i++){
            int temp  = arr[i], j = i;
            while(j>0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    
    // print fuction
    void display(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
         }
        System.out.println();
    } 
    
}
