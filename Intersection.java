import java.util.ArrayList;

//change interseaction to node
public class Intersection implements  Comparable<Intersection>{
    String iID;
    double ilongitude;
    double ilatitude;
    boolean visited = false;
    int distance = Integer.MAX_VALUE;
    ArrayList<Intersection> neigh;
    Intersection path;//this is the previous visited nodes

    //constructor
    public Intersection(String id, double la, double lo){
        iID = id;
        ilongitude = lo;
        ilatitude = la;
        neigh = new ArrayList<Intersection>();
    }

    public Intersection(String id, double la, double lo, ArrayList<Intersection> n){
        iID = id;
        ilongitude = lo;
        ilatitude = la;
        neigh = n;
    }

    public String getiID(){
        return iID;
    }

    public double getIlatitude() {
        return ilatitude;
    }

    public double getIlongitude() {
        return ilongitude;
    }

    public int compareTo(Intersection i){
        if(distance < i.distance){
            return -1;
        }
        else if (distance > i.distance){
            return 1;
        }
        return 0;
    }
}
