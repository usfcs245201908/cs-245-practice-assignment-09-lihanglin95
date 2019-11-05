import java.util.Arrays;

public class BinaryHeap {
	private final int DEFAULT_SIZE = 10;
	private int a[];
	private int size;
	
	/*
	 * Constructor
	 */
	public BinaryHeap() {
		a = new int[DEFAULT_SIZE];
		size = 0;
	}
	
	/*
	 * This method is to doubled the size when the array is full 
	 */
	protected void grow_array() {
		a = Arrays.copyOfRange(a, 0, a.length * 2);
	}
	
	/**
	 * This method is to swap two priority numbers in the array
	 * @param a This is the array a
	 * @param i This is one of the index of the target priority numbers
	 * @param j This is the other index of the target priority numbers
	 */
	protected void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * This method is to add an int instance to the priority queue
	 * @param priority This is the new priority number
	 */
	public void add(int priority) {
		if(size >= a.length)
			grow_array();
		
		a[size++] = priority;
		int child = size - 1;
		int parent = (child - 1) / 2;
		
		while(a[child] < a[parent] && parent >= 0) {
			swap(a, child, parent);
			child = parent;
			parent = (child - 1) / 2;
		}

	}
	
	/**
	 * This method is to remove the highest priority item (the lowest number) from the priority queue
	 * @return This returns the highest priority item
	 */
	public int remove(){
		if(size == 0)
			throw new IndexOutOfBoundsException();
		
		int temp = a[0];
		a[0] = a[--size];
		siftdown(0);
		return temp;		
	}
	
	/**
	 * This method is to sift down the priority number to reorder the heap
	 * @param parent This is the index of the priority number
	 */
	protected void siftdown(int parent) {
		int child = parent * 2 + 1;
		
		//base case
		if(child >= size)
			return;
		
		if(child + 1 < size) 
			if(a[child] > a[child + 1])
				child = child + 1;
		
		if(a[child] < a[parent]) {
			swap(a,child, parent);
			siftdown(child);
		}	
		
	}

}
