import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Node<T> {

    private T nodeName;
    private HashMap<Node, Integer> links;
    private Graph myGraph;

    public Node(T nodeName, Graph myGraph) {
        this.nodeName = nodeName;
        this.myGraph = myGraph;
        this.links = new HashMap<>();
    }

    public T getNodeName() {
        return nodeName;
    }

    public void addLink(Node dest, Integer cost) {
        this.links.put(dest, cost);
    }

    public Integer getCost(Node destNode) {
        if (links.get(destNode) != null) return links.get(destNode);
        return 0;
    }

    public void routeBuilding(Node searchNode, ArrayList<Node> route, int distance) {
        if (searchNode == this) {
            System.out.println("You are here!");
            return;
        }
        for (Node n : links.keySet()) {
            if (isAddable(n, route)) {
                if (n == searchNode) {
                    ArrayList newRoute = (ArrayList) route.clone();
                    newRoute.add(n);
                    int newDistance = distance + links.get(n);
                    if (myGraph.getShortestDist() == -1 || myGraph.getShortestDist() > newDistance) {
                        myGraph.setShortestDist(newDistance);
                        myGraph.setBestRoute(newRoute);
                    }
                    System.out.println("Found a new route: " + newRoute + " Distance: " + newDistance);
                } else {
                    ArrayList newRoute = (ArrayList) route.clone();
                    newRoute.add(n);
                    int newDistance = distance + getCost(n);
                    n.routeBuilding(searchNode, newRoute, newDistance);
                }
            }
        }
    }

    private boolean isAddable(Node node, ArrayList<Node> route) {
        Iterator<Node> itr = route.iterator();
        while (itr.hasNext()) {
            if (node == itr.next()) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.nodeName.hashCode();
    }

    @Override
    public String toString() {
        return this.nodeName.toString();
    }
}
