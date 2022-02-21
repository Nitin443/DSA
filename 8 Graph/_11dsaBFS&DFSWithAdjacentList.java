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
        
        Graph g = new Graph(list);
        
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        
       //  g.bfs();  // time complexity = O(v + e) &  space complexity = O(v + e)
         g.dfs();    // time complexity = O(v + e) &  space complexity = O(v + e)
       
      // String s=  g.display();
      // System.out.print(s);
        
        
    }
}

class GraphNode{
    String name;
    int index;
    boolean isVisited = false;
    ArrayList<GraphNode> neighbours = new ArrayList<>();
    
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
    
    // BFS internal
    void bfsVisit(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNode neighbor: currentNode.neighbours){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    
    // bfs function
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
            for(GraphNode neighbor: currentNode.neighbours){
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
        for(int i=0; i<nodeList.size(); i++){
            sb.append(nodeList.get(i).name + ": ");
            for(int j=0; j < nodeList.get(i).neighbours.size(); j++ ){
                if(j == nodeList.get(i).neighbours.size() - 1){
                    sb.append(nodeList.get(i).neighbours.get(j).name);
                }else{
                    sb.append((nodeList.get(i).neighbours.get(j).name) + " ->");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
