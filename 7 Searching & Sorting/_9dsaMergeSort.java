public class NewClass {
    public static void main(String args[]){
        MergeSort ms = new MergeSort();
        int arr[]  = {87,33,65,35,98,2,54};
        ms.mergeSort(arr, 0, 6);
        ms.display(arr);
    }
}

class MergeSort{
    
    void merge(int arr[], int left, int middle, int right){
        int [] leftTempArr = new int[middle-left+2];
        int [] rightTempArr = new int[right-middle+1];
        
        for(int i=0; i<=middle-left; i++){
            leftTempArr[i] = arr[left+i];
        }
        
        for(int i=0; i<right-middle; i++){
            rightTempArr[i] = arr[middle+1+i];
        }
        
        leftTempArr[middle-left+1] = Integer.MAX_VALUE;
        rightTempArr[right-middle] = Integer.MAX_VALUE;
        
        int i = 0, j = 0;
        for(int k=left; k<=right; k++){
            if(leftTempArr[i] < rightTempArr[j]){
                arr[k] = leftTempArr[i];
                i++;
            }else{
                arr[k] = rightTempArr[j];
                j++;
            }
        }
    }
    
    void mergeSort(int arr[], int left, int right){   // time com = O(nlog(n)) & space = O(n)
        if(right > left){
            int middle = (right+left)/2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
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
