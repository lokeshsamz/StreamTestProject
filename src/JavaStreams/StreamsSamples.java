package JavaStreams;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsSamples {

	
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("James", "Harry Potter", "Catherine", "Christopher Mathews");
		//List<Integer> array = Arrays.asList(1,2,[3],[4],5);
		//Integer[][] arrays = { 1, 2 , [2] };
	
	Object[] array = {1, 2 ,new Object[] {3, 4 ,new Object[] {5}, 6, 7}, 8, 9, 10, new Object[] {11, new Object[] {12, new Object[] {13, new Object[] {14}}}, new Object[] {15}}};

		Object[] flat = testing(array).toArray();
		System.out.println(Arrays.toString(flat));
		
		
		//collect(Collectors.toList()).forEach(System.out::print);
		
		
//		names.stream()
//		 .map(name -> name.split(""))
//		 .flatMap(e-> Arrays.stream(e)) //Arrays::stream
//		 .map(e -> e.toLowerCase())
//		 //.filter(e -> !e.equals(" "))
//		 //.distinct()
//		 //.close();
//		 .forEach(System.out::print);
		
		
		
		
	}	
	
	 static Stream<Object> testing (Object[] arr) 
		{
			return Arrays.stream(arr).flatMap(e -> e instanceof Object[]? testing((Object[])e): Stream.of(e));
		}
	
	
	
}
