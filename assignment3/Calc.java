
import java.util.Scanner;

public class  Calc
{	
	
	private TreeNode root;
	//create an empty tree
	public Calc()
	{
		
		root=null;
	}
	public static void main(String[] args)throws StackEmptyException
	{
		
		if(args.length<3)
		{
			throw new StackEmptyException("Invalid expression");
		}

		
		
		Calc tree=new Calc();
		tree.build(args);

		try{
			//tree= new TreeNode(new Scanner();
			tree.build(args);
			System.out.println(tree.evaluate());
		}catch(Exception e)
		{
			System.out.println("Invalid expression");
		}
	}

	/** expression contains the mathematical expression in post fix format
	  process the string array and create a binary expression tree
	  throw StackEmptyException if there is an error in the expression
	*/
	public void build(String[] expression) throws StackEmptyException
	{
		
		
		LLStack<TreeNode> s=new LLStack<TreeNode>();
		double n=0;
		for (int i=0; i<expression.length; i++)
		{
			if(isNum(expression[i]))
			{
				s.push(new TreeNode(expression[i].trim()));
			}else if(isOperator(expression[i]))
			{
				if(s.empty())
					throw new StackEmptyException("Invalid expression.");
				TreeNode operand2=s.pop();
				if(s.empty())
					throw new StackEmptyException("Invalid expression.");
				TreeNode operand1=s.pop();
				TreeNode newNode=new TreeNode(expression[i].trim(),operand1,operand2);
				s.push(newNode);
			}else
			{
				throw new StackEmptyException("Invalid expression");
			}
		}
		if(s.size()!=1)
			throw new StackEmptyException("Invalid expression.");
		root=s.pop();
	}
	
	//evaluate the expression tree and return the result
	public double evaluate() throws StackEmptyException
	{
		if (root==null)
			throw new StackEmptyException("Invalid expression");
		else 
			return evaluate(root);
	}
	
	//evaluate the sub expression tree rooted at node and return the result
	private double evaluate(TreeNode node)throws StackEmptyException
	{
		if ((node==null)||(node.item.length()==0))
		{
			throw new StackEmptyException("Invalid expression");
		}
		if (isNum(node.item))
			return convert(node.item);
	
		if (isOperator(node.item))
		{
			if ((node.left==null)||(node.right==null))
				throw new StackEmptyException("Invalid expression");
			
			double left=evaluate(node.left);
			
			double right=evaluate(node.right);
			if (node.item.equals( "x" )) {
			
            return evaluate(node.left) * evaluate(node.right);
			}
			 if (node.item.equals( "+" )) {
            return evaluate(node.left) + evaluate(node.right);
			}if (node.item.equals( "-" )) {
            return evaluate(node.left) - evaluate(node.right);
			}if (node.item.equals( "/" ))  {
			/*	try {
					return evaluate(node.left) / evaluate(node.right);
				}
				catch (Exception e )
				{
					
					 throw new StackEmptyException(" the denominator canot be zero"+node.right);
				
				
				
				}*/
				if(evaluate(node.right)==0)
					throw new StackEmptyException(" Invalid expression");
				return evaluate(node.left) / evaluate(node.right);
			}else {
            throw new StackEmptyException(
                    "Invalid expression" );
			}
		}else {
            throw new StackEmptyException(
                    "Invalid expression" );
			}
			
     
	
	}
	//return the string representation of the expression tree in inorder traversal
	public String toString()
	{
		return inorder();
	}
	
	//return the string representation of the expression tree in inorder traversal
	public String inorder()
	{
		String str =  inorder(root);
		str= str.trim();
		int i = str. lastIndexOf(',');
		return "{"+str.substring(0,i)+"}";
	}
	
	//return the string representation of the sub expression tree rooted at node in inorder traversal
	private String inorder(TreeNode node)
	{
		if (node==null)
			return "";
		    
	
	//convert the string object str to a double, throw an exception if there is an error
	private double convert(String str) throws RuntimeException
	{
		//return Double.parseDouble(str);
		return Integer.parseInt(str);
	}
	
	//return true if the string object str is a number, false otherwise
	private boolean isNum(String str)
	{
		try{
			Integer.parseInt(str);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	//return true if the string object str is an operator, false otherwise
	private boolean isOperator(String str)
	{
		str=str.trim();
		if(str.length()<1) return false;
		char c=str.charAt(0);
		switch (c)
		{
			case '+': case '-': case 'x': case '/':return true;
		}
		return false;
	}
	
	//TreeNode for the expression tree, another way to define a TreeNode, better encapsulation
	private class TreeNode
	{
		String item;
		TreeNode left;
		TreeNode right;

		public TreeNode(String str)
		{
			item=str;
			left=null;
			right=null;
		}

		public TreeNode(String str, TreeNode l, TreeNode r)
		{
			item=str;
			left=l;
			right=r;
		}
		 
    }
	
}