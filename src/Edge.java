public class Edge {


    private String Source;
    private String Destination;
    private int Weight;

    public Edge(String source, String Destination){
        this.Source = source;
        this.Destination = Destination;
        this.Weight = 0;
    }

    public String getSource() {
        return Source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }
}
