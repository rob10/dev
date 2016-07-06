
public class MemWbW {

	private boolean MemToReg;
	private boolean RegWrite;
	
	private int LWDataValue;
	private int ALUResult;
	private int WriteRegNum;
	public boolean isMemToReg() {
		return MemToReg;
	}
	public void setMemToReg(boolean memToReg) {
		MemToReg = memToReg;
	}
	public boolean isRegWrite() {
		return RegWrite;
	}
	public void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}
	public int getLWDataValue() {
		return LWDataValue;
	}
	public void setLWDataValue(int lWDataValue) {
		LWDataValue = lWDataValue;
	}
	public int getALUResult() {
		return ALUResult;
	}
	public void setALUResult(int aLUResult) {
		ALUResult = aLUResult;
	}
	public int getWriteRegNum() {
		return WriteRegNum;
	}
	public void setWriteRegNum(int writeRegNum) {
		WriteRegNum = writeRegNum;
	}
	
	public String toString()
	{
				
		String rtn = "ALU Result:  " + Integer.toHexString(ALUResult) + " | LWDataValue: " + Integer.toHexString(LWDataValue) + " | WriteReg: " + WriteRegNum;
		
		rtn += " \n Control Ops  | MemToReg: " + Boolean.toString(MemToReg) + " | RegWrite: " + Boolean.toString(RegWrite);
		
		
		return rtn;
	}
	
}
