//
// StackEmptyException.java

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
