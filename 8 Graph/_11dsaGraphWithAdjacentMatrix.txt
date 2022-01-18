import java.util.ArrayList;
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
       
       String s = g.display();
       System.out.print(s);
       
    }
   
}

class GraphNode{
    String name;
    int index;
    
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
