
public class LabeledJar extends JarType{
	
	private String label;
	
	/** constructor with no pre values*/
	public LabeledJar()
	{
		this(null);
		
	}
	
	/** constructor with int*/
	public LabeledJar(int n)
	{
		this(n, null);
		
	}
	
	/** Constructor with String */
	public LabeledJar(String label)
	{
		this(0, label);
		
	}
	
	/**Constructor with String and int */
	public LabeledJar(int n, String label)
	{
		super(n);
		this.label = label;
		
	}
	
	/** set label to stirng passed in*/
	public void setLabel(String label)
	{
		this.label = label;
	}
	/** display the label */
	public void displayLabel()
	{
		System.out.println(label);
	}
	//convert object to string
	public String toString()
	{
		return super.toString() + " Label: " + label; 
	}
	//compare objects
	boolean equals(LabeledJar j)
	{
		if(super.equals(j))
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
		System.out.println("num of units" + super.quantity() + " label: " + label);
	}
	

}
