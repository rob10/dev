
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
	//convert object to string
	public String toString()
	{
		return "Number of units: " + numUnits;
	}
	//compare objects
	public boolean equals(JarType j)
	{
		
		if(numUnits == j.numUnits)
		{
			return true;
		}
		else{
			return false;
		}
		
	}
	//print details of object
	void showDetails()
	{
		System.out.println("num of units: " + numUnits);
	}

}
