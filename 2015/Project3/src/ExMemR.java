
public class ExMemR {
	
	private boolean MemRead;
	private boolean MemWrite;
	private boolean MemToReg;
	private boolean RegWrite;
	
	private boolean zero;
	private int ALUResult;
	private int SWValue;
	private int WriteRegNum;
	
	public boolean isMemRead() {
		return MemRead;
	}
	public void setMemRead(boolean memRead) {
		MemRead = memRead;
	}
	public boolean isMemWrite() {
		return MemWrite;
	}
	public void setMemWrite(boolean memWrite) {
		MemWrite = memWrite;
	}
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
	public boolean isZero() {
		return zero;
	}
	public void setZero(boolean zero) {
		this.zero = zero;
	}
	public int getALUResult() {
		return ALUResult;
	}
	public void setALUResult(int aLUResult) {
		ALUResult = aLUResult;
	}
	public int getSWValue() {
		return SWValue;
	}
	public void setSWValue(int sWValue) {
		SWValue = sWValue;
	}
	public int getWriteRegNum() {
		return WriteRegNum;
	}
	public void setWriteRegNum(int writeRegNum) {
		WriteRegNum = writeRegNum;
	}
	
	public String toString()
	{
				
		String rtn = "ALU Result: " + Integer.toHexString(ALUResult) + "| SWValue: " + Integer.toHexString(SWValue) + " | WriteReg: " + WriteRegNum;
		
		rtn += " \n Control Ops | MemRead: " + Boolean.toString(MemRead) + " | MemWrite: " + Boolean.toString(MemWrite) + " | MemToReg: " + Boolean.toString(MemToReg) +
				" | RegWrite: " + Boolean.toString(RegWrite);
		
		return rtn;
	}
	

}
