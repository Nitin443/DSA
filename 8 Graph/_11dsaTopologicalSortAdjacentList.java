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
    ArrayList<GraphNode> neighbors = new ArrayList<>();
    
    GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }
}

class Graph{
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    
    Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }
    
    void addDirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        
        first.neighbors.add(second);
    }
    
    // topology visit method
    void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        for(GraphNode neighbor: node.neighbors){
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
