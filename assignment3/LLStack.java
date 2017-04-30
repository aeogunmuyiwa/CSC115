public class  LLStack<T> implements Stack <T>
{
	
	
	private Node<T> head ,tail ;
	
	private	int  count ; 
	
	public LLStack(){
		head = null; 
		tail = null;
		count = 0 ; 
	}
	
	
	public void push (T element ){
		Node newNode = new Node(element, null ); 
		if (head == null ){
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.next= head;
			head=newNode;
			
			
		}			
			count++;
			
	}
	
	
	
	public T  pop ()throws StackEmptyException{
		if (head == null){
			throw new StackEmptyException();
		}
		Node<T> p = head ; 
		head = head.next ; 
		count --; 
		return p.item; 

	}
	
	public T  peek() throws StackEmptyException {
		if (head == null )
			 throw new  StackEmptyException();
		return head.item;  
	}
	
	public int size ()
	{

		return  count; 
	}
	
	public boolean empty ()
	{
		return (head == null );
			
	}
	public void makeEmpty()
	{ 	
		tail = null;
		head = null;
		count = 0 ; 
	
	}
	
	
	
}