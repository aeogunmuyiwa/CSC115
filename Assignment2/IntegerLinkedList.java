/*
 * IntegerLinkedList.java
 *
 * This is the "stub" implementation of the IntegerList interface
 * provided to you as part of assignment 2.
 * 
 * Your task is to complete the implementation of all the methods
 * such that they meet the specifications defined both in 
 * IntegerList.java and in the assignment PDF.
 *
 * Except for the constructor, you should remove all the supplied code
 * from the methods and replace it with working code.  The supplied code
 * in the methods is just so that this file compiles and runs.
 *
 */

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode	head;
	private IntegerNode	tail;

	private	int		count;

	public IntegerLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{
		
		IntegerNode p = new IntegerNode(x,null);
		if (head == null ){
		
		
			tail = p ; 
			head = p ; 
		}
		else{
			p.next =head;
			p.prev = null;
			head.prev = p ; 
			head = p ; 
		}
		count++;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */	
	public void addBack (int x)
	{
		
	
		IntegerNode p = new IntegerNode(x,null);
		if (tail == null ){
		
		
			tail = p ; 
			head = p ; 
		}
		else {
			tail.next = p ;
			p.prev = tail;
			tail = p ; 
		}
		count++;
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}
	
	/* 
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 * 
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		if (pos >= 0 && pos < size())
		{	IntegerNode P = head; 
			for (int i = 0; i < pos ; i++)
			{
				P = P.getNext();
				
			}
			return P.getValue();
		}
		return -1;
	}
	
	/* 
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{
		head = null;
		tail = null;
		count = 0; 
	}

	/* 
	 * PURPOSE:
	 *   Remove all instances of value from the list. 
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{
		// empty list 	
		if ( head == null)
			return ;
		
		IntegerNode p = head ; 
		
		while (p!=null){
			if (p.getValue() == value){
				
				if ( p== head )
				{
					head = p.next ; 
					
				}
				
				if (p ==  tail ) 
					tail = p.prev;
				
				 if (p.next != null)
				{
					p.next.prev = p.prev;
					
				}
				
				if (p.prev !=null)
				{
					p.prev.next = p.next ;
				}
				
			
				
				
				count --;
			}
			p = p.next;
		}
		
				
		
		
			
			

	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		String s= "{";
		IntegerNode p = head ; 
		
		while(p !=null)
		//while i'm not at th end of the list 
		{
			s = s + p.getValue();
			if (p.next != null)
			{
				s= s + ',';
				
			}
			p = p.next; // moving p to the next node in th list 
		}
		s= s+"}";
		return s;
	}
}
