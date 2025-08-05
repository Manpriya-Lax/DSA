import java.util.HashMap;
import java.util.Map;

//Executes unit tests related to heap data structure usage.
public class Heap {
    private static final int MAX_SIZE = 100;
    private int size;
    private int[] heap;
    private String[] areas;
    private double[] risks;
    private Map<String, Integer> indexMap;
    
    public Heap() {
        size = 0;
        heap = new int[MAX_SIZE];
        areas = new String[MAX_SIZE];
        risks = new double[MAX_SIZE];
        indexMap = new HashMap<>();
    }
    
    public void insert(String area, double risk) {
        if (size >= MAX_SIZE) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }
        
        size++;
        int index = size;
        heap[index] = size;
        areas[index] = area;
        risks[index] = risk;
        indexMap.put(area, index);
        
        heapifyUp(index);
    }
    
    public void updateRisk(String area, double newRisk) {
        if (!indexMap.containsKey(area)) {
            System.out.println("Area not found in the heap.");
            return;
        }
        
        int index = indexMap.get(area);
        double currentRisk = risks[index];
        risks[index] = newRisk;
        
        if (newRisk > currentRisk) {
            heapifyDown(index);
        } else {
            heapifyUp(index);
        }
    }
    
    public void delete(String area) {
        if (!indexMap.containsKey(area)) {
            System.out.println("Area not found in the heap.");
            return;
        }
        
        int index = indexMap.get(area);
        swap(index, size);
        size--;
        
        heapifyDown(index);
        
        indexMap.remove(area);
    }
    
    public void printAreasWithHighRisk() {
        System.out.println("Areas with high risk of bushfires:");
        
        for (int i = 1; i <= size; i++) {
            if (risks[i] > 40) {
                System.out.println(areas[i]);
            }
        }
    }
    
    private void heapifyUp(int index) {
        while (index > 1 && risks[index] > risks[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    
    private void heapifyDown(int index) {
        while (true) {
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);
            int largest = index;
            
            if (leftChild <= size && risks[leftChild] > risks[largest]) {
                largest = leftChild;
            }
            
            if (rightChild <= size && risks[rightChild] > risks[largest]) {
                largest = rightChild;
            }
            
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }
    
    private int parent(int index) {
        return index / 2;
    }
    
    private int leftChild(int index) {
        return 2 * index;
    }
    
    private int rightChild(int index) {
        return 2 * index + 1;
    }
    
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
        
        indexMap.put(areas[index1], index2);
        indexMap.put(areas[index2], index1);
    }
}

