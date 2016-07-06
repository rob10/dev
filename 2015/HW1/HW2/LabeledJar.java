
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
	

}
