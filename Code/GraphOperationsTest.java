import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphOperationsTest {

    
    public void testInsertLocation() {
        // Create a mock input stream with the desired input
        String input = "Location1\n4\n1\nLocation2\n2.5\nLocation3\n3.7\nLocation4\n0.5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Create a mock output stream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method to be tested
        GraphOperations.insertLocation(new Scanner(System.in));

        // Convert the captured output to string and compare it with the expected output
        String expectedOutput = "Location inserted successfully.\n" +
                "Adjacency list:\n" +
                "Location1: Location2(2.5) Location3(3.7) Location4(0.5) \n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    
    public void testDeleteLocation() {
        // Create a mock input stream with the desired input
        String input = "Location2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Create a mock output stream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Prepare the initial graph state
        Map<String, Map<String, Double>> graph = new HashMap<>();
        Map<String, Double> neighbors = new HashMap<>();
        neighbors.put("Location2", 2.5);
        neighbors.put("Location3", 3.7);
        graph.put("Location1", neighbors);

        // Set the graph for testing
        GraphOperations.setGraph(graph);

        // Call the method to be tested
        GraphOperations.deleteLocation(new Scanner(System.in));

        // Convert the captured output to string and compare it with the expected output
        String expectedOutput = "Location deleted successfully.\n" +
                "Adjacency list:\n" +
                "Location1: Location3(3.7) \n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    // Add more tests for other methods as needed

}
