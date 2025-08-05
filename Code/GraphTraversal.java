import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Executes unit tests related to graph traversal operations
public class GraphTraversal {
    public static void GraphTraversal() {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        Map<String, List<Pair<String, Double>>> adjacencyList = new HashMap<>();
        Map<String, String> dataMap = new HashMap<>();

        BufferedReader locationReader = null;
        BufferedReader dataReader = null;
        try {
            locationReader = new BufferedReader(new FileReader("location.txt"));
            dataReader = new BufferedReader(new FileReader("UAVdata.txt"));

            String line = locationReader.readLine();
            String[] counts = line.split(" ");
            int numEdges = Integer.parseInt(counts[1]);

            for (int i = 0; i < numEdges; i++) {
                line = locationReader.readLine();
                String[] parts = line.split(" ");
                String start = parts[0];
                String end = parts[1];
                double weight = Double.parseDouble(parts[2]);

                if (!graph.containsKey(start)) {
                    graph.put(start, new HashMap<>());
                }
                if (!graph.containsKey(end)) {
                    graph.put(end, new HashMap<>());
                }
                graph.get(start).put(end, weight);
                graph.get(end).put(start, weight);
            }

            while ((line = dataReader.readLine()) != null) {
                String[] parts = line.split(" ");
                String location = parts[0];
                String data = parts[1] + " " + parts[2] + " " + parts[3];
                dataMap.put(location, data);
            }

            for (String vertex : graph.keySet()) {
                List<Pair<String, Double>> connections = new ArrayList<>();
                for (Map.Entry<String, Double> entry : graph.get(vertex).entrySet()) {
                    connections.add(new Pair<>(entry.getKey(), entry.getValue()));
                }
                adjacencyList.put(vertex, connections);
            }

            // Run BFS and DFS
            String sourceLocation = "A";  
            String destinationLocation = "G";  

            System.out.println("Shortest path from " + sourceLocation + " to " + destinationLocation + ":");
            List<String> bfsPath = bfs(graph, sourceLocation, destinationLocation, dataMap);
            if (bfsPath != null) {
                for (String location : bfsPath) {
                    String data = dataMap.get(location);
                    System.out.println("Location: " + location + ", Data: " + data);
                }
            } else {
                System.out.println("No path found.");
            }

            System.out.println();

            System.out.println("DFS traversal from " + sourceLocation + ":");
            Set<String> visited = new HashSet<>();
            dfs(adjacencyList, sourceLocation, visited, dataMap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (locationReader != null) {
                try {
                    locationReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dataReader != null) {
                try {
                    dataReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static List<String> bfs(Map<String, Map<String, Double>> graph, String source, String destination, Map<String, String> dataMap) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> initialPath = new ArrayList<>();
        initialPath.add(source);
        queue.offer(initialPath);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String currentLocation = path.get(path.size() - 1);

            if (currentLocation.equals(destination)) {
                return path;
            }

            if (!visited.contains(currentLocation)) {
                visited.add(currentLocation);

                Map<String, Double> neighbors = graph.get(currentLocation);

                if (neighbors != null) {
                    for (String neighbor : neighbors.keySet()) {
                        if (!visited.contains(neighbor)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(neighbor);
                            queue.offer(newPath);
                        }
                    }
                }
            }
        }

        return null;
    }

    static void dfs(Map<String, List<Pair<String, Double>>> adjacencyList, String vertex, Set<String> visited, Map<String, String> dataMap) {
        visited.add(vertex);
        System.out.println("Location: " + vertex + ", Data: " + dataMap.get(vertex));

        List<Pair<String, Double>> connections = adjacencyList.get(vertex);
        if (connections != null) {
            for (Pair<String, Double> connection : connections) {
                String connectedVertex = connection.first;
                if (!visited.contains(connectedVertex)) {
                    dfs(adjacencyList, connectedVertex, visited, dataMap);
                }
            }
        }
    }

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
