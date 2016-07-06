package stacksoct6;

public class ArrayStack implements MyStack {
	
	private String[] stack;
	private int stackSize;
	private static final int STACK_SIZE = 50;
	private int stackTop = 0;
	
	public ArrayStack()
	{
		stackSize = STACK_SIZE;
		
		//allocate stack
		initialize();
		
	}
	
	public ArrayStack(int stackSize)
	{
		this.stackSize = stackSize;
	}
	
	private void initialize()
	{
		stack = new String[stackSize];
		initialize();
	}
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#push(java.lang.String)
	 */
	@Override
	public boolean push(String data)
	{
		if(stackFull())
		{
			//error overflow
			return false;
		}
		
		String ourData = new String(data);
		
		stack[stackTop++] = ourData;
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#pop()
	 */
	@Override
	public String pop()
	{
		if(stackEmpty())
		{
			//error underflow
			return null;
		}
		stackTop--;
		return stack[stackTop];
	}
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#stackFull()
	 */
	@Override
	public boolean stackFull()
	{
		return (stackTop >= stack.length);
	}
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#stackEmpty()
	 */
	@Override
	public boolean stackEmpty()
	{
		return stackTop == 0;
	}
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#clear()
	 */
	@Override
	public void clear()
	{
		while(!stackEmpty())
		{
			pop();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#stackTop()
	 */
	@Override
	public String stackTop()
	{
		if(stackEmpty())
		{
			return null;
		}
		
		String rtn = new String(stack[stackTop-1]);
		
		return rtn;
			
	}
	
	/* (non-Javadoc)
	 * @see stacksoct6.MyStack#stackDepth()
	 */
	@Override
	public int stackDepth()
	{
		return stackTop;w.
	}
	
	/*public String toString()
	{
		if(stackEmpty())
		{
			return "<empty>";
		}
		
		for(int i  stackTop-1; i >= 0 , i--)
		{
			if(i==)
		}
	}*/
	

}
