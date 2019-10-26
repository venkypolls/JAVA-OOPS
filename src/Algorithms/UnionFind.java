package Algorithms;
import java.util.*;

public class UnionFind {
	//watch tushar roy, union find video to understand better
	public Map<Integer,Node> map = new HashMap<>();
	public class Node{
		public Node parent;
		public int rank;
		public int val;
	}
	
	public void makeSet(int val) {
		Node node= new Node();
		node.val = val;
		node.rank = 0;
		node.parent = node;
		map.put(val, node);
	}
	public void union(int val1, int val2) {
		Node node1 = map.get(val1);
		Node node2 = map.get(val2);
		Node par1 = findSet(node1);
		Node par2 = findSet(node2);
		if(par1.rank > par2.rank) {
			par2.parent = par1;
		}else if(par1.rank == par2.rank){
			par2.parent = par1;
			par1.rank++;
		}else {
			par1.parent = par2;
		}
		
	}
	public Node findSet(Node node) {
		if(node.parent == node)
			return node;
		Node par = findSet(node.parent);
		node.parent = par;
		return par;
		
	}
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind();
		uf.makeSet(1);
		uf.makeSet(2);
		uf.makeSet(3);
		uf.makeSet(4);
		uf.makeSet(5);
		uf.makeSet(6);
		
		uf.union(1, 2);
		uf.union(2, 3);
		uf.union(4, 3);
		uf.union(5, 6);
		
		System.out.println(uf.findSet(uf.map.get(1)).val);
		System.out.println(uf.findSet(uf.map.get(2)).val);
		System.out.println(uf.findSet(uf.map.get(3)).val);
		System.out.println(uf.findSet(uf.map.get(4)).val);
		System.out.println(uf.findSet(uf.map.get(5)).val);
		System.out.println(uf.findSet(uf.map.get(6)).val);
		
	}

}
