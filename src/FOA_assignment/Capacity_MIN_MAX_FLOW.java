package FOA_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//Edmond-karp algorithm
class MaxFlow_Ford_Fulkerson 
{ 
	static int V; //Number of vertices in graph 

	/* Returns true if there is a path from source 's' to sink 
	't' in residual graph. Also fills parent[] to store the 
	path */
	boolean bfs(int[][] rGraph, int s, int t, int parent[]) 
	{ 
		// Create a visited array and mark all vertices as not 
		// visited 
		boolean visited[] = new boolean[V]; 
		for(int i=0; i<V; ++i) 
			visited[i]=false; 

		// Create a queue, enqueue source vertex and mark 
		// source vertex as visited 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(s); 
		visited[s] = true; 
		parent[s]=-1; 
		
		// Standard BFS Loop 
		while (queue.size()!=0){ 
			int u = queue.poll(); 
			for (int v=0; v<V; v++){ 
				if (visited[v]==false && rGraph[u][v] > 0){ 
					queue.add(v); 
					parent[v] = u; 
					visited[v] = true; 
				} 
			} 
		} 
		// If we reached sink in BFS starting from source, then 
		// return true, else false 
		return (visited[t] == true); 
	} 
	// Returns tne maximum flow from s to t in the given graph 
	int fordFulkerson(List<List<Integer>> graph, int s, int t) 
	{ 
		int u, v; 

		// Create a residual graph and fill the residual graph 
		// with given capacities in the original graph as 
		// residual capacities in residual graph 

		// Residual graph where rGraph[i][j] indicates 
		// residual capacity of edge from i to j (if there 
		// is an edge. If rGraph[i][j] is 0, then there is 
		// not) 
		int rGraph[][] = new int[V][V]; 
		for (u = 0; u < V; u++) 
			for (v = 0; v < V; v++) 
				rGraph[u][v] = graph.get(u).get(v); 
		// This array is filled by BFS and to store path 
		int parent[] = new int[V]; 
		int max_flow = 0; // There is no flow initially 

		// Augment the flow while tere is path from source 
		// to sink 
		while (bfs(rGraph, s, t, parent)){ 
			// Find minimum residual capacity of the edhes 
			// along the path filled by BFS. Or we can say 
			// find the maximum flow through the path found. 
			int path_flow = Integer.MAX_VALUE; 
			for (v=t; v!=s; v=parent[v]){ 
				u = parent[v]; 
				path_flow = Math.min(path_flow, rGraph[u][v]); 
			} 
			// update residual capacities of the edges and 
			// reverse edges along the path 
			for (v=t; v != s; v=parent[v]){ 
				u = parent[v]; 
				rGraph[u][v] -= path_flow; 
				rGraph[v][u] += path_flow; 
			} 
			// Add path flow to overall flow 
			max_flow += path_flow; 
		} 
		// Return the overall flow 
		return max_flow; 
	} 
} 

class Flight_Node{
	// flight node having all the required details as attributes
	String airline_name;
	String from;
	String to;
	String departure;
	String arrival;
	String flight_no;
	int capacity;
	
	//constructor for flight_node
	Flight_Node(String from, String to, String departure, String arrival,String flight_no,String name){
		this.airline_name = name;
		this.from = from;
		this.to = to;
		this.departure = departure;
		this.arrival = arrival;
		this.flight_no = flight_no;
		getCapacity(flight_no);
	}
	Flight_Node(){}
	
	//capacities map
	private static Map<String,Integer> airlineCapacityMap;
    static{
     airlineCapacityMap= new HashMap<>();
     airlineCapacityMap.put("a319",128);
     airlineCapacityMap.put("a220",105);
     airlineCapacityMap.put("a319",128);
     airlineCapacityMap.put("a320", 150);
     airlineCapacityMap.put("a321", 185);
     airlineCapacityMap.put("a321neo",196);
     airlineCapacityMap.put("a330", 230);
     airlineCapacityMap.put("a330-200", 230);
     airlineCapacityMap.put("a330-300",290);
     airlineCapacityMap.put("a330-900neo",280);
     airlineCapacityMap.put("a350",300);
     airlineCapacityMap.put("a350-900",300);
     airlineCapacityMap.put("717",110);
     airlineCapacityMap.put("717-200",110);
     airlineCapacityMap.put("737",126);
     airlineCapacityMap.put("737-700",126);
     airlineCapacityMap.put("737-800",165);
     airlineCapacityMap.put("737-900",180);
     airlineCapacityMap.put("737-900er",180);
     airlineCapacityMap.put("737-max 9",180);
     airlineCapacityMap.put("757",180);
     airlineCapacityMap.put("757-200",180);
     airlineCapacityMap.put("757-300",230);
     airlineCapacityMap.put("767",200);
     airlineCapacityMap.put("767-300",200);
     airlineCapacityMap.put("767-300er",225);
     airlineCapacityMap.put("767-400er",240);
     airlineCapacityMap.put("777",270);
     airlineCapacityMap.put("777-200",270);
     airlineCapacityMap.put("777-200er",270);
     airlineCapacityMap.put("777-200lr",280);
     airlineCapacityMap.put("777-300",300);
     airlineCapacityMap.put("787",235);
     airlineCapacityMap.put("787-8",235);
     airlineCapacityMap.put("787-9",280);
     airlineCapacityMap.put("embraer 170",72);
     airlineCapacityMap.put("embraer 175",78);
     airlineCapacityMap.put("embraer 190",100);
     airlineCapacityMap.put("mcdonnell douglas md - 88",150);
     airlineCapacityMap.put("mcdonnell douglas md -88",150);
     airlineCapacityMap.put("mcdonnell douglas md - 90",150);
     airlineCapacityMap.put("mcdonnell douglas md -90",150);
     airlineCapacityMap.put("mcdonnell douglas md - 90-30",150);
     airlineCapacityMap.put("crj",75);
     airlineCapacityMap.put("crj",75);
             }
    //mapping the given data with the capacities
	public void getCapacity(String model){
	      String m=null;
	     model=model.toLowerCase();  
	         if(model.contains("douglas")||model.contains("md"))
	             m="mcdonnell douglas md ".concat(model.substring(model.indexOf("-")));
	         else if(model.startsWith("boeing"))
	             m=model.substring(7);
	         else if(model.startsWith("airbus"))
	             m=model.substring(7);
	         else if(model.startsWith("canadair regional jet"))
	             m="crj";
	         else
	             m=model;
	         this.capacity=airlineCapacityMap.getOrDefault(m,200);                 
	}


	
}

public class Capacity_MIN_MAX_FLOW {

	
	
	public static void main(String[] args) {
		//lists of all flights starting at their respective airports
		List<Flight_Node> lax = new ArrayList<>();
		List<Flight_Node> sfo = new ArrayList<>();
		List<Flight_Node> phx = new ArrayList<>();
		List<Flight_Node> sea = new ArrayList<>();
		List<Flight_Node> den = new ArrayList<>();
		List<Flight_Node> atl = new ArrayList<>();
		List<Flight_Node> ord = new ArrayList<>();
		List<Flight_Node> bos = new ArrayList<>();
		List<Flight_Node> iad = new ArrayList<>();
		List<Flight_Node> allFlights = new ArrayList<>();
		
		//read all data from the csv and put it into the respective lists and all_flights list
		
		//************* please plug in the csv path here and run the file ***************
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/venkateshpolepally/education/foa/final_project/data.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        Flight_Node Flight_Node = new Flight_Node(values[0],values[1],values[2],values[3],values[4],values[5]);
		        if(values[0].equals("LAX"))
		        	lax.add(Flight_Node);	
		        else if(values[0].equals("SFO"))
		        	sfo.add(Flight_Node);
		        else if(values[0].equals("PHX"))
		        	phx.add(Flight_Node);
		        else if(values[0].equals("SEA"))
		        	sea.add(Flight_Node);
		        else if(values[0].equals("DEN"))
		        	den.add(Flight_Node);
		        else if(values[0].equals("ATL"))
		        	atl.add(Flight_Node);
		        else if(values[0].equals("ORD"))
		        	ord.add(Flight_Node);
		        else if(values[0].equals("BOS"))
		        	bos.add(Flight_Node);
		        else if(values[0].equals("IAD"))
		        	iad.add(Flight_Node); 
		        
		        allFlights.add(Flight_Node);
		    }

		}catch (Exception e) {
	        e.printStackTrace();
	    }
		
		// ******* MAKE GRAPH ***********
		
		//making a dummy source and sink nodes to connect all flights to them
		Flight_Node source = new Flight_Node();
		Flight_Node sink = new Flight_Node();

		//mapping the node to an integer id for forming the adjacency matrix
		Map<Flight_Node,Integer> map = new HashMap<>();
		// reverse mapping the integer to a node to retrieve a node based on an adjacency matrix value
		Map<Integer,Flight_Node> map_rev = new HashMap<>();
		//making the first value in map as source
		map_rev.put(0,source);
		map.put(source,0);
		int count =1;
		//rest of the flights are given an id
		for(int i=0;i<allFlights.size();i++) {
			map.put(allFlights.get(i),count);
			map_rev.put(count,allFlights.get(i));
			count++;
		}
		//last as sink
		map.put(sink,count);
		map_rev.put(count,sink);
		
	
		//initializing a 2d matrix of size (n=number of flights) {n+2 * n+2} 2 - source and sink
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<allFlights.size()+2;i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<allFlights.size()+2;j++)
				list.add(0);
			adj.add(list);
		}
		//base condition of forming the graph from source to all flights leaving from the source
		for(int i=0;i<lax.size();i++) {
			adj.get(0).set(map.get(lax.get(i)), lax.get(i).capacity);
		}

		
		
		//connecting flights to other flights if the arrival time is <= departure time.
		for(int i=1;i<adj.size()-1;i++) {
			Flight_Node Flight_Node = map_rev.get(i);
			if(Flight_Node.to.equals("JFK")) {
				adj.get(i).set(adj.size()-1, Flight_Node.capacity);	
			}
			if(Flight_Node.to.equals("SFO")) {
				for(int j=0;j<sfo.size();j++) {
					if(timeComparison(Flight_Node.arrival,sfo.get(j).departure)) {
						adj.get(i).set(map.get(sfo.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("ORD")) {
				for(int j=0;j<ord.size();j++) {
					if(timeComparison(Flight_Node.arrival,ord.get(j).departure)) {
						adj.get(i).set(map.get(ord.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("PHX")) {
				for(int j=0;j<phx.size();j++) {
					if(timeComparison(Flight_Node.arrival,phx.get(j).departure)) {
						adj.get(i).set(map.get(phx.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("BOS")) {
				for(int j=0;j<bos.size();j++) {
					if(timeComparison(Flight_Node.arrival,bos.get(j).departure)) {
						adj.get(i).set(map.get(bos.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("IAD")) {
				for(int j=0;j<iad.size();j++) {
					if(timeComparison(Flight_Node.arrival,iad.get(j).departure)) {
						adj.get(i).set(map.get(iad.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("SEA")) {
				for(int j=0;j<sea.size();j++) {
					if(timeComparison(Flight_Node.arrival,sea.get(j).departure)) {
						adj.get(i).set(map.get(sea.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("DEN")) {
				for(int j=0;j<den.size();j++) {
					if(timeComparison(Flight_Node.arrival,den.get(j).departure)) {
						adj.get(i).set(map.get(den.get(j)), Flight_Node.capacity);
					}
				}
			}else if(Flight_Node.to.equals("ATL")) {
				for(int j=0;j<atl.size();j++) {
					if(timeComparison(Flight_Node.arrival,atl.get(j).departure)) {
						adj.get(i).set(map.get(atl.get(j)), Flight_Node.capacity);
					}
				}
			}
			
		}

		//code for ford fulkerson's
		MaxFlow_Ford_Fulkerson m = new MaxFlow_Ford_Fulkerson(); 
		m.V = adj.size();
		System.out.println("The maximum possible flow is " + 
						m.fordFulkerson(adj, 0, adj.size()-1)); 
		
	}

	//comparing if the arrival time of one flight is prior to the departure of another flight from the same location
	public static boolean timeComparison(String arrival,String dept) {
		String[] arrivalArr = arrival.split(":");
        String[] deptArr = dept.split(":");
        //check hour
        if(Integer.valueOf(arrivalArr[0])>Integer.valueOf(deptArr[0]))
            return false;
      //check minutes
        else if(Integer.valueOf(arrivalArr[0])==Integer.valueOf(deptArr[0]) && Integer.valueOf(arrivalArr[1])>=Integer.valueOf(deptArr[1]))        
        	
                return false;
        return true;
	}
}
