import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class NewClass {
    public static void main(String args[]){
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
        
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(2, 4);
        g.addDirectedEdge(4, 7);
        g.addDirectedEdge(4, 5);
        g.addDirectedEdge(5, 6);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(0, 5);
        
       
        g.topologySort();  // time complexity = O(V + E) & space complexity = O(V + E)
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
    
    void addDirectedEdge(int i, int j){
        adjacentMatrix[i][j] = 1;
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
    
    // topology visit method
    void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        ArrayList<GraphNode> neighbors =  getNeighbors(node);
        for(GraphNode neighbor: neighbors){
            if(!neighbor.isVisited){
                topologicalVisit(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }
    
    // topology method
    void topologySort(){
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node: nodeList){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }

}
