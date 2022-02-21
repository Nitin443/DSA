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
        
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(4, 7);
        g.addUndirectedEdge(4, 5);
        g.addUndirectedEdge(5, 6);
        g.addUndirectedEdge(1, 2);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(0, 5);
        
        g.ssspp(list.get(0));    // time com. = O(E) & space com. = O(V)
        
        
        
    }
}

class GraphNode{
    String name;
    int index;
    boolean isVisited = false;
    ArrayList<GraphNode> neighbours = new ArrayList<>();
    GraphNode parent;
    
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
    
    void addUndirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        
        first.neighbours.add(second);
        second.neighbours.add(first);
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
            for(GraphNode neighbor: currentNode.neighbours){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited  = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }
    
}
