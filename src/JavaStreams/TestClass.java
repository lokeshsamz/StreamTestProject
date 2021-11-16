package JavaStreams;
import static java.util.function.Function.identity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {

	public static List<String> texts = new ArrayList<>(Arrays.asList("Programming", "Tester", "Encyclopedia"));
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("James", "Harry Potter", "Catherine", "Christopher Mathews");
		names.stream()
			 .map(name -> name.split(""))
			 .flatMap(e-> Arrays.stream(e)) //Arrays::stream
			 .map(e -> e.toLowerCase())
			 .filter(e -> !e.equals(" "))
			 .distinct()
			 .close();
			 //.forEach(System.out::print);
		
	Path path = Paths.get("C:\\Users\\loki\\eclipse-workspace\\StreamTestProject\\src\\JavaStreams\\file.txt");
	
	try {
		int count = (int) Files.lines(path)
			 .map(e -> e.split(" "))
			 .flatMap(Arrays::stream)
			 .distinct()
			 .map(name -> name.split(""))
			 .flatMap(e-> Arrays.stream(e))
			 .distinct()
			 .count();
		
		System.out.println(count);
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
	
		for(String text : texts)
		{
			 String[] textarray = text.split("");
			 
			 Map<String, Integer> map = new LinkedHashMap<>();
			 
			 for( String ch : textarray)
			 {
				 ch = ch.toLowerCase();
					if (map.containsKey(ch))
					{						
						map.put(ch, map.get(ch) + 1);
					}
					else
					{
						map.put(ch, 1);
					}

			 }
			 System.out.println(text);
			 map.forEach((k,v) -> {if(v > 1) System.out.println( k + " -> " + v);});
			 System.out.println("-----------------------------------");
		}
		
		texts.stream()
		 .map(text -> text.split(""))
		 .filter(test::mapto)
		 .count();
			 	 
		findFirstNonRepeatingLetter("programming", System.out::println);
	}

	private static void findFirstNonRepeatingLetter(String s, Consumer<Character> callback) {
	    s.chars()
	      .mapToObj(i -> Character.valueOf((char) i))
	      .collect(Collectors.groupingBy(identity(), LinkedHashMap::new, Collectors.counting()))
	      .entrySet().stream()
	      .filter(entry -> entry.getValue() == 1L)
	      .map(entry -> entry.getKey())
	      .findFirst().map(c -> { callback.accept(c); return c; } );
	  }
}


 class test
{
	public static boolean mapto(String[] textarray)
	{
		Map<String, Integer> map = new LinkedHashMap<>();
		 
		 for( String ch : textarray)
		 {
			 ch = ch.toLowerCase();
				if (map.containsKey(ch))
				{						
					map.put(ch, map.get(ch) + 1);
				}
				else
				{
					map.put(ch, 1);
				}
				
		 }
		 
		 List.of(textarray).forEach(System.out::print);
		 System.out.println();
		 map.forEach((k,v) -> {if(v > 1) System.out.println( k + " -> " + v);});
		 System.out.println("-----------------------------------");
		 
		 return true;
	}
	
	public static boolean mappings(Map<String, Integer> map)
	{
		//NewClass.texts.forEach(e -> e.contains(map.));
		System.out.println();
		 map.forEach((k,v) -> {if(v > 1) System.out.println( k + " -> " + v);});
		 System.out.println("-----------------------------------");
		 return true;
	}
}
