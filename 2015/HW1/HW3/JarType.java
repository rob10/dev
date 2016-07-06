
public class JarType {
	
	private int numUnits;
	/** constructor with no pre values\\*/
	public JarType()
	{
		this(0);
	}
	/** constructor with int*/
	public JarType(int numUnits)
	{
		this.numUnits = numUnits;
	}
	
	/** add to the number of units in the jar*/
	public void add(int n)
	{
		numUnits = numUnits + n;
	}
	/** empty out the jar, sets the number of units to 0*/
	public void emptyItOut()
	{
		numUnits = 0;
	}
	/** returns number of units in the jar*/
	public int quantity()
	{
		return numUnits;
	}

}
