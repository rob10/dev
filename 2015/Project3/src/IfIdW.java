
public class IfIdW {
	
	private int instruction;

	public int getInstruction() {
		return instruction;
	}

	public void setInstruction(int instruction) {
		this.instruction = instruction;
	}
	
	public String toString()
	{
		return "" + Integer.toHexString(instruction) + "";
	}

}
