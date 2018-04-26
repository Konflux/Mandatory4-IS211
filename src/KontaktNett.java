import java.util.ArrayList;
import java.util.List;

public class KontaktNett {
    private ArrayList<Node> nodes;


    public KontaktNett(){
        nodes = new ArrayList<>();
    }

    /**
     * Registrer en samtale i grafen
     * @param fra - navnet på personen som ringte
     * @param til - navnet på personen han ringte til
     */
    public void registrerSamtale(String fra, String til){
        for (Node node : nodes){
            if (node.getName().equals(fra)){
                ArrayList<Edge> nodesEdges = node.getEdges();
                for (Edge edge : nodesEdges){
                    if (edge.getDestination().equals(til)){
                        edge.setWeight(edge.getWeight() + 1);
                    }
                }
            }
        }
    }

    /**
     * Returner en liste over personer som en mistenkt har hatt tett
     * kontakt med.
     * @param mistenkt - navnet på den mistenkte personen
     * @param ant - antall ganger to personer må ringt hverandre
     * for å ha hatt tett kontakt
     */
    public List<String> finnDirekteKontakter(String mistenkt, int ant) {
        ArrayList<String> kontakter = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getName().equals(mistenkt)) {
                ArrayList<Edge> edges = node.getEdges();
                for (Edge edge : edges) {
                    if (edge.getWeight() >= ant) {
                        String name = edge.getDestination();
                        kontakter.add(name);
                    }
                }
            }
        }
        return kontakter;
    }


    /**
     * Returner en liste over personer som en mistenkt har hatt
     * direkte eller indirekte tett kontakt med.
     * @param mistenkt - navnet på den mistenkte personen
     * @param ant - antall ganger to personer må ringt hverandre
     * for å ha hatt tett kontakt
     */
    public List<String> finnAlleKontakter(String mistenkt, int ant) {
        ArrayList<String> returnList = new ArrayList<>();
        ArrayList<String> direkteKontakter = (ArrayList<String>) finnDirekteKontakter(mistenkt, ant);
        for (String kontakt : direkteKontakter){
            returnList.add(kontakt);

            ArrayList<String> indirekteKontakter = (ArrayList<String>) finnDirekteKontakter(kontakt, ant);
            for (String indirekteKontakt : indirekteKontakter){
                if (indirekteKontakt.equals(mistenkt)){

                } else {
                    returnList.add(indirekteKontakt);
                }
            }
        }
        return returnList;
    }

    public void fillTestData(){
        Node node1 = new Node("Per");
        Edge edge1 = new Edge("Per", "Pål");
        edge1.setWeight(11);
        Edge edge2 = new Edge("Per", "Espen");
        edge2.setWeight(9);
        Edge edge3 = new Edge("Per", "Narren");
        edge3.setWeight(7);
        node1.addEdge(edge1);
        node1.addEdge(edge2);
        node1.addEdge(edge3);
        nodes.add(node1);

        Node node2 = new Node("Pål");
        Edge paal1 = new Edge ("Pål", "Per");
        paal1.setWeight(12);
        Edge paal2 = new Edge ("Pål", "Narren");
        paal2.setWeight(15);
        node2.addEdge(paal1);
        node2.addEdge(paal2);
        nodes.add(node2);

        Node node3 = new Node("Espen");
        Edge espen1 = new Edge ("Espen", "Prinsessa");
        espen1.setWeight(115);
        node3.addEdge(espen1);
        nodes.add(node3);

        Node node4 = new Node("Narren");
        Edge narren1 = new Edge("Narren", "Prinsessa");
        narren1.setWeight(19);
        Edge narren2 = new Edge("Narren", "Per");
        narren2.setWeight(7);
        Edge narren3 = new Edge("Narren", "Kongen");
        narren3.setWeight(21);
        Edge narren4 = new Edge("Narren", "Pål");
        narren4.setWeight(17);
        node4.addEdge(narren4);
        node4.addEdge(narren1);
        node4.addEdge(narren2);
        node4.addEdge(narren3);
        nodes.add(node4);

        Node node5 = new Node("Prinsessa");
        Edge prinsessa1 = new Edge("Prinsessa", "Espen");
        prinsessa1.setWeight(143);
        Edge prinsessa2 = new Edge("Prinsessa", "Kongen");
        prinsessa2.setWeight(14);
        node5.addEdge(prinsessa1);
        node5.addEdge(prinsessa2);
        nodes.add(node5);

        Node node6 = new Node("Kongen");
        Edge kongen1 = new Edge("Kongen", "Prinsessa");
        kongen1.setWeight(3);
        node6.addEdge(kongen1);
        nodes.add(node6);
    }
}
