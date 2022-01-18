import java.util.*;
public class NewClass {
    public static void main(String args[]){
       ArrayList<WeightedNode> nodeList = new ArrayList<>();  
       nodeList.add(new WeightedNode("A", 0));
       nodeList.add(new WeightedNode("B", 1));
       nodeList.add(new WeightedNode("C", 2));
       nodeList.add(new WeightedNode("D", 3));
       nodeList.add(new WeightedNode("E", 4));
       nodeList.add(new WeightedNode("F", 5));
       nodeList.add(new WeightedNode("G", 6));
       
       WeightedGraph newGraph = new WeightedGraph(nodeList);
       newGraph.addWeightedEdge(0,1,2);
       newGraph.addWeightedEdge(0,2,5);
       newGraph.addWeightedEdge(1,2,6);
       newGraph.addWeightedEdge(1,3,1);
       newGraph.addWeightedEdge(1,4,3);
       newGraph.addWeightedEdge(2,5,8);
       newGraph.addWeightedEdge(2,4,4);
       newGraph.addWeightedEdge(4,6,9);
       newGraph.addWeightedEdge(5,6,7);
       
       System.out.println("Print Dijkstra from Source : A");
       newGraph.dijkstra(nodeList.get(0));
       
       
    }
}


 class WeightedNode implements Comparable<WeightedNode> {
  public String name;
  public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
  public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
  public boolean isVisited = false;
  public WeightedNode parent;
  public int distance;
  public int index;

  public WeightedNode(String name, int index) {
    this.name = name;
    distance = Integer.MAX_VALUE;
    this.index = index;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int compareTo(WeightedNode o) {
    return this.distance - o.distance;
  }


}


 class WeightedGraph {
  ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

  public WeightedGraph(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  void dijkstra(WeightedNode node) {
    PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
    node.distance = 0;
    queue.addAll(nodeList);
    while(!queue.isEmpty()) {
      WeightedNode currentNode = queue.remove();
      for (WeightedNode neighbor : currentNode.neighbors) {
        if(queue.contains(neighbor)) {
          if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
            neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
            neighbor.parent = currentNode;
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    for (WeightedNode nodeToCheck : nodeList) {
      System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
      pathPrint(nodeToCheck);
      System.out.println();
    }
  }

  public static void pathPrint(WeightedNode node) {
   if (node.parent  != null) {
     pathPrint(node.parent);
   }
   System.out.print(node.name + " ");
 }

  public void addWeightedEdge(int i, int j, int d) {
    WeightedNode first = nodeList.get(i);
    WeightedNode second = nodeList.get(j);
    first.neighbors.add(second);
    first.weightMap.put(second,d);
  }
}
