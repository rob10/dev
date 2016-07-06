/*****
 * 
 * Robert Gomez
 * CS472
 * 10/01/2015 
 * 
 * 
 * 
 * @author Robert
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		Driver me = new Driver();
		me.startProgram();

	}

	void startProgram()
	{
		//declare variables
		int  oppcode, src1reg, src2reg, destreg, function;
		int[] instructions;
		short offset;
		
		//initialize bitmask to use later to help shift to the right
		int ocBitMask = 0xFC000000;
		int src1BitMask = 0x03E00000;
		int src2BitMask = 0x001F0000;
		int destBitMask = 0x0000f800;
		int funcBitMask = 0x0000003F;
		int offsetBitMask = 0x0000FFFF;
		
		//initialize Program counter and amount of distance to next address
		int pc = 0x7A060;
		int addToAddress = 0x00004;
				
		//initialize array with all the hex instructions
		instructions = new int[] {0x022DA822, 0x8EF30018, 0x12A70004, 0x02689820, 0xAD930018, 0x02697824, 0xAD8FFFF4,
				0x018C6020, 0x02A4A825, 0x158FFFF6, 0x8E59FFF0};
		
		
		
		//start forloop
		for(int i = 0; i<instructions.length; i++)
		{
			//get the oppcode, and 2 source registers
			oppcode = (instructions[i]&ocBitMask)>>>26;
			src1reg = (instructions[i]&src1BitMask)>>>21;
			src2reg = (instructions[i]&src2BitMask)>>>16;
			
			//use if else statement to seperate I-format and R-format instructions
			if(oppcode != 0)
			{
				//send the oppcode to method to determine what instruction it is
				String oppWord = instructword(Integer.toHexString(oppcode));
				//get the offset from the instruction by using the bitmask
				offset = (short) (instructions[i]&offsetBitMask);
				
				//use if else to separate branch instructions
				if(oppWord.equals("beq") || oppWord.equals("bne"))
				{
					//decompress the offset
					int decompressed = offset<<2;
					//increment the PC by 4
					int dest = pc + addToAddress;
					//add the incremented PC and the decompressed offset to determine destination 
					dest += decompressed;					
					
					System.out.printf("Instruction in hex: %x , Decoded version: %x  %s  $%d , $%d , %x \n", instructions[i], pc,  oppWord, src2reg, src1reg, dest);
					
					
				}
				else {
					
					System.out.printf("Instruction in hex: %x , Decoded version: %x %s  $%d , %d($%d) \n", instructions[i], pc,  oppWord, src2reg, offset, src1reg);					
				}
				
				
			}
			else{
				
				//get destination register
				destreg = (instructions[i]&destBitMask)>>>11;
				//get function value 
				function = (instructions[i]&funcBitMask);
				
				//send function value to method to determine what instruction it is
				String funcWord = instructword(Integer.toHexString(function));
				
				
				System.out.printf("Instruction in hex: %x , Decoded version:%x  %s  $%d , $%d , $%d \n", instructions[i], pc,  funcWord, destreg, src1reg, src2reg);
								
			}
			
			//increment PC
			pc += addToAddress;
		
		}
		
	}
	
	//method to determine what instruction each hex value is
	String instructword(String hex)
	{
		
		switch(hex)
		{
		case "22":
			return "sub";
		case "20":
			return "add";
		case "24":
			return "and";
		case "4":
			return "beq";
		case "5":
			return "bne";
		case "23":
			return "lw";
		case "25":
			return "or";
		case "2b":
			return "sw";		
		default:
			return "nope";
		}
	}
}
