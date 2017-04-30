//
// StackEmptyException.java
//
// There is some question as to whether this should be a
// checked or unchecked exception.
//
// For this assignment we have decided to make the 
// exception checked so that the exception handling
// mechanisms are explicit.
//
public class StackEmptyException extends Exception
{
	public StackEmptyException()
	{
		super();
	}
	
	public StackEmptyException(String msg)
	{
		super(msg);
	}
	
	public String getMessge()
	{
		return super.getMessage( );
	}
}
