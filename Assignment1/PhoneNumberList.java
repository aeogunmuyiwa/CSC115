public class PhoneNumberList
{
	private static final int INITIAL_SIZE = 1000;
	
	private PhoneNumber[]	storage;
	private int		count;

	
	public PhoneNumberList()
	{
		
		storage = new PhoneNumber[INITIAL_SIZE];
		count=0;
	}

	//
	// Purpose: 
	// 	return the element at position index
	
	public PhoneNumber get (int index)
	{
		return storage[index];
	} 

	//
	// Purpose:
	//	remove the element at position index
	
	public void remove (int index)
	{
		count--;
		for(int i= index; i< count; i++ ){
			storage[i]= storage[i+1];
		}
		
	}

	//
	// Purpose:
	//	return the number of elements in the list
	public int size()
	{
		return count;
	}

	// 
	// Purpose:
	//	add the phone number p to the list
	//
	
	public void add (PhoneNumber p)
	{
		storage[count]= p;
		count++;
	}

	//
	// Purpose:
	//	return the index where p is in the list, -1 otherwise
	
	public int find (PhoneNumber p)
	{
		for (int i=0; i< count; i++){
			if (storage[i].equals (p) )
				return i;
		}
		return -1;		
	}
}
