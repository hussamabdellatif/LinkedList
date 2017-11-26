import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public  class LinkedList1<E> implements List<E> {
	private Node<E> head;
	private Node <E> tail;
	private int currentSize;

	
	public LinkedList1(){
		this.head = null;
		this.tail = null;
		this.currentSize=0;
	}
	
	class Node<T>{
		private T data;
		private Node <T> next;
		
		public Node(T data, Node<T> next){
			this.data= data;
			this.next = next;
		}
		public T getData() {
			return data;
		}
		public void setData(T newData) {
			this.data = newData;
		}
		public Node <T> getNext() {
			return next;
		}
		public void setNext(Node <T> newNext) {
			this.next = newNext;
		}
	}
	
	 class LinkedListIterator implements Iterator{
		 private Node<E> previous;
		 private Node<E> current;
		 private Node<E> previous2;
		 private boolean removeCalled;
		 public LinkedListIterator(){
			current = head; 
			previous = null;
			previous2= null;
			removeCalled= false;
		 }
		 public E next(){
			 if (current == null){
				 throw new NoSuchElementException();
			 }
			 E temp = current.getData();
			 previous2 = previous;
			 previous = current;
			 current = current.getNext();
			 removeCalled = false;
			 return temp;
		 }
		 public boolean hasNext(){
			 return current!=null;
		 }
		 public void remove(){
			 if (previous == null || removeCalled){
				 throw new IllegalStateException();
			
			 }
			 if (previous2 == null ){
				head = current; 
			 }else{
				 previous2.setNext(current);
			 }
			 currentSize--;
			 removeCalled= true;
		 }
		
	 }
	
	 public void displayAll(){
			ArrayList <Integer> altOrder = new ArrayList<Integer>();
			HashMap <Integer, String[]> myHash = new HashMap <Integer, String[]>();
			 ArrayList<String []> array2 =new ArrayList<String[]>(); 
		 	if (size()==0){
		 		
		 		System.out.println("\nThere are no aircrafts in this airspace!");
		 	}
		 	Node <E> current = head;
			String [] currentA ;
		 	Iterator<E> iterator2 = this.iterator();
		 	while (iterator2.hasNext()){
		 		currentA = (String[]) iterator2.next();
				altOrder.add(new Integer (currentA[2]));
		 	}
		 	
			
			
			
			
			Collections collect = null  ;
			collect.sort(altOrder);
			
			for (int i =0; i<altOrder.size(); i++){
				Iterator <E> iterator = this.iterator() ;
				String[] e =null;
				int altToCompare=0;
				int alt=0;
				while(iterator.hasNext()){
					 e = (String[]) iterator.next();
					 altToCompare = new Integer (e[2]);
					 alt = altOrder.get(i);
					if ( alt == altToCompare){
						array2.add(e);
					}
				}
					
				
			}
			
			String[] tofix = new String[4];
			for (int j=0; j<array2.size(); j++){
				tofix = array2.get(j);
				System.out.println("Aircraft :" + (j+1));
				System.out.println("Name:  " + tofix[0]);
				System.out.println("iD:  " + tofix[1] );
				System.out.println("Altitude:  " + tofix[2] + " ft");
				System.out.println("Speed:  " + tofix[3] + " m/s");
				System.out.println("________________________________");
			}
			System.out.println("Size of list" + size());
			System.out.println("size of array b" +altOrder.size());
			System.out.println("size of array c" +array2.size());
			
		 
		 
	 }
	 
	public int size() {
		
		return this.currentSize;
	}


	public boolean isEmpty() {
		
		return this.size()==0;
	}

	
	public boolean contains(Object o) {
	
		return false;
	}

	
	public Iterator<E> iterator() {
		
		return new LinkedListIterator();
	}

	public Object[] toArray() {
		
		return null;
	}

	
	public <T> T[] toArray(T[] a) {
		
		return null;
	}

	public boolean add(E e) {
		if (isEmpty()){
			head = new Node(e, null);
			tail = head;
		}
		else {
			tail.setNext(new Node (e,null));
			tail = tail.getNext();
		}
		currentSize++;
		return true;
	}

	
	public boolean remove(String name) {
		Iterator <E> iterator = this.iterator();
		while(iterator.hasNext()){
			String[] e = (String[]) iterator.next();
			if (e[0].equals(name)){
				
				iterator.remove();
				
				return true;
			}
		}
		return false;
	}

	
	public boolean containsAll(Collection<?> c) {
		
		return false;
	}

	
	public boolean addAll(Collection<? extends E> c) {
		
		return false;
	}

	
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void clear() {
		
		head= null;
		tail = null;
		currentSize = 0;
		
	}

	
	public String[] get(String o) {
		Iterator <E> iterator = this.iterator();
		while(iterator.hasNext()){
			String[] e = (String[]) iterator.next();
			if ( o.equals(e[0])){
				return  e;
			}
		}
	
		
		return null;
	}

	
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ListIterator<E> listIterator() {
		
		return null;
	}

	
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean equals (Object o){
		
		if (o instanceof List){
			List otherList = (List)o;
			if (this.size() == otherList.size()){
				Iterator list1 = this.iterator();
				Iterator list2 = otherList.iterator();
				while (list1.hasNext()){
					Object e1= list1.next();
					Object e2 = list2.next();
					if(!(e1 == null ? e2==null :e1.equals(e2))){
						return false;
					}
				}
				return true;
			}
		}
		
		return false;	
	}


	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public String[] getArray (int index){
		if (index<0 || index>= size()){
			throw new IndexOutOfBoundsException() ;
		}
		if (index< size()-1){
			Node <E> current = head;
			for (int i=0; i<index; i++){
				current = current.getNext();
			}
			return (String[]) current.getData();
		}
		
		
		
		
		return (String[]) tail.getData();
	}

	@Override
	public E get(int index) {
		
		
		
		return null;
	}
	
	
	
	
	

}
	/*
	 * 
	 
	private static LinkedList<String[]> list = new LinkedList();
	
	
	
	public static int getCount(){
		
		return list.size();
	}
	
	
	
	public static void add(String[] data){
		list.add(data);
		
	}
	
	public static void delete (String data){
		String finalreturn;
		Iterator it  = list.iterator();
		while (it.hasNext()){
			String[] current =  (String[]) it.next();
			if (current[0].equals(data)){
				list.remove(current);
			}
		}
	}
	
	public static void deleteall(){
		list.clear();
	}
	
	public static void displayAll (){
		System.out.println(list.size());
		ArrayList <Integer> aList = new ArrayList<Integer>();
		ArrayList <String[]> finalList = new ArrayList<String[]>();
		int altitude = 0;
		String [] display = new String[4];
		for (int i=0; i<list.size(); i++){
			display = list.get(i);
			altitude = new Integer(display[2]);
			aList.add(altitude);
		}
		Collections coll = null;
		
		coll.sort(aList);
		for (int i=0 ; i<aList.size(); i++){
		Iterator it = list.iterator();
		while (it.hasNext()){
			String[] current = (String[]) it.next();
			int alt = new Integer (current[2]);
			if (alt == aList.get(i)){
				finalList.add(current);
			}
		}
		
		}
		String[] tofix = new String[4];
		for (int i=0; i<finalList.size(); i++){
			tofix = finalList.get(i);
			System.out.println("Name:   " + tofix[0]);
			System.out.println("iD:   " + tofix[1]);
			System.out.println("Altitude:   " + tofix[2]);
			System.out.println("Speed:   " + tofix[3]);
		}
		
		
		
		
		
		
	}
	
	
	public static String[] findAC(String name){
		String finalreturn;
		Iterator it  = list.iterator();
		while (it.hasNext()){
			String[] current =  (String[]) it.next();
			if (current[0].equals(name)){
				return current;
			}
		}
		
		
		
		
		return null;
	}
	
	
}
*/
