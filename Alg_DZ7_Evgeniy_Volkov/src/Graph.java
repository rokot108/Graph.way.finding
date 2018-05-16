import java.util.ArrayList;
import java.util.Iterator;

public class Graph {

    private ArrayList<Node> nodes;
    private ArrayList<Node> bestRoute;
    private int shortestDist;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.bestRoute = new ArrayList<>();
    }

    public <T> boolean addNode(T nodeName) {
        if (getNode(nodeName) == null) {
            this.nodes.add(new Node(nodeName, this));
            return true;
        } else return false;
    }

    public <T> boolean craateLink(T start, T dest, Integer cost) {
        if (start != dest) {
            Node firstNode = getNode(start);
            Node secondNode = getNode(dest);
            if (firstNode != null && secondNode != null) {
                firstNode.addLink(secondNode, cost);
                return true;
            }
        }
        return false;
    }

    public <T> boolean craateLink(T start, T dest, Integer cost, char withBackWay) {
        if (start != dest) {
            Node firstNode = getNode(start);
            Node secondNode = getNode(dest);
            if (firstNode != null && secondNode != null) {
                firstNode.addLink(secondNode, cost);
                secondNode.addLink(firstNode, cost);
                return true;
            }
        }
        return false;
    }

    public <T> Node getNode(T nodeName) {
        Iterator<Node> itr = nodes.iterator();
        while (itr.hasNext()) {
            Node tmp = itr.next();
            if (tmp.getNodeName() == nodeName) return tmp;
        }
        return null;
    }

    public void drawGraph() {
        System.out.println("\t" + nodes);
        for (int i = 0; i < nodes.size(); i++) {
            Node line = nodes.get(i);
            System.out.print(line + "\t ");
            for (int j = 0; j < nodes.size(); j++) {
                Node column = nodes.get(j);
                System.out.print(line.getCost(column) + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public <T> void findARoute(T start, T finish) {
        Node startNode = getNode(start);
        Node finishNode = getNode(finish);
        if (startNode != null && finishNode != null) {
            System.out.println("Searching for a way from " + startNode + " to " + finishNode);
            ArrayList<Node> route = new ArrayList<>();
            route.add(startNode);
            startNode.routeBuilding(finishNode, route, 0);
        } else {
            System.out.println("Wrong points!");
        }
    }

    public <T> void findShortestWay(T start, T finish) {
        bestRoute.clear();
        shortestDist = -1;
        findARoute(start, finish);
        System.out.println("Shortest route is " + bestRoute + ". Distance is " + shortestDist);
        System.out.println();
    }

    public int getShortestDist() {
        return shortestDist;
    }

    public void setShortestDist(int shortestDist) {
        this.shortestDist = shortestDist;
    }

    public void setBestRoute(ArrayList<Node> bestRoute) {
        this.bestRoute = bestRoute;
    }

}
