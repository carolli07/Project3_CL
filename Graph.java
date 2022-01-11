
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;


public class Graph {

    //vertex keep all the nodes
//    public static HashMap<String, LinkedList> vertex;
    //locmap hashtable/ if intersection add hashmap // road adjust hashmap
    static Intersection [] dijkstraPath;
    //start hashmap
    public static HashMap<String, Intersection> intersection;
    public static HashMap<String, Edge> road;
    public static int numIntersection;
    static double minla, minlo, maxla, maxlo;
    static int x1, y1, x2, y2;
    double height = 800;
    double length = 800;
    int counti = 0;
    int countr = 0;

    public Graph(){
        intersection = new HashMap<String, Intersection>();
        road = new HashMap<String, Edge>();
    }

// new function name: read from file
    public void readFromfile() throws FileNotFoundException {
        File file = new File("monroe.txt"); // change the txt name here
        Scanner scan = new Scanner(file);
        minla = 50;
        maxlo = -80;
        while(scan.hasNext()){
            String s = scan.nextLine();
            String[] str_arr= s.split("\t");
            if(str_arr[0].equals("i")){
                Double la = Double.parseDouble(str_arr[2]);
                Double lo =  Double.parseDouble(str_arr[3]);
                Intersection i = new Intersection(str_arr[1], la, lo);
                intersection.put(i.iID, i);
                if(la < minla){
                    minla = la;
                }
                if(la > maxla){
                    maxla = la;

                }
                if(lo < minlo){
                    minlo = lo;
                }
                if(lo > maxlo){
                    maxlo = lo;
                }
            }

            if(str_arr[0].equals("r")){
                //check
                Intersection one = intersection.get(str_arr[2]);
                Intersection two = intersection.get(str_arr[3]);
                Edge e = new Edge(str_arr[1], one, two);
                road.put(e.rID, e);
//                if(one != null && two != null){
//                    one.neigh.add(two);
//                    two.neigh.add(one);
//                }
                //System.out.println(minDistance(one, two));
                //System.out.println(road.get(e.getStart()));
            }

        }

//        for(String i: intersection.keySet()){
//            //System.out.println(i);
//            counti++;
//        }
//        //System.out.println(counti);
//
//
//        for(String i: road.keySet()){
//            //System.out.println(i);
//            countr++;
//        }
        //System.out.println(countr);
    }

    public Edge getE(String k){
        //System.out.println(road.get(k));
        return road.get(k);
    }

//store all the nodes(short path) in a linkedlist
    //loop through i/ i+1
    //using the linkedlist .get(i) method
    //end to start building is reversed

    public int minDistance(Intersection start, Intersection end) {

        PriorityQueue<Intersection> pq = new PriorityQueue<Intersection>();
//        pq.add(start);
        for(Intersection i: intersection.values()){
            pq.add(i);
        }
        start.distance = 0;
        while(!pq.isEmpty()){
            Intersection min = pq.peek();
            for(Intersection i: min.neigh){
                int d = (int)distance(i.getIlatitude(), i.getIlongitude(), min.getIlatitude(), min.getIlongitude());
                int alter = min.distance + d;
                if(alter < i.distance){
                    i.distance = alter;
                    //i.preIntersection = min;
                }
                if(i == end){
                    return i.distance;
                }
            }

        }
        return start.distance;
    }

    public double distance(double la1, double lo1, double la2, double lo2) {
        int r = 6371000;
        //calculate the la and lo
        la1 = Math.toRadians(la1);
        lo1 = Math.toRadians(lo1);
        la2 = Math.toRadians(la2);
        lo2 = Math.toRadians(lo2);
        //difference
        double dlat = la2-la1;
        double dlo = lo2-lo1;
        //forms
        double sinla = Math.sin(dlat/2) * Math.sin(dlat/2);
        double cosla = Math.cos(la1) * Math.cos(la2);
        double sind = Math.sin(dlo/2) * Math.sin(dlo/2);
        double h = sinla+cosla*sind;
        double d = 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1-h));
        return r * d;
    }


}
