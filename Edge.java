public class Edge {
    String rID;
    Intersection start;
    Intersection end;

    //constructor
    public Edge(String id, Intersection s, Intersection e) {
        rID = id;
        start = s;
        end = e;
    }

    public String getID(){
        return rID;
    }

    public Intersection getStart(){
        return start;
    }

    public Intersection getEnd(){
        return end;
    }

}