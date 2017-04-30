/*
 * HeapPriorityQueue.java
 *
 * CSC 115: Assignment 4 
 *
 * Comments from the sample solution:
 *
 * An implementation of a PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 * 
 * However, this implementation maintains the 
 * complete binary tree as a protected array, not a distinct class.
 *  This priority queue only deals
 * with keys.
 */

public class HeapPriorityQueue implements PriorityQueue
{
	protected final static int DEFAULT_SIZE = 10000;
	
	/* This array is where you will store the elements in the heap */
	protected Comparable storage[];

	/* Keep track of the current number of elements in the heap */
	protected int currentSize;
			
	
	public HeapPriorityQueue () 
	{
		this(DEFAULT_SIZE);
	}

	public HeapPriorityQueue(int size)
	{
		storage = new Comparable[size + 1];
		currentSize = 0;
	}
	
	
	public int size ()
	{
		return currentSize;
	}
	
	public boolean isEmpty ( )
	{
		return size() == 0;
	}
	
	public Comparable removeMin () throws HeapEmptyException
	{
		
		if (isEmpty())
			throw new HeapFullException();
		else{
			Comparable pos = storage[1];
			storage[1]=storage[currentSize];
			storage[currentSize]=null;
			
			currentSize--;
			bubbleDown();
			return pos;
		}
		
	}
	
	public void insert ( Comparable k  ) throws HeapFullException
	{	
		if (currentSize ==storage.length-1)
			throw new HeapFullException();
		storage[currentSize+1]= k ;
		
		++currentSize;
		bubbleUp();
	}

	
		
	/* 
	 * A new value has just been added to the bottom of the heap
	 * "bubble up" until it is in the correct position
	 */
	private void bubbleUp ( ) 
	
	{
		int pos = currentSize; 
		while((pos>1)&&(storage[pos].compareTo(storage[parent(pos)]) < 0)){
			//System.out.println("swap");
			swapElement(pos,parent(pos));
			pos=parent(pos);
		}
	}

	/*
	 * Because of a removeMin operation, a value from the bottom
	 * of the heap has been moved to the root.
	 * 
	 * "bubble down" until it is in the right position
	 */
	private void bubbleDown() 
	{
		int pos = 1;
		while(hasLeft(pos))
		{
			int sm= leftChild(pos);
			if (hasRight(pos)&&storage[leftChild(pos)].compareTo(storage[rightChild(pos)])>0){
				sm=rightChild(pos);
			}
			if(storage[pos].compareTo(storage[sm])>0)
			{
				swapElement(pos,sm);
				//System.out.println(pos+" "+sm);
			}
			else{
				break;
			}
			pos=sm;
		}
	}	
	
	/*
	 * Swap the element at position p1 in the array with the element at 
	 * position p2
	 */
	private void swapElement ( int p1, int p2 )
	{
		Comparable temp = storage[p1];
		storage[p1]=storage[p2];
		storage[p2]=temp;
	}
	
	/*
	 * Return the index of the parent of the node at pos
	 */
	private int parent ( int pos )
	{
		return pos/2; // replace this with working code
	}
	
	/* 
	 * Return the index of the left child of the node at pos
	 */
	private int leftChild ( int pos )
	{
		return pos*2; // replace this with working code
	}
	
	/* 
	 * Return the index of the right child of the node at pos
	 */
	private int rightChild ( int pos )
	{	
		return pos*2+1; // replace this with working code
	}
	
	/*
	 * Note that all internal nodes have at least a left child.
	 *
	 */
	private boolean hasLeft ( int pos )
	{
		return leftChild(pos)<=currentSize; // replace this with working code
	}

	/*
	 * Given the current number of elements in the heap, does the
	 * node at pos have a right child?
	 */	
	private boolean hasRight ( int pos )
	{
		return rightChild(pos) <= currentSize; // replace this with working code
	}
}
