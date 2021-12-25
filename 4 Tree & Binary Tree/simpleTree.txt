import java.util.ArrayList;
public class NewClass {
    public static void main(String args[]){
        // initialize TreeNode 
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode wine = new TreeNode("Wine");
        TreeNode beer = new TreeNode("Beer");
        
        // add chlidren to parent node
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(wine);
        cold.addChild(beer);
        
        //print tree
        System.out.println(drinks.print(0));
    }
}


class TreeNode{
    String data;
    ArrayList<TreeNode> children;
    
    // initialize tree using constructor
    TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }
    
    // link children  to parent node
     void addChild(TreeNode node){
         this.children.add(node);
     }
     
     // print tree 
      String print(int level){
          String ret;
          ret = " ".repeat(level)+data+"\n";
          for(TreeNode node : this.children){
              ret += node.print(level+1);
          }
          return ret;
      }
}
