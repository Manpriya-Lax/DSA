import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Performs unit testing for graph construction functionality.
public class GraphConstruction {
    public static void GraphConstruction() {
        Map<String, Map<String, Double>> graph = new HashMap<>();

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

            for (String vertex : graph.keySet()) {
                System.out.print(vertex + ": ");
                Map<String, Double> neighbors = graph.get(vertex);
                for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                    System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
                }
                System.out.println();
            }
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
}
