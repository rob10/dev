
public class Pipeline {
	//declare arrays
	int[] Main_Mem = new int [1024];
	int[] Regs = new int [32];
	
	//initialize instances of pipeline register classes
	IfIdR ifidr = new IfIdR();
	IfIdW ifidw = new IfIdW();
	IdExW idexw = new IdExW();
	IdExR idexr = new IdExR();
	ExMemW exmemw = new ExMemW();
	ExMemR exmemr = new ExMemR();
	MemWbW memwbw = new MemWbW();
	MemWbR memwbr = new MemWbR();
	
	
	
	void startProg()
	{
		//initialize main memory array
		for(short i = 0; i<4; i++)
		{
			for(short j = 0; j<256; j++)
			{
					Main_Mem[j+(i*256)]=j;
				
			}
		}
		
		//set zero register to false
		Regs[0] = 0;
		
		//initialize the rest of the registers
		for(int i = 1; i < Regs.length; i++)
		{
			Regs[i] = i + 0x100;
		}
		
		//initialize instructions array
		int[] instruct =  {0xa1020000, 0x810afffc, 0x00831820, 0x01263820, 0x1224820, 0x81180000 , 0x81510010 , 0x00624002 ,0x00000000,
				0x00000000,0x00000000, 0x00000000};
		
		//counter for loop and instruction array
		int count = 0;
		
		//loop to simulate clock cycles
		while(count <= instruct.length-1)
		{
			//methods to represent stages of the pipelines
			IF_Stage(instruct[count]);
			ID_Stage();
			EX_Stage();
			MEM_Stage();
			WB_Stage();
			//print everything
			print_out_everything(count+1);
			//move from write to read classes
			copy_write_to_read();		
			
			
			count++;
		}

		
	}
	
	//gets instruction and sets it to IFID Write
	private void IF_Stage(int instruct)
	{
		ifidw.setInstruction(instruct);

	}
	
	//Reads instruction from IFID Write and decodes the instruction.
	//Then initializes variables for IDEX Write and gets the Control
	//Bits that this instruction uses and writes to IDEX Write
	private void ID_Stage()
	{
		int instruction = ifidr.getInstruction();
		
		int  oppcode, src1reg, src2reg, destreg, function;
		short offset;
		
		int ocBitMask = 0xFC000000;
		int src1BitMask = 0x03E00000;
		int src2BitMask = 0x001F0000;
		int destBitMask = 0x0000f800;
		int funcBitMask = 0x0000003F;
		int offsetBitMask = 0x0000FFFF;
		oppcode = (instruction&ocBitMask)>>>26;
		src1reg = (instruction&src1BitMask)>>>21;
		src2reg = (instruction&src2BitMask)>>>16;
		destreg = (instruction&destBitMask)>>>11;
		function = (instruction&funcBitMask);
		offset = (short) (instruction&offsetBitMask);
		
		idexw.setReg1val(Regs[src1reg]);
		idexw.setReg2val(Regs[src2reg]);
		idexw.setFunc(function);
		idexw.setReg_20_16(src2reg);
		idexw.setReg_15_11(destreg);
		idexw.setOffset(offset);
				
		
		if(oppcode == 0 && function == 0)
		{
			idexw.setRegDst(false);
			idexw.setALUSrc(false);
			idexw.setALUOp(00);
			idexw.setMemRead(false);
			idexw.setMemWrite(false);
			idexw.setMemToReg(false);
			idexw.setRegWrite(false);
			return;
		}
		
		System.out.println(Integer.toHexString(oppcode));
		
		switch(oppcode)	
		{
		case 0x20:
			idexw.setRegDst(false);
			idexw.setALUSrc(true);
			idexw.setALUOp(00);
			idexw.setMemRead(true);
			idexw.setMemWrite(false);
			idexw.setMemToReg(true);
			idexw.setRegWrite(true);
			break;
		case 0x28:
			idexw.setRegDst(false);
			idexw.setALUSrc(true);
			idexw.setALUOp(00);
			idexw.setMemRead(false);
			idexw.setMemWrite(true);
			idexw.setMemToReg(false);
			idexw.setRegWrite(false);
			break;
			default: 
				idexw.setRegDst(true);
				idexw.setALUSrc(false);
				idexw.setALUOp(10);
				idexw.setMemRead(false);
				idexw.setMemWrite(false);
				idexw.setMemToReg(false);
				idexw.setRegWrite(true);
				
		}
		
		
	}
	
	//Reads control bits from IDEX Read and then decides what type of
	//operation to use. Then writes to EXMEM Write
	private void EX_Stage()
	{
		
		if(idexr.getALUOp()!=10)
		{
			exmemw.setALUResult(idexr.getReg1val()+idexr.getOffset());
			
		}
		else{
			
			if(idexr.getFunc() == 0x20)
				exmemw.setALUResult(idexr.getReg1val()+idexr.getReg2val());
			else
				exmemw.setALUResult(idexr.getReg1val()-idexr.getReg2val());
		}
		
		exmemw.setZero(false);
		exmemw.setSWValue(idexr.getReg2val());
				
		exmemw.setMemRead(idexr.isMemRead());
		exmemw.setMemWrite(idexr.isMemWrite());
		exmemw.setMemToReg(idexr.isMemToReg());
		exmemw.setRegWrite(idexr.isRegWrite());
		
		if(!idexr.isRegDst())
			exmemw.setWriteRegNum(idexr.getReg_20_16());
		else
			exmemw.setWriteRegNum(idexr.getReg_15_11());
		
		
	}
	
	//Reads from EXMEM Read. Gets byte if its a load byte and writes it to MEMWB Write
	//if its a store byte, then it stores value to main memory
	//if its a Rtype it just writes to MEMWB Write
	private void MEM_Stage()
	{
		
		
		memwbw.setLWDataValue(Main_Mem[exmemr.getALUResult()]);
		memwbw.setALUResult(exmemr.getALUResult());
		memwbw.setWriteRegNum(exmemr.getWriteRegNum());
		memwbw.setMemToReg(exmemr.isMemToReg());
		memwbw.setRegWrite(exmemr.isRegWrite());
		
		if(exmemr.isMemWrite())
		{
			
			Main_Mem[exmemr.getALUResult()] = exmemr.getSWValue();
					
		}
		
	}
	
	//if it is doesn't have a control bit for RegWrite(a sb) then get out of method
	//then if it has a memtoreg control  then write lbdatavalue to register, if 
	// regwrite does have a control bit but memtoreg doesn't then writr alu resut
	//to the register that was read from MEMWB Read
	private void WB_Stage()
	{
		if(!memwbr.isRegWrite())
		{
			return;
		}
		else if(memwbr.isMemToReg())
		{
			System.out.println("hey2");
			Regs[memwbr.getWriteRegNum()] = memwbr.getLWDataValue();
		}
		else
			Regs[memwbr.getWriteRegNum()] = memwbr.getALUResult();
		
	}
	
	//Print out all registers and all the variables for the pipeline registers
	private void print_out_everything(int count)
	{
		
		System.out.println("Clock Cycle " + count);
		
		
		for (int i = 0; i<Regs.length; i++)
		{
			System.out.printf("Register $%d value: %x \n", i, Regs[i]);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("IF/ID Write: "+ ifidw.toString());
		System.out.println("");
		System.out.println("IF/ID Read: "+ ifidr.toString());
		System.out.println("");
		System.out.println("ID/EX Write: "+ idexw.toString());
		System.out.println("");
		System.out.println("ID/EX Read: "+ idexr.toString());
		System.out.println("");
		System.out.println("EX/MEM Write: "+ exmemw.toString());
		System.out.println("");
		System.out.println("EX/MEM Read: "+ exmemr.toString());
		System.out.println("");
		System.out.println("MEM/WB Write: "+ memwbw.toString());
		System.out.println("");
		System.out.println("MEM/WB Read: "+ memwbr.toString());
		System.out.println("");
		System.out.println("-------------------------");
		
		
	}
	
	//copy from WRITE to READ
	private void copy_write_to_read()
	{
		ifidr.setInstruction(ifidw.getInstruction());
		
		idexr.setReg1val(idexw.getReg1val());
		idexr.setReg2val(idexw.getReg2val());
		idexr.setFunc(idexw.getFunc());
		idexr.setReg_20_16(idexw.getReg_20_16());
		idexr.setReg_15_11(idexw.getReg_15_11());
		idexr.setOffset(idexw.getOffset());
		idexr.setRegDst(idexw.isRegDst());
		idexr.setALUSrc(idexw.isALUSrc());
		idexr.setALUOp(idexw.getALUOp());
		idexr.setMemRead(idexw.isMemRead());
		idexr.setMemWrite(idexw.isMemWrite());
		idexr.setMemToReg(idexw.isMemToReg());
		idexr.setRegWrite(idexw.isRegWrite());
		
		exmemr.setALUResult(exmemw.getALUResult());
		exmemr.setZero(exmemw.isZero());
		exmemr.setSWValue(exmemw.getSWValue());
		exmemr.setWriteRegNum(exmemw.getWriteRegNum());
		exmemr.setMemRead(exmemw.isMemRead());
		exmemr.setMemWrite(exmemw.isMemWrite());
		exmemr.setMemToReg(exmemw.isMemToReg());
		exmemr.setRegWrite(exmemw.isRegWrite());
		
		memwbr.setLWDataValue(memwbw.getLWDataValue());
		memwbr.setALUResult(memwbw.getALUResult());
		memwbr.setWriteRegNum(memwbw.getWriteRegNum());
		memwbr.setMemToReg(memwbw.isMemToReg());
		memwbr.setRegWrite(memwbw.isRegWrite());
		
		
		
	}
}
