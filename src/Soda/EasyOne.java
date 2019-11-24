package Soda;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasyOne {

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
	ArrayList<Integer> al = new ArrayList<Integer>();
	String inputString;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	int num;
	int n = sc.nextInt();
	for(int i = 0; i < n; i++) {
		al.add(sc.nextInt());
	}

	makeProductOne(al);

}


public static int makeProductOne(List<Integer> l)
{
	int ncount = 0;
	int maxNeg = Integer.MAX_VALUE;
	for(int i=0;i<l.size();i++)
	{
		if(l.get(i)<0)
		{
			ncount++;
			if(maxNeg<l.get(i))
				maxNeg = l.get(i);
		}	
	}
	int res = 0;

	for(int i =0;i<l.size();i++)
	{
	if(l.get(i)<0 && l.get(i)!=-1)
	{
	res+=Math.abs(l.get(i))-1;
	
	
	}
	else if(l.get(i)>0 && l.get(i)!=1)
	{
	res+=(l.get(i)-1);
	
	}
	else if(l.get(i)==0)
	res+=1;
	}
	
	if(ncount%2!=0 && !l.contains(0))
	res+=2;

	System.out.println(res);
	return res;
	}

}