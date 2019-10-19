package OOPS_learning;

import java.util.*;


public class CollectionsTut {

	public static void main(String[] args) {
		// Collections, Map, Arrays, Collections
		//another file for String and StringBuffer
		

	}
	public static void collection_interface() {
		//collection interface
		Collection temp = new ArrayList();
		//add element to the collection
		temp.add("str");
		//remove an specified element from the collection
		temp.remove("str");
		//size of the collection
		temp.size();
		//if an element contains
		temp.contains("str");
		//check if empty
		temp.isEmpty();
		//to convert to non primitive array
		temp.toArray();
		//check if 2 elements are equal
		temp.equals(temp);
		//to convert to stream
		temp.stream();
		//get an iterator
		temp.iterator();
	}
	
	public static void list() {
		List temp = new LinkedList<>();
		//add element at location
		temp.add(0,"temp");
		//get an element at i'th index
		temp.get(0);
		//returns the index of the first occurrence of the object
		temp.indexOf("temp");
		//returns the index of the last occurrence of the object
		temp.lastIndexOf("temp");
		//sets or updates the value of the index provided
		temp.set(0, "temp1");
		//returns a List from start index to end index
		temp.subList(0,1);
		
		
	}
	public static void stack() {
		Stack st = new Stack();
		//stack extends vector which implements list so it contains all functions of list as well implemented
		//empties the stack
		st.empty();
		//pop gives the top most element
		st.pop();
		//peek lets you see the top most element
		st.peek();
		//push adds a element on top of the stack
		st.push("str");
		//searches a element if found returns its offset from top of the stack
		st.search("str");
		
	}
	public static void map() {
		Map map = new HashMap();
		//clear all objects from the map
		map.clear();
		//contains key in the map
		map.containsKey("str");
		//map contains a specific value
		map.containsValue(5);
		//if 2 maps are equal
		map.equals(new HashMap());
		//get value of a given key
		map.get("str");
		//check if empty
		map.isEmpty();
		//get all the keys in the form of a set
		map.keySet();
		//adding values to map
		map.put("str1", 2);
		//get value if existing or default
		map.getOrDefault(2, 0);
		//map.remove() removes entry at key k
		map.remove("str");
		//size
		map.size();
		//give all values in the form of a collection
		map.values();
		
		
	}
	public static void priorityQ() {
		//initializes a priority queue with capacity 20 and a comparator, below we use a lambda fucntion instead
		PriorityQueue<Integer> pq = new PriorityQueue<>(20, (a,b) -> (b-a));
		//add or offer better use offer
		pq.offer(10);
		//peek lets you see the top most element
		pq.peek();
		//poll removes the last element
		pq.poll();
		//rest it uses collection class methods
		
	}
	public static void hashSet() {
		//same as collections framework
	}
	
	public static void string() {
		String str = new String("string");
		//if 2 strings are equal
		str.equals("string");
		//substring of a string
		str.substring(1,3);
		//char at position
		str.charAt(5);
		//index of a letter
		str.indexOf('k');
		//length of string
		str.length();
		//returns string value of 5
		String.valueOf(5);
		//splits to an string array
		str.split(" ");
		//trims off spaces and extra tabs
		str.trim();
		//string value of integer
		Integer.toString(10);
		//integer value of string
		Integer.parseInt("1234");
		
	}
	public static void stringBuilder() {
		StringBuilder sb = new StringBuilder("stringbuilder");
		//can append almost anything and char array and stringbuilder itself
		sb.append(1);
		//find index of a value from the start index mentioned on the 2nd argument
		sb.indexOf("i",2);
		//insert 1 at position 6
		sb.insert(6, "1");
		//replace position 0,3 with "yo"
		sb.replace(0, 3, "yo");
		//substring
		sb.substring(0,9);
		//delete
		sb.delete(9, 10);
		//length
		sb.length();
		//returns String
		sb.toString();
		//reverse sb
		sb.reverse();
		//returns char at 5
		sb.charAt(5);
		
		
		
	}
}

