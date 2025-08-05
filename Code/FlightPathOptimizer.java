import java.util.*;
import java.io.*;

//Performs unit testing for flight path optimization algorithms
public class FlightPathOptimizer {
    private Map<String, Map<String, Integer>> graph;

    public FlightPathOptimizer() {
        graph = new HashMap<>();
    }

    public void buildGraph(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String start = parts[0];
                int distance = Integer.parseInt(parts[1]);
                int time = Integer.parseInt(parts[2]);

                if (!graph.containsKey(start)) {
                    graph.put(start, new HashMap<>());
                }
                graph.get(start).put("Distance", distance);
                graph.get(start).put("Time", time);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }

    public List<String> optimizeFlightPath(String source, Set<String> highRiskLocations) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }

        distances.put(source, 0);
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentVertex = current.vertex;
            int currentDistance = current.distance;

            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }

            Map<String, Integer> neighbors = graph.get(currentVertex);
            if (neighbors == null) {
                continue;
            }

            for (Map.Entry<String, Integer> neighborEntry : neighbors.entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int distanceToNeighbor = currentDistance + weight;

                if (distanceToNeighbor < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, distanceToNeighbor);
                    previous.put(neighbor, currentVertex);
                    queue.add(new Node(neighbor, distanceToNeighbor));
                }
            }
        }

        List<String> itinerary = new ArrayList<>();
        for (String location : highRiskLocations) {
            if (!previous.containsKey(location)) {
                continue;
            }
            String current = location;
            while (current != null) {
                itinerary.add(0, current);
                current = previous.get(current);
            }
        }

        return itinerary;
    }

    private static class Node {
        private String vertex;
        private int distance;

        public Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.distance, node2.distance);
        }
    }

   
}
