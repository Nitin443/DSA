import java.util.ArrayList;
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
        
       String s=  g.display();
       System.out.print(s);
        
        
    }
}

class GraphNode{
    String name;
    int index;
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
