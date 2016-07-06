
public class Slot {
	
	//declare variables used per slot
	private int validBit;
	private int tag;
	private int slot;
	private int[] data;
	
	//Getters and setter methods for all values in the slot
	public int getValidBit() {
		return validBit;
	}
	public void setValidBit(int validBit) {
		this.validBit = validBit;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public void setValue(int spot, int value)
	{
		data[spot] = value;
	}
	public int getValue(int i)
	{
		return data[i];
	}
	
	//to string method to print slot
	public String toString() {
		String rtn = "";
		
		//append all values to rtn
		rtn = "" + Integer.toHexString(slot) + "     " + validBit + "     " + Integer.toHexString(tag) +"         ";
		
		for(int i = 0; i<data.length; i++)
		{
			rtn += " " + Integer.toHexString(data[i]);
		}
		
		//return string with all slot values 
		return rtn;
	}

}
