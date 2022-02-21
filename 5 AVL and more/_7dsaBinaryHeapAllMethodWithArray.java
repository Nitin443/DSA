import java.util.LinkedList;
import java.util.Queue;
public class NewClass {
    public static void main(String args[]){
        Avl avl = new Avl();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(60);
        avl.insert(70);
        
        BinaryNode roots = avl.root;
        // traverse
        avl.preOrder(roots);
        System.out.println();
        avl.inOrder(roots);
        System.out.println();
        avl.postOrder(roots);
        System.out.println();
        avl.levelOrder();
        System.out.println();
        
        // searching 
     BinaryNode se =    avl.search(roots, 70);
     System.out.println("####################");
     avl.preOrder(se);
     System.out.println("####################");
     
        // delete
        System.out.println("------------------");
        avl.deleteNode(50);
      //   avl.levelOrder();
        
        
    }
}


class BinaryNode{
    int value;
    int height;
    BinaryNode left;
    BinaryNode right;
    
    BinaryNode(){
        this.height = 0;
    }
}

class Avl{
    BinaryNode root;
    
    // initailize bst in memory
    Avl(){
        root = null;
    }
    
    //preorder traversal [ rootNode -> Left subTree -> Right subTree ]
    void preOrder(BinaryNode node){
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
        //inorder traversal [ Left subTree -> rootNode -> Right subTree ]
    void inOrder(BinaryNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    
        //postorder traversal [ Left subTree -> Right subTree -> rootNode]
    void postOrder(BinaryNode node){   
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    
     // level order travesal [ lelel 1 -> level 2 -> level 3 -> and so on ]
    void levelOrder(){
         Queue<BinaryNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             BinaryNode presentNode = queue.remove();
             System.out.print(presentNode.value + " ");
             if(presentNode.left != null ){
                 queue.add(presentNode.left);
             }
             
             if(presentNode.right != null ){
                 queue.add(presentNode.right);
             }
         }
    }
    
    // searching
    BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.println("value not found in tree");
            return null;
        }else if(node.value == value){
            System.out.println("value  found in tree");
            return node;
        }else if(value < node.value){
            return search(node.left, value);
        }else{
            return search(node.right, value);
        }
    }
    
    //************************ ALL method of insertion in AVL tree ************************//
    
    // get height
    int getHeight(BinaryNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    
    // rotate right
    private BinaryNode rotateRight(BinaryNode disbalanceNode){
        BinaryNode newRoot = disbalanceNode.left;
        disbalanceNode.left = disbalanceNode.left.right;
        newRoot.right = disbalanceNode;
        disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        return newRoot;
    }
    
    // rotate left
    private BinaryNode rotateLeft(BinaryNode disbalanceNode){
        BinaryNode newRoot = disbalanceNode.right;
        disbalanceNode.right = disbalanceNode.right.left;
        newRoot.left = disbalanceNode;
        disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        return newRoot;
    }
    
    // get balance
    int getBalance(BinaryNode node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    
     // insert method
     private BinaryNode insert(BinaryNode node, int nodeValue){ // we make this method private because we call it only inside that class not outside of class
        if(node == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            System.out.println("Node inserted sucessfully : " + nodeValue );
            return newNode;
        }else if(nodeValue <= node.value){
            node.left = insert(node.left, nodeValue);
         }else{
             node.right = insert(node.right, nodeValue);
         }
        
         node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
         int balance = getBalance(node);
        
         // LL condition
         if(balance >1 && nodeValue < node.left.value){
             return rotateRight(node);
         }
        
         //LR condition
         if(balance >1 && nodeValue > node.left.value){
             node.left = rotateLeft(node.left);
             return rotateRight(node);
         } 
        
         // RR condition
         if(balance < -1 && nodeValue > node.right.value){
             return rotateLeft(node);
         }
        
         //RL condition
         if(balance > -1 && nodeValue < node.right.value){
             node.right = rotateRight(node.left);
             return rotateLeft(node);
         }
         return node;
    }
    
      // public insert method that will call outside class
        void insert(int nodeValue){
         root = insert(root, nodeValue);
    }
        
         //************************ ALL method of deletion in AVL tree ************************//
        
        // minimum node
    static BinaryNode minValNode(BinaryNode root){
        if(root.left == null){
            return root;
        }else{
            return minValNode(root.left);
        }
    }
    
    // delete node
   private BinaryNode deleteNode(BinaryNode root,int value){
        if(root == null){
            System.out.println("value not found in tree");
            return root;
        }
        
        if(value < root.value){
            root.left = deleteNode(root.left, value);
        }else if(value > root.value){
           root.right = deleteNode(root.right, value); 
        }else{
            if(root.left != null && root.right != null){
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minValNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            }else if(root.left != null){
                root = root.left;
            }else if(root.right != null){
                root = root.right;
            }else{
                root = null;
            }
        }
        
        int balance = getBalance(root);
        
         // LL condition
         if(balance >1 && getBalance(root.left) >= 0){
             return rotateRight(root);
         }
        
         //LR condition
         if(balance >1 && getBalance(root.left) < 0){
             root.left = rotateLeft(root.left);
             return rotateRight(root);
         } 
        
         // RR condition
         if(balance < -1 && getBalance(root.right) <= 0){
             return rotateLeft(root);
         }
        
         //RL condition
         if(balance > -1 && getBalance(root.right) > 0){
             root.right = rotateRight(root.right);
             return rotateLeft(root);
         }
         
        return root;
    }
    
    void deleteNode(int value){
        root = deleteNode(root, value);
    }
    
    // ********************************************************************   //
    
    // delete all tree
    void deleteAllTree(){
        if(root == null){
           System.out.println("Tree is already empty"); 
        }else{
            root = null;
            System.out.println("Tree nodes has been deleted"); 
        }
    }
}



