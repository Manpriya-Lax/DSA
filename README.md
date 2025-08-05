# DSA
This Project contains a main method that allows the user to select and execute various unit tests related to UAV (Unmanned Aerial Vehicle) bushfire monitoring .

*Prerequisites*

Before running the program, make sure you have the following prerequisites installed on your system:

Java Development Kit (JDK)
Java Runtime Environment (JRE)

_____________________________________________________________________________________

Unit Test Harness

This program can run all following java files – 
GraphConstruction.java
GraphTraversal.java
GraphOperations.java
HashTableImplementation.java
HeapUsage.java
FlightPathOptimizer.java
BushfireRiskAnalyzer.java

 *Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestHarness.java" file is located.

	$ cd /path/to/UnitTestHarness.java

Compile the Java file using the javac command:
	$ javac UnitTestHarness.java

This will generate the compiled bytecode file, "UnitTestHarness.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestHarness.java

This will execute the program and display the output on the console.

*Note: Make sure the input files follow the specified formats ("location.txt" and "UAVdata.txt") and are correctly named in the same directory as the Java file before running the program .


_____________________________________________________________________________________
task :1 =GraphConstruction.java

*This is a simple Java program that reads data from a file, constructs a graph, and prints the adjacency list representation of the graph .

*Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestGraphConstruction.java" file is located.

	$ cd /path/to/UnitTestGraphConstruction.java

Compile the Java file using the javac command:
	$ javac UnitTestGraphConstruction.java

This will generate the compiled bytecode file, "UnitTestGraphConstruction.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestGraphConstruction.java

This will execute the program and display the output on the console.

*Note: Make sure the input file follows the specified format and is correctly named as "location.txt" in the same directory as the Java file before running the program.

_____________________________________________________________________________________

task :2 =GraphTraversal.java

*This Java program that performs graph traversal algorithms, namely Breadth-First Search (BFS) and Depth-First Search (DFS), on a graph represented by adjacency lists. The program reads data from two input files ("location.txt" and "UAVdata.txt"), constructs the graph, and performs BFS and DFS traversal.

*Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestGraphTraversal.java" file is located.

	$ cd /path/to/UnitTestGraphTraversal.java

Compile the Java file using the javac command:
	$ javac UnitTestGraphTraversal.java

This will generate the compiled bytecode file, "UnitTestGraphTraversal.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestGraphTraversal.java

This will execute the program and display the output on the console.

*Note: Make sure the input files follow the specified formats ("location.txt" for graph edges and weights , and "UAVdata.txt" for location-data associations) and are correctly named in the same directory as the Java file before running the program .
_____________________________________________________________________________________

task :3 =GraphOperations.java 

*Compiling the Code*

*This program that allows you to perform basic operations on a graph, such as inserting a location, deleting a location, and searching for a location . The program reads the initial graph structure from an input file ( "location.txt" ) and provides a menu-driven interface for interacting with the graph


Open a command prompt or terminal.

Navigate to the directory where the "UnitTestGraphOperations.java" file is located.

	$ cd /path/to/UnitTestGraphOperations.java

Compile the Java file using the javac command:
	$ javac UnitTestGraphOperations.java

This will generate the compiled bytecode file, "UnitTestGraphOperations.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestGraphOperations.java

This will execute the program and display the output on the console.

*Note: The program assumes the input file "location.txt" follows a specific format and is correctly named in the same directory as the Java file.
_____________________________________________________________________________________

task :4 =HashTableImplementation.java 

*This Java program that demonstrates the implementation of a hash table using the Hashtable class. The program reads data from an input file ("UAVdata.txt") and stores it in the hash table. It also provides a method to search for data based on a given location and compares the efficiency of searching through a list/array versus a hash table.


*Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestHashTableImplementation.java" file is located.

	$ cd /path/to/UnitTestHashTableImplementation.java

Compile the Java file using the javac command:
	$ javac UnitTestHashTableImplementation.java

This will generate the compiled bytecode file, "UnitTestHashTableImplementation.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestHashTableImplementation.java

This will execute the program and display the output on the console.
*Note: The program assumes the input file "UAVdata.txt" follows a specific format and is correctly named in the same directory as the Java file.
_____________________________________________________________________________________

task :5 =Heap.java

*This Java program that demonstrates the usage of a heap data structure. It includes a Heap class that implements a max heap, allowing for the insertion, updating, deletion, and printing of areas with high-risk values. The program initializes a heap, inserts areas with their corresponding risk values , performs updates on risk values, deletes an area , and prints the areas with high risk values.


*Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestHeap.java" file is located.

	$ cd /path/to/UnitTestHeap.java

Compile the Java file using the javac command:
	$ javac UnitTestHeap.java

This will generate the compiled bytecode file, "UnitTestHeap.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestHeap.java

This will execute the program and display the output on the console.

*Note: The program assumes that the provided heap implementation is correct and functioning as expected. The risk threshold for determining high-risk areas is set to a value greater than 40.
_____________________________________________________________________________________

task :6 =FlightPathOptimizer.java

*This Java program that optimizes a flight path based on a graph representation. It uses Dijkstra's algorithm to find the shortest path from a given source location to a destination while avoiding high-risk locations. The program builds a graph from a specified file, performs the flight path optimization, and outputs the optimized flight path.


*Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestFlightPathOptimizer.java" file is located.

	$ cd /path/to/UnitTestFlightPathOptimizer.java

Compile the Java file using the javac command:
	$ javac GraphOperations.java

This will generate the compiled bytecode file, "UnitTestFlightPathOptimizer.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestFlightPathOptimizer.java

This will execute the program and display the output on the console.

*Note: The program assumes that the provided graph file is correctly formatted and contains valid data. Additionally, it assumes that the graph is connected, meaning there is a valid path from the source to any other location in the graph.
_____________________________________________________________________________________

task :7 =BushfireRiskAnalyzer.java 

*The provided code is a Java program that analyzes bushfire risk data collected by Unmanned Aerial Vehicles (UAVs). It allows users to load UAV data files, analyze the data, and obtain optimized flight itineraries for mitigating bushfire risks in high-risk locations.

*Compiling the Code*

Open a command prompt or terminal.

Navigate to the directory where the "UnitTestBushfireRiskAnalyzer.java" file is located.

	$ cd /path/to/UnitTestBushfireRiskAnalyzer.java

Compile the Java file using the javac command:
	$ javac UnitTestBushfireRiskAnalyzer.java

This will generate the compiled bytecode file, "UnitTestBushfireRiskAnalyzer.class".

*Running the Program*

After successfully compiling the code, run the program using the java command:
	$ java UnitTestBushfireRiskAnalyzer.java

This will execute the program and display the output on the console.


*Note: Ensure that the UAV data files are correctly formatted and contain valid data in order to obtain accurate results.
_____________________________________________________________________________________


