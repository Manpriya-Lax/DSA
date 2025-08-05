import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
//Conducts unit testing for the implementation of a hash table.

public class HashTableimplementation {
    private static Map<String, List<Double>> hashTable;
    public static String A;

    public static void implementation () {
        hashTable = new Hashtable<>();

        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Location for search : ");
         A = scanner.nextLine();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("UAVdata.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String location = "";
                List<Double> data = new ArrayList<>();

                double value = 0;

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == ' ') {
                        if (location.isEmpty()) {
                            location = line.substring(0, i);
                        } else {
                            data.add(value);
                            value = 0;
                        }
                    } else {
                        value = value * 10 + (c - '0');
                    }
                }

                data.add(value);
                hashTable.put(location, data);
            }
            reader.close();

            String searchLocation = A;
            System.out.println("Searching for data at location " + searchLocation);
            List<Double> searchData = searchInHashTable(searchLocation);
            if (searchData != null) {
                System.out.println("Data found: " + searchData);
            } else {
                System.out.println("Data not found for location " + searchLocation);
            }

            // Compare efficiency: Searching through a list or array
            System.out.println("\nComparing Efficiency:");
            compareEfficiency();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Double> searchInHashTable(String location) {
        return hashTable.get(location);
    }

    static void compareEfficiency() {
        List<String> locations = new ArrayList<>(hashTable.keySet());
        String searchLocation = A;

        long startTime = System.nanoTime();
        for (String location : locations) {
            if (location.equals(searchLocation)) {
                List<Double> data = hashTable.get(location);
                System.out.println("Data found using list/array: " + data);
                break;
            }
        }
        long endTime = System.nanoTime();
        long listArrayTime = endTime - startTime;

        startTime = System.nanoTime();
        List<Double> data = hashTable.get(searchLocation);
        if (data != null) {
            System.out.println("Data found using hash table: " + data);
        } else {
            System.out.println("Data not found using hash table");
        }
        endTime = System.nanoTime();
        long hashTableTime = endTime - startTime;

        System.out.println("Time taken using list/array: " + listArrayTime + " nanoseconds");
        System.out.println("Time taken using hash table: " + hashTableTime + " nanoseconds");
    }
}
