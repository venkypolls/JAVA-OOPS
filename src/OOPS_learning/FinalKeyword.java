package OOPS_learning;

import java.util.ArrayList;
import java.util.List;

final class F{
	//once final is used on variables it can't be changed
	public final double pi = 3.14;
}
//
//class Fi extends F{
//	
//} this extending is not possible because class is final.
// same way if used in a method it can't be overridden by any other method
class Fin{
	public final void show() {
		System.out.println("in show of Fin");
	}
}
class Ext extends Fin{
//	public void show() {
//		
//	} this gives and error as final methods can't be overridden
}

public class FinalKeyword {

	public static void main(String[] args) {
		List<Integer> x = new ArrayList<>();
		x.add(5);
		System.out.print(x.get(0));

	}

}
