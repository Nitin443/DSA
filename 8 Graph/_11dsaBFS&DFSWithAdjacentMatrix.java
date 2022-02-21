import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class NewClass {
    public static void main(String args[]){
       ArrayList<GraphNode> nodeList = new ArrayList<>();
       nodeList.add(new GraphNode("A", 0)); 
       nodeList.add(new GraphNode("B", 1));
       nodeList.add(new GraphNode("C", 2));
       nodeList.add(new GraphNode("D", 3));
       nodeList.add(new GraphNode("E", 4));
       
       Graph g = new Graph(nodeList);
       g.addUndirectedEdge(0, 1);
       g.addUndirectedEdge(0, 2);
       g.addUndirectedEdge(0, 3);
       g.addUndirectedEdge(1, 4);
       g.addUndirectedEdge(2, 3);
       g.addUndirectedEdge(3, 4);
       
     //  g.bfs();   // time complexity = O(v + e) &  space complexity = O(v + e)
         g.dfs();   // time complexity = O(v + e) &  space complexity = O(v + e)
       
      // String s = g.display();
       //System.out.print(s);
       
    }
   
}

class GraphNode{
    String name;
    int index;
    boolean isVisited = false;
    
    GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }
}

class Graph{
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacentMatrix;
    
    Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacentMatrix = new int[nodeList.size()][nodeList.size()];
    }
    
    void addUndirectedEdge(int i, int j){
        adjacentMatrix[i][j] = 1;
        adjacentMatrix[j][i] = 1;
    }
    
    // get neighbors
    ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i=0; i<adjacentMatrix.length; i++){
            if(adjacentMatrix[nodeIndex][i] == 1){
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }
    
    // BFS internal
    void bfsVisit(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for(GraphNode neighbor: neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    
    // bsf function
    void bfs(){
        for(GraphNode node: nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }
    
    // dfs internal
    void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
           GraphNode currentNode = stack.pop();
           currentNode.isVisited = true;
           System.out.print(currentNode.name + " ");
           ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
           for(GraphNode neighbor: neighbors){
               if(!neighbor.isVisited){
                   stack.push(neighbor);
                   neighbor.isVisited = true;
               }
           }
        }
    }
    
    // dfs function
    void dfs(){
        for(GraphNode node: nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }
    
    
    String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for(int i=0; i<nodeList.size(); i++){
            sb.append(nodeList.get(i).name + " ");
        }
        sb.append("\n");
        
        for(int i=0; i<nodeList.size(); i++){
            sb.append(nodeList.get(i).name + ": ");
            for(int j : adjacentMatrix[i]){
                sb.append((j) + " ");
            }
             sb.append("\n");
        }
        return sb.toString();
    }
}
