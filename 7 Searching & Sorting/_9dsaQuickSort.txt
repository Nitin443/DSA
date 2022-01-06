public class NewClass {
    public static void main(String args[]){
       QuickSort qs = new QuickSort();
        int arr[]  = {87,33,65,35,98,2,54};
        qs.quickSort(arr, 0, 6);
        qs.display(arr);   
    }
    
}

class QuickSort{
    
    int partition(int arr[], int start, int end){
        int pivot = end;
        int i = start-1;
        
        for(int j=start; j<=end; j++){
            if(arr[j] <= arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
    
    void quickSort(int arr[], int start, int end){  // time com = O(nlog(n)) & space = O(n)
        if(start < end){
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
            
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
