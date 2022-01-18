import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class NewClass {
    public static void main(String args[]){
       ArrayList<GraphNode> nodeList = new ArrayList<>();
       ArrayList<GraphNode> list = new ArrayList<>();
        list.add(new GraphNode("A", 0));
        list.add(new GraphNode("B", 1));
        list.add(new GraphNode("C", 2));
        list.add(new GraphNode("D", 3));
        list.add(new GraphNode("E", 4));
        list.add(new GraphNode("F", 5));
        list.add(new GraphNode("G", 6));
        list.add(new GraphNode("H", 7));
        
        Graph g = new Graph(list);
        
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(4, 7);
        g.addUndirectedEdge(4, 5);
        g.addUndirectedEdge(5, 6);
        g.addUndirectedEdge(1, 2);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(0, 5);
        
        g.ssspp(list.get(0));   // time com. = O(E) & space com. = O(V)
       
    }
   
}

class GraphNode{
    String name;
    int index;
    boolean isVisited = false;
    GraphNode parent;
    
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
    
  // path print
    void printPath(GraphNode node){
        if(node.parent != null){
            printPath(node.parent);
        }
        System.out.print(node.name + " ");
    }
    
    // ssspp method
    void ssspp(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name + " : " );
            printPath(currentNode);
            System.out.println();
            ArrayList<GraphNode> neighbours = getNeighbors(currentNode);
            for(GraphNode neighbor: neighbours){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited  = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }
   
}
