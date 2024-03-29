import java.util.ArrayList;
public class NewClass {
    public static void main(String args[]){
        QuadraticProbing lp = new QuadraticProbing(5);
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


class QuadraticProbing{
    String[] hashTable;
    int usedCellNum;
    
    QuadraticProbing(int size){
       hashTable = new String[size];
       this.usedCellNum = 0;
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
            int index = modASCIIhashFunction(word, hashTable.length);
            int counter = 0;
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = (index + (counter*counter))% hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println(" the : "+word + " inserted sucesfully at " + newIndex);
                    break;
                }else{
                   System.out.println( newIndex + " is already occupied trying new empty cell"); 
                }
                counter++;
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
