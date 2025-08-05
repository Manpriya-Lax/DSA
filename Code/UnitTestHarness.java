
import java.util.*;
public class UnitTestHarness {

public static void main(String []args){
    
    Scanner Sc = new Scanner(System.in);
    
    System.out.println("-----------------------------------");
    System.out.println("Welcome to the UAV Bushfire minitor");
    System.out.println("-----------------------------------");
    System.out.println();
    
    System.out.println("task :1 =GraphConstruction.java");
    System.out.println("task :2 =GraphTraversal.java" );
    System.out.println("task :3 =GraphOperations.java" );
    System.out.println("task :4 =HashTableImplementation.java" );
    System.out.println("task :5 =HeapUsage.java" );
    System.out.println("task :6 =FlightPathOptimizer.java" );
    System.out.println("task :7 =BushfireRiskAnalyzer.java ");
    
    System.out.println();
    System.out.print("Enter the number ");
    int n = Sc.nextInt();
    
    System.out.println();
    
    switch (n) {              
            case 1 :
                    {
                        UnitTestGraphConstruction graph = new UnitTestGraphConstruction();
                        graph.main(args);
                        break;
                    }
            case 2:{
                 UnitTestGraphTraversal Traversal = new UnitTestGraphTraversal();
                        Traversal.main(args);
                        break;
            }
            
            case 3: {
                UnitTestGraphOperations Operation =new UnitTestGraphOperations();
                Operation.main(args);
                break;
            }
            
            case 4:{
                UnitTestHashTableimplementation HashTable = new UnitTestHashTableimplementation();
                        HashTable.main(args);
                        break;
                
                
            }
            
            case 5:{
                 UnitTestHeap heap= new UnitTestHeap();
                        heap.main(args);
                        break;
                
                
            }
            case 6:{
                 UnitTestFlightPathOptimizer optimizer= new UnitTestFlightPathOptimizer();
                        optimizer.main(args);
                
                        break;
                
            }
            case 7:{
                 UnitTestBushfireRiskAnalyzer analyzer= new UnitTestBushfireRiskAnalyzer();
                        analyzer.main(args);
                        break;
                
                
            }
                
                    }
    
    
    
    
    




}
}