import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Runs unit tests for graph manipulation and operations
public class GraphOperations {
    private static Map<String, Map<String, Double>> graph;

    public static void GraphOperations() {
        graph = new HashMap<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("location.txt"));
            String line = reader.readLine();
            String[] counts = line.split(" ");
            int numEdges = Integer.parseInt(counts[1]);

            for (int i = 0; i < numEdges; i++) {
                line = reader.readLine();
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

            System.out.println("Initial adjacency list:");
            displayAdjacencyList();

            runMenu();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert a location");
            System.out.println("2. Delete a location");
            System.out.println("3. Search for a location");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    insertLocation(scanner);
                    break;
                case 2:
                    deleteLocation(scanner);
                    break;
                case 3:
                    searchLocation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void insertLocation(Scanner scanner) {
        System.out.println("Enter the name of the location to insert:");
        String location = scanner.nextLine();

        if (graph.containsKey(location)) {
            System.out.println("Location already exists in the graph.");
        } else {
            graph.put(location, new HashMap<>());
            System.out.println("Location inserted successfully.");
            displayAdjacencyList();
        }
    }

    static void deleteLocation(Scanner scanner) {
        System.out.println("Enter the name of the location to delete:");
        String location = scanner.nextLine();

        if (!graph.containsKey(location)) {
            System.out.println("Location does not exist in the graph.");
        } else {
            graph.remove(location);
            for (Map<String, Double> neighbors : graph.values()) {
                neighbors.remove(location);
            }
            System.out.println("Location deleted successfully.");
            displayAdjacencyList();
        }
    }

    static void searchLocation(Scanner scanner) {
        System.out.println("Enter the name of the location to search:");
        String location = scanner.nextLine();

        if (graph.containsKey(location)) {
            System.out.println("Location found in the graph.");
            System.out.print("Neighbors: ");
            Map<String, Double> neighbors = graph.get(location);
            for (String neighbor : neighbors.keySet()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        } else {
            System.out.println("Location not found in the graph.");
        }
    }

    static void displayAdjacencyList() {
        System.out.println("Adjacency list:");
        for (String vertex : graph.keySet()) {
            System.out.print(vertex + ": ");
            Map<String, Double> neighbors = graph.get(vertex);
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
            }
            System.out.println();
        }
    }
}
