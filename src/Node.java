import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Edge> Edges;

    public Node(String name){
        this.name = name;
        this.Edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return Edges;
    }

    public void addEdge (Edge edge) {
        Edges.add(edge);
    }
}
