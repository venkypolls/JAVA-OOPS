package Amazon;
import java.util.Arrays;
import java.util.*;
import Algorithms.UnionFind;



public class MinCostToConnectAllNodes {

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{1, 4}, {4, 5}, {2, 3}}; 
		int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
		Arrays.sort(newEdges, (a,b) -> (a[2]-b[2]));
		
		UnionFind uf = new UnionFind();
		for(int i=1;i<=n;i++) {
			uf.makeSet(i);
		}
		
		for(int[] x:edges) {
			uf.union(x[0], x[1]);
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=n;i++) {
			set.add(uf.findSet(uf.map.get(i)).val);
		}
		int j = 1;
		int k =0;
		int cost = 0;
		while(j<set.size()) {
			if(uf.findSet(uf.map.get(newEdges[k][0])) != uf.findSet(uf.map.get(newEdges[k][1]))) {
//				uf.union(newEdges[k][0],newEdges[k][1]);
				cost+=newEdges[k][2];
				j++;
			}
			k++;
		}
		System.out.println(cost);
	}

}
