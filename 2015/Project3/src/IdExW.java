
public class IdExW {
	
	private boolean RegDst;
	private boolean ALUSrc;
	private int ALUOp;
	private boolean MemRead;
	private boolean MemWrite;
	private boolean MemToReg;
	private boolean RegWrite;
	
	private int reg1val;
	private int reg2val;
	private short offset;
	private int reg_20_16;
	private int reg_15_11;
	private int func;
	public boolean isRegDst() {
		return RegDst;
	}
	public void setRegDst(boolean regDst) {
		RegDst = regDst;
	}
	public boolean isALUSrc() {
		return ALUSrc;
	}
	public void setALUSrc(boolean aLUSrc) {
		ALUSrc = aLUSrc;
	}
	public int getALUOp() {
		return ALUOp;
	}
	public void setALUOp(int aLUOp) {
		ALUOp = aLUOp;
	}
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
	public int getReg1val() {
		return reg1val;
	}
	public void setReg1val(int reg1val) {
		this.reg1val = reg1val;
	}
	public int getReg2val() {
		return reg2val;
	}
	public void setReg2val(int reg2val) {
		this.reg2val = reg2val;
	}
	public short getOffset() {
		return offset;
	}
	public void setOffset(short offset) {
		this.offset = offset;
	}
	public int getReg_20_16() {
		return reg_20_16;
	}
	public void setReg_20_16(int reg_20_16) {
		this.reg_20_16 = reg_20_16;
	}
	public int getReg_15_11() {
		return reg_15_11;
	}
	public void setReg_15_11(int reg_15_11) {
		this.reg_15_11 = reg_15_11;
	}
	public int getFunc() {
		return func;
	}
	public void setFunc(int func) {
		this.func = func;
	}
	
	public String toString()
	{
				
		String rtn = "Register 1 Value: " + Integer.toHexString(reg1val) + " | Register 2 Value: " + Integer.toHexString(reg2val) +
				" | Offset: " + Integer.toHexString(offset) + " | Reg_20_16: " + reg_20_16 + " | Reg_15_11: " + 
				reg_15_11 + " | Function: " + Integer.toHexString(func);
		
	
		rtn += " \n Control Ops | RegDst: " + Boolean.toString(RegDst)+ " | ALU Src: " + Boolean.toString(ALUSrc) + " | ALUOP: " + ALUOp + 
				" | MemRead: " + Boolean.toString(MemRead) + " | MemWrite: " + Boolean.toString(MemWrite) + " | MemToReg: " + Boolean.toString(MemToReg) +
				" | RegWrite: " + Boolean.toString(RegWrite);
		
		return rtn;
	}
	

}
