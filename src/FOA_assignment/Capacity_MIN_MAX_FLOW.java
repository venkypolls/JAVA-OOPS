package FOA_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class Node{
	String airline_name;
	String from;
	String to;
	String departure;
	String arrival;
	String flight_no;
	int capacity;
	List<Node> connected;
	List<Integer> capacities;
	
	Node(String from, String to, String departure, String arrival,String flight_no,String name){
		this.airline_name = name;
		this.from = from;
		this.to = to;
		this.departure = departure;
		this.arrival = arrival;
		this.flight_no = flight_no;
		getCapacity(flight_no);
	}
	Node(){}
	
	private static Map<String,Integer> capacityMap;
    static{
     capacityMap= new HashMap<>();
     capacityMap.put("a319",128);
     capacityMap.put("a220",105);
     capacityMap.put("a319",128);
     capacityMap.put("a320", 150);
     capacityMap.put("a321", 185);
     capacityMap.put("a321neo",196);
     capacityMap.put("a330", 230);
     capacityMap.put("a330-200", 230);
     capacityMap.put("a330-300",290);
     capacityMap.put("a330-900neo",280);
     capacityMap.put("a350",300);
     capacityMap.put("a350-900",300);
     capacityMap.put("717",110);
     capacityMap.put("717-200",110);
     capacityMap.put("737",126);
     capacityMap.put("737-700",126);
     capacityMap.put("737-800",165);
     capacityMap.put("737-900",180);
     capacityMap.put("737-900er",180);
     capacityMap.put("737-max 9",180);
     capacityMap.put("757",180);
     capacityMap.put("757-200",180);
     capacityMap.put("757-300",230);
     capacityMap.put("767",200);
     capacityMap.put("767-300",200);
     capacityMap.put("767-300er",225);
     capacityMap.put("767-400er",240);
     capacityMap.put("777",270);
     capacityMap.put("777-200",270);
     capacityMap.put("777-200er",270);
     capacityMap.put("777-200lr",280);
     capacityMap.put("777-300",300);
     capacityMap.put("787",235);
     capacityMap.put("787-8",235);
     capacityMap.put("787-9",280);
     capacityMap.put("embraer 170",72);
     capacityMap.put("embraer 175",78);
     capacityMap.put("embraer 190",100);
     capacityMap.put("mcdonnell douglas md - 88",150);
     capacityMap.put("mcdonnell douglas md -88",150);
     capacityMap.put("mcdonnell douglas md - 90",150);
     capacityMap.put("mcdonnell douglas md -90",150);
     capacityMap.put("mcdonnell douglas md - 90-30",150);
     capacityMap.put("crj",75);
     capacityMap.put("crj",75);
             }

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
	         this.capacity=capacityMap.getOrDefault(m,150);        
	//System.out.println(capacity);
	         
	}


	
}
//class City{
//	List<Node> incoming;
//	List<Node> outgoing;
//	City(List<Node> outgoing){
//		this.outgoing = outgoing;
//	}
//}
public class Capacity_MIN_MAX_FLOW {

	
	
	public static void main(String[] args) {
		List<Node> lax = new ArrayList<>();
		List<Node> sfo = new ArrayList<>();
		List<Node> phx = new ArrayList<>();
		List<Node> sea = new ArrayList<>();
		List<Node> den = new ArrayList<>();
		List<Node> atl = new ArrayList<>();
		List<Node> ord = new ArrayList<>();
		List<Node> bos = new ArrayList<>();
		List<Node> iad = new ArrayList<>();
		List<Node> allFlights = new ArrayList<>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/venkateshpolepally/PycharmProjects/FOA scrapping/flights_new.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        Node node = new Node(values[0],values[1],values[2],values[3],values[4],values[5]);
		        if(values[0].equals("LAX"))
		        	lax.add(node);	
		        else if(values[0].equals("SFO"))
		        	sfo.add(node);
		        else if(values[0].equals("PHX"))
		        	phx.add(node);
		        else if(values[0].equals("SEA"))
		        	sea.add(node);
		        else if(values[0].equals("DEN"))
		        	den.add(node);
		        else if(values[0].equals("ATL"))
		        	atl.add(node);
		        else if(values[0].equals("ORD"))
		        	ord.add(node);
		        else if(values[0].equals("BOS"))
		        	bos.add(node);
		        else if(values[0].equals("IAD"))
		        	iad.add(node); 
		        
		        allFlights.add(node);
		    }
//		    System.out.println(lax.size());
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		Node source = new Node();
		Node sink = new Node();
		//testing print
//		for(int i=0;i<allFlights.size();i++) {
//			System.out.println(allFlights.get(i).capacity);
//		}
		
		
		Map<Node,Integer> map = new HashMap<>();
		Map<Integer,Node> map_rev = new HashMap<>();
		map_rev.put(0,source);
		map.put(source,0);
		int count =1;
		for(int i=0;i<allFlights.size();i++) {
			map.put(allFlights.get(i),count);
			map_rev.put(count,allFlights.get(i));
			count++;
		}
		map.put(sink,count);
		map_rev.put(count,sink);
		
	
		
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<allFlights.size()+2;i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<allFlights.size()+2;j++)
				list.add(0);
			adj.add(list);
		}
		
		for(int i=0;i<lax.size();i++) {
			adj.get(0).set(map.get(lax.get(i)), lax.get(i).capacity);
		}
		//testing print
//		/System.out.println(adj.get(0));
//				for(int i=0;i<adj.size();i++) {
//					System.out.println(i);
//					System.out.println("#################");
//					System.out.println(adj.get(i));
//				}
		
		for(int i=1;i<adj.size()-1;i++) {
			Node node = map_rev.get(i);
			if(node.to.equals("JFK")) {
				adj.get(i).set(adj.size()-1, node.capacity);
				
			}
			if(node.to.equals("SFO")) {
				for(int j=0;j<sfo.size();j++) {
					if(timeComparison(node.arrival,sfo.get(j).departure)) {
						adj.get(i).set(map.get(sfo.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("PHX")) {
				for(int j=0;j<phx.size();j++) {
					if(timeComparison(node.arrival,phx.get(j).departure)) {
						adj.get(i).set(map.get(phx.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("SEA")) {
				for(int j=0;j<sea.size();j++) {
					if(timeComparison(node.arrival,sea.get(j).departure)) {
						adj.get(i).set(map.get(sea.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("DEN")) {
				for(int j=0;j<den.size();j++) {
					if(timeComparison(node.arrival,den.get(j).departure)) {
						adj.get(i).set(map.get(den.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("ATL")) {
				for(int j=0;j<atl.size();j++) {
					if(timeComparison(node.arrival,atl.get(j).departure)) {
						adj.get(i).set(map.get(atl.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("ORD")) {
				for(int j=0;j<ord.size();j++) {
					if(timeComparison(node.arrival,ord.get(j).departure)) {
						adj.get(i).set(map.get(ord.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("BOS")) {
				for(int j=0;j<bos.size();j++) {
					if(timeComparison(node.arrival,bos.get(j).departure)) {
						adj.get(i).set(map.get(bos.get(j)), node.capacity);
					}
				}
			}else if(node.to.equals("IAD")) {
				for(int j=0;j<iad.size();j++) {
					if(timeComparison(node.arrival,iad.get(j).departure)) {
						adj.get(i).set(map.get(iad.get(j)), node.capacity);
					}
				}
			}
			
		}
//		testing print
//		for(int i=0;i<adj.size();i++) {
//			System.out.println(adj.get(i).toString());
//		}
		
		//code for ford fulkerson's
		MaxFlow m = new MaxFlow(); 
		m.V = adj.size();
		System.out.println("The maximum possible flow is " + 
						m.fordFulkerson(adj, 0, adj.size()-1)); 
		
	}

	public static boolean timeComparison(String arrival,String dept) {
		String[] arrivalArr = arrival.split(":");
        String[] deptArr = dept.split(":");
        //chk hour
        if(Integer.valueOf(arrivalArr[0])>Integer.valueOf(deptArr[0]))
            return false;
        else
            if(Integer.valueOf(arrivalArr[1])>Integer.valueOf(deptArr[1]))        //chk min
                return false;
        return true;
	}
}
