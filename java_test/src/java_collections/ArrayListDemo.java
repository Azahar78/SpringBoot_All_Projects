package java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		
	//	List al = List.of(100,"Azahar",20.5,1000,'c',new String("John"));
		
		List al = List.of(100,76,23,1,76,9);
		
		ArrayList li =new ArrayList(al);
		
		
		System.out.println(li);
		
		Collections.sort(li);
		
		
		
		Collections.reverse(li);
		
		System.out.println(li);
		
	//	System.out.println(al.size());
		
		for(Object l:li) {
		//	System.out.print(l+" ");
		}
		
	//	System.out.println("=================================");
		
	//	li.forEach(i->System.out.print(i+" "));
		
	//	System.out.println("===============================");
		
		Iterator iterator = li.iterator();
		while(iterator.hasNext()) {
	//		System.out.print(iterator.next());
		}
		
	//	System.out.println("===============================");
		
		ListIterator listIterator = li.listIterator();
		
		while(listIterator.hasNext()) {
	//		System.out.print(listIterator.next());
		}
		
	//	System.out.println("===============================");
		
		
		while(listIterator.hasPrevious()) {
	//		System.out.print(listIterator.previous());
		}
		
	}
}
