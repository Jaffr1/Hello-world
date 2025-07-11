package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEntry {
public static void main(String[] args) {
	HashMap<Integer,String> hm=new HashMap<Integer,String>();
	hm.put(10, "java");//10,java
	hm.put(90, "spring");
	hm.put(12, "jsp");
	hm.put(39,"servlet");
	hm.put(18, "mysql");
	System.out.println(hm);
//	Set<Map.Entry<Integer, String>> s=hm.entrySet();//key,value
//    Iterator<Map.Entry<Integer, String>> i=s.iterator();
	Set s=hm.entrySet();
   Iterator i=	s.iterator();
	while(i.hasNext()) {
//		Map.Entry<Integer,String> me=i.next();//10=java
	Map.Entry<Integer,String> me=(Map.Entry)i.next();//object
		if(me.getKey()==12)
			me.setValue("snowflake");
	}
System.out.println(hm);
}
}