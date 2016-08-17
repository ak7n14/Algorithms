/**
 * Created by Anish Katariya
 */

 import java.util.HashSet;
 import java.util.List;


 public class clusterAlgo{

   public Set<Node>getClusterNodes(Node startNode,Graph graph){
     Stack<Node>uncheckedNodes = new Stack<Node>();
     Set<Node>clusterNodes = new Set<Node>();

     uncheckedNodes.push(startNode);
     clusterNodes.add(clusterNodes);

     while(!uncheckedNodes.isEmpty()){
       Node next = uncheckedNodes.pop();
       List<Node> neighbours = graph.getNeighbours(next);
       for(Node neigh:neighbours){
         if(neigh.isOccupied() && !clusterNodes.contains(neigh)){
           clusterNodes.add(neigh);
           uncheckedNodes.push(neigh);
         }
       }
     }
     return clusterNodes;
   }
 }
