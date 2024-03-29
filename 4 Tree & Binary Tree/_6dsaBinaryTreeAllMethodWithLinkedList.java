import java.util.LinkedList;
import java.util.Queue;
public class NewClass {
     public static void main(String args[]){
         
         // initialize binary tree in memory
         BinaryTree bt = new BinaryTree();
         // insertion in tree
         bt.insert("N1");
         bt.insert("N2");
         bt.insert("N3");
         bt.insert("N4");
         bt.insert("N5");
         bt.insert("N6");
         bt.insert("N7");
         bt.insert("N8");
         bt.insert("N9");
         
       //  BinaryNode roots = new BinaryNode();
         BinaryNode roots = bt.root;
         
         // treaversing
          System.out.println("preorder traversal");
          bt.preOrder(roots);
          System.out.println();
          System.out.println("inorder traversal");
          bt.inOrder(roots);
          System.out.println();
          System.out.println("postorder traversal");
          bt.postOrder(roots);
          System.out.println();
         System.out.println("level order traversal");
          bt.levelOrder();
          System.out.println();
          
          // searching value
          bt.search("N5");
          System.out.println("###############################");
          
          // delete given Node
          bt.deleteNode("N7");
          bt.levelOrder();
          System.out.println();
          
          // delete tree
          bt.deleteAllNode();
         
     }
}

class BinaryNode{
    String data;
    BinaryNode left;
    BinaryNode right;
    int height;
}

class BinaryTree{
    BinaryNode root;
    
    // initialize binary tree using constructor
    BinaryTree(){
        this.root = null;
    }
    
    //preorder traversal [ rootNode -> Left subTree -> Right subTree ]
    void preOrder(BinaryNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
        //inorder traversal [ Left subTree -> rootNode -> Right subTree ]
    void inOrder(BinaryNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
        //postorder traversal [ Left subTree -> Right subTree -> rootNode]
    void postOrder(BinaryNode node){   
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
      // level order travesal [ lelel 1 -> level 2 -> level 3 -> and so on ]
    void levelOrder(){
         Queue<BinaryNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             BinaryNode presentNode = queue.remove();
             System.out.print(presentNode.data + " ");
             if(presentNode.left != null ){
                 queue.add(presentNode.left);
             }
             
             if(presentNode.right != null ){
                 queue.add(presentNode.right);
             }
         }
    }
    
    // searching using level order traversal
    void search(String value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.data == value){
                System.out.println("The given value " + value + " is found in tree");
                return;
            }else{
                if(presentNode.left != null ){
                    queue.add(presentNode.left);
                }
                
                if(presentNode.right != null ){
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("The given value " + value + " is not found in tree");
    }
    
    // insert method 
    void insert(String value){
        BinaryNode newNode = new BinaryNode();
        newNode.data = value;
        if(root == null){
            root = newNode;
            System.out.println("value  " + value + "is insert in root");
            return;
        }
        
        // if root in not null then use level oreder traversal and find find empty node and insert element
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
         //    System.out.println("********************");
              System.out.println(presentNode.data + " " + presentNode.left + " " + presentNode.right);
          //   System.out.println("#####################");
             
            if(presentNode.left == null){
                presentNode.left = newNode;
                System.out.println("value  " + value + "is insert in tree at left position of parent node");
                return;
            }else if(presentNode.right == null){
                presentNode.right = newNode;
                System.out.println("value  " + value + "is insert in tree at right position of parent node");
                return;
            }else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }
    
    // ********  we will delete the node by following three function ***************//
    
    // find deepest node 
    BinaryNode getDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while(!queue.isEmpty()){
            presentNode = queue.remove();
            
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }
        
     // delete deepest node
    void deleteDeepestNode(){
      Queue<BinaryNode> queue = new LinkedList<>();
      queue.add(root);
      BinaryNode previousNode, presentNode = null;
      while(!queue.isEmpty()){
          previousNode = presentNode;
          presentNode = queue.remove();
          if(presentNode.left == null){
              previousNode.right = null;
              return;
          } else if(presentNode.right == null){
               presentNode.left = null;
         }
          queue.add(presentNode.left);
          queue.add(presentNode.right);
    }
  }
    
    // delete given Node
    void deleteNode(String value){
      Queue<BinaryNode> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty()){
       BinaryNode presentNode = queue.remove();
       if(presentNode.data == value){
           presentNode.data = getDeepestNode().data;  // set deepest node value on place of node that we want delete
           deleteDeepestNode(); // delete deepest node
           System.out.println("Node has deleted");
           return;
       } else {
           if(presentNode.left != null){
               queue.add(presentNode.left);
           }
           if(presentNode.right != null){
               queue.add(presentNode.right);
           }
       }
      }
    }
    
    void deleteAllNode(){
        root = null;
        System.out.println("Tree has deleted");
    }
}
