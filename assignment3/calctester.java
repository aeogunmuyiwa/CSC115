/**
 Write a program to process an expression in post fix form from the command line. e.g. java 3 5 +
 Note for multiplication, run it like this: java 3 5 "*"
 Stop the program and send an error message if the number of arguments are less than 3.
*/
import java.util.Scanner;
import java.io.File;
public class calctester
{
	public static void main(String[] args)throws StackEmptyException
	{
		
		if(args.length<3)
		{
			throw new StackEmptyException("Invalid expression");
		}

		
		
		Calc tree=new Calc();
		tree.build(args);
		System.out.println(tree.evaluate());
		/*try{
			//tree= new TreeNode(new Scanner();
			tree.build(args);
			System.out.println(tree.evaluate());
		}catch(Exception e)
		{
			System.out.println("Invalid expression");
		}*/
	}
}