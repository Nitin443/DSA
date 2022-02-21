import java.util.ArrayList;
import java.util.LinkedList;
public class NewClass {
    public static void main(String args[]){
        DirectChaining dc = new DirectChaining(15);
        dc.insertHashTable("Nitin");
        dc.insertHashTable("Ni");
        dc.insertHashTable("Nit");
        dc.insertHashTable("kumar");
        dc.insertHashTable("MCA");
        dc.insertHashTable("BCA");
        dc.insertHashTable("engineer");
        dc.insertHashTable("innovater");
        dc.displayHashtable();
        
        dc.search("MCA");
        dc.search("mca");
        
        dc.delete("BCA");
        dc.displayHashtable();
        
        
    }
}

class DirectChaining{
    LinkedList<String>[] hashTable;
   // int maxChainSize = 5;
    
    DirectChaining(int size){
        hashTable = new LinkedList[size];
    }
    
    // hash function -> convert string into ascii value and return index value
    int modASCIIhashFunction(String word, int M){   
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for(sum=0, i=0; i<word.length(); i++){
          sum = sum + ch[i];
       } 
        return sum % M;
    }
    
    // insert
    void insertHashTable(String word){
        int newIndex = modASCIIhashFunction(word, hashTable.length);
        if(hashTable[newIndex] == null){
           hashTable[newIndex] = new LinkedList<>();
           hashTable[newIndex].add(word);
        }else {
           hashTable[newIndex].add(word); 
        }
    }
    
    // display hash key and value
    void displayHashtable(){
        if(hashTable == null){
            System.out.println("Hash Table does not exit");
            return;
        }else{
            System.out.println("/------------hash table ----------/");
            for(int i=0; i<hashTable.length; i++){
                System.out.println("Index : " + i + " key : " + hashTable[i] );
            }
        }
    }
    
    // search
    boolean search(String word){
        int newIndex = modASCIIhashFunction(word, hashTable.length);
        
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)){
            System.out.println(word + " value found at Index : " + newIndex);
            return true;
        }else{
             System.out.println(word + " value not found at Index");
             return false;
        }
    }
    
    // delete
    void delete(String word){
       int newIndex = modASCIIhashFunction(word, hashTable.length);
       
       boolean result = search(word);
       
       if(result == true){
           hashTable[newIndex].remove(word);
           System.out.println(word + " has beeb deletd");
       }
    }
}
