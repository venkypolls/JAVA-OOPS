package amazonPrep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		IntStream.range(1, 10).forEach(System.out::println);
		
//		IntStream.range(1, 10).skip(4).forEach(x -> System.out.println(x));
		
//		System.out.println(IntStream.range(1,10).sum());
		
//		Stream.of("ava","aneri","alberto").sorted().findFirst().ifPresent(System.out::println);
		
//		String[] names = {"uttej", "santhosh" , "surya", "venky"};
//		Arrays.stream(names)
//			.filter(x -> x.startsWith("s"))
//			.sorted()
//			.forEach(System.out::println);
		
//		Arrays.stream(new int[]{2,4,6,8,10})
//			.map(x -> x*x)
//			.average()
//			.ifPresent(System.out::println);
		
//		List<String> list = Arrays.asList("Uttej", "santhosh" , "Surya", "venky");
//		list.stream()
//			.map(x -> x.toLowerCase())
//			.filter(x -> x.startsWith("s"))
//			.forEach(System.out::println);
		
//		List<String> bands = Files.lines(Paths.get("src/amazonPrep/data.txt"))
//				.filter(x -> x.contains("jit"))
//				.collect(Collectors.toList());
//		bands.forEach(System.out::println);
//		System.out.println(System.getProperty("user.dir"));
		
//		Stream<String> str = Files.lines(Paths.get("src/amazonPrep/data.txt"));
//		int rowCount = (int) str
//				.map(x -> x.split(","))
//				.filter(x -> x.length == 3)
//				.count();
//		System.out.println(rowCount);
		
//		Stream<String> list = Files.lines(Paths.get("src/amazonPrep/data.txt"));
//		list
//			.map(x -> x.split(","))
//			.filter(x -> x.length == 3)
//			.filter(x -> Integer.parseInt(x[1])>=2)
//			.forEach(x -> System.out.println(x[0]+" "+x[1]+" "+x[2]));
//		list.close();
		
//		Stream<String> list2 = Files.lines(Paths.get("src/amazonPrep/data.txt"));
//		Map<String,Integer> map = list2
//			.map(x -> x.split(","))
//			.filter(x -> x.length==3)
//			.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
//		list2.close();
//		for(String s : map.keySet()) {
//			System.out.println(s + " : "+map.get(s));
//		}
		
		double total = Stream.of(7.3,1.5,4.8)
					.reduce(0.0, (Double a, Double b) -> a+b);
		System.out.println(total);
		 
		
		
		
	}

}
