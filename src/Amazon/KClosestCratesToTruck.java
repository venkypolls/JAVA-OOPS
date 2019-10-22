package Amazon;

import java.util.PriorityQueue;

public class KClosestCratesToTruck {

	public static void main(String[] args) {
		int[][] crates = {{1,2},{3,4},{1,-1}};
		int capacity = 2;
		kClosest(crates,capacity);

	}
public static void kClosest(int[][] crates, int K) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<> (K, (int[] a, int[] b ) ->
                 ((b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]))
            
        );
        for(int i=0;i<K;i++){
            pq.add(crates[i]);
        }
        for(int i=K;i<crates.length;i++){
            if(crates[i][0]*crates[i][0] + crates[i][1]*crates[i][1] < pq.peek()[0]* pq.peek()[0] + pq.peek()[1]*pq.peek()[1]){
                pq.poll();
                pq.add(crates[i]);
            }
        }
        int[][] res= new int[K][2];
        for(int i=0;i<K;i++){
            res[i][0] = pq.peek()[0];
            res[i][1] = pq.peek()[1];
            pq.poll();
        }
//        return res;
        for(int[] x: res) {
        	for(int k : x)
        		System.out.print(k+" ");
        	System.out.println();
        }
    }
}
