package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Strm {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<>();
		al.add(20);
		al.add(10);
		al.add(50);
		al.add(14);
		al.add(20);
		al.add(10);
		System.out.println(al);
		//al.stream().forEach(a->System.out.println(a));
//		al.stream().filter(x->x%2==0).sorted()
//		.forEach(y->System.out.println(y));
		
		al.stream().sorted((m,n)->n-m)
		.forEach(y->System.out.println(y));
		
		
		List<String> s=Arrays.asList("java","hello","welcome","morning");
		s.stream().map(String::toUpperCase).
		forEach(System.out::println);
		
		List<Integer> li=al.stream().distinct().
		collect(Collectors.toList());
	    System.out.println(li);
	    
	    System.out.println(s.stream().limit(3)
	    		.collect(Collectors.toList()));
	
	    
	    System.out.println(s.stream().skip(1).limit(2)
	    		.collect(Collectors.toList()));
	
	     
	    System.out.println(al.stream().
	    		reduce((b,c)->b+c).get());
	    
	    System.out.println(al.stream().findFirst());
	
	     System.out.println(al.stream().min((k,l)->k-l));
	
	    System.out.println(al.stream().noneMatch(p->p%2!=0));
	}

}