public class Main {

    public static void main(String[] args) {

        Graph orlov = new Graph();
        orlov.addNode(1);
        orlov.addNode(2);
        orlov.addNode(3);
        orlov.addNode(4);
        orlov.addNode(5);
        orlov.addNode(6);
        orlov.addNode(7);

        orlov.craateLink(1, 2, 1, 'y');
        orlov.craateLink(2, 3, 3, 'y');
        orlov.craateLink(2, 5, 2, 'y');
        orlov.craateLink(5, 6, 4);
        orlov.craateLink(3, 6, 1, 'y');
        orlov.craateLink(3, 4, 6, 'y');
        orlov.craateLink(6, 7, 2, 'y');
        orlov.craateLink(4, 7, 1, 'y');

        orlov.drawGraph();

        orlov.findShortestWay(1,7);
        orlov.findShortestWay(7,1);
        orlov.findShortestWay(3,6);
        orlov.findShortestWay(5,1);

    }
}
