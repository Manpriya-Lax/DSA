 import java.util.*;
import java.io.*;
 
 
 public class UnitTestFlightPathOptimizer {
     
     public static void main(String[] args) {
        FlightPathOptimizer optimizer = new FlightPathOptimizer();
        optimizer.buildGraph("UAVdata.txt");

        String source = "A";
        Set<String> highRiskLocations = new HashSet<>();
        highRiskLocations.add("C");
        highRiskLocations.add("F");
        highRiskLocations.add("J");

        List<String> itinerary = optimizer.optimizeFlightPath(source, highRiskLocations);

        System.out.println("Optimized Flight Path:");
        for (String location : itinerary) {
            System.out.print(location + " -> ");
        }
        System.out.println("Destination");
    }
 }