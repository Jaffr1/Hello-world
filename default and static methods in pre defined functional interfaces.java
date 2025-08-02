package Java8;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface Fsd5354
{
	void demo();
	default void sample()
	{
		System.out.println("default method...");
	}
	static void method1()
	{
		System.out.println("static method");
	}
}

public class StaticDefaultMethods {

	public static void main(String[] args) {
		
		Fsd5354 ob=()->System.out.println("demo method");
		ob.demo();
		ob.sample();
		Fsd5354.method1();
		
		Predicate<Integer> p=a->a>10;
		Predicate<Integer> p1=a->a<20;
		System.out.println(p.and(p1).test(20));
		System.out.println(p.or(p1).test(20));
		System.out.println(p.negate().test(20));
		
		Predicate<String> p2=Predicate.isEqual("helloo");
		System.out.println(p2.test("helloo"));
		
		
		Function<Integer,Integer> f=x->x+10;
		Function<Integer,Integer> f1=x->x*10;
		
		System.out.println(f.andThen(f1).apply(10));
		System.out.println(f.compose(f1).apply(10));
		
		System.out.println(Function.identity().apply(1000));
	
		Comparator<Integer> c=(t,v)->t-v;
		
		BinaryOperator<Integer> b=BinaryOperator.minBy(c);
		BinaryOperator<Integer> b3=BinaryOperator.maxBy(c);
		
		
		UnaryOperator<Integer> b1=d->d;
		UnaryOperator<Integer> b2=d->d+20;
		
		System.out.println(b1.andThen(b2).apply(20));
		
		System.out.println(b.apply(30, 50));
	
		
	}

}