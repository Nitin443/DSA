import java.util.ArrayList;
public class NewClass {
    public static void main(String args[]){
        DoubleHashing lp = new DoubleHashing(5);
        lp.insert("nitin");
        lp.insert("ni");
        lp.insert("nit");
        lp.insert("niti");
        lp.insert("n");
        lp.displayHashtable();
        
        lp.search("niti");
        
        lp.delete("n");
        lp.displayHashtable();
    }
}


class DoubleHashing{
    String[] hashTable;
    int usedCellNum;
    
    DoubleHashing(int size){
       hashTable = new String[size];
       this.usedCellNum = 0;
    }
    
    // hash function -> convert string into ascii value and return index value 
    int modASCIIhashFunction(String word, int M){   // 1st hash function
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for(sum=0, i=0; i<word.length(); i++){
          sum = sum + ch[i];
       } 
        return sum % M;
    }
    
    private int addAllDigitsTogether(int sum){
        int value = 0;
        while(sum>0){
            value = sum % 10;
            sum = sum/10;
        }
        return value;
    }
    
    // 2nd hash function
     int secondHashFun(String x, int M){
         char ch[];
         ch = x.toCharArray();
         int i, sum;
         for(sum=0, i=0; i<x.length(); i++){
             sum = sum + ch[i];
         }
         while(sum > hashTable.length){
             sum = addAllDigitsTogether(sum);
         }
         return sum % M;
     }

    
    // load factor
    double loadFactor(){
        double loadFactor = usedCellNum * 1.0 / hashTable.length;
        return loadFactor;
    }
    
    // Re Hash
    void reHashKeys(String word){
        ArrayList<String> data = new ArrayList<>();
        for(String s : hashTable){
            if(s != null){
                data.add(s);
            }
        }
        data.add(word);
            hashTable = new String[hashTable.length * 2];
            for(String d : data){
                insert(d);
            }
    }
    
    // insert
    void insert(String word){
        double loadFactor = loadFactor();
        if(loadFactor >= 0.75){
            reHashKeys(word);
        }else {
            int x = modASCIIhashFunction(word, hashTable.length);
            int y = secondHashFun(word, hashTable.length);
            for(int i=0; i<hashTable.length; i++){
                int newIndex = (x + (i*y))% hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println(" the : "+word + " inserted sucesfully at " + newIndex);
                    break;
                }else{
                   System.out.println( newIndex + " is already occupied trying new empty cell"); 
                }
            }
        }
        usedCellNum++;
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
    
    //search
    void search(String word){
        int index = modASCIIhashFunction(word, hashTable.length);
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = i % hashTable.length;
                if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                   System.out.println("word found"); 
                }else{
                   System.out.println("word not found");  
                }
            }
    }
    
    // delete
    void delete(String word){
        int index = modASCIIhashFunction(word, hashTable.length);
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = i % hashTable.length;
                if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                    hashTable[newIndex] = null;
                    System.out.println("word deleted");
                    return;
                }
            }
            System.out.println("word not found");
    }
}
