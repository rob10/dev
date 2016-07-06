import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Cache {
	
	/*
	 * Declare Main memory array, cache array, and value user is asking for
	 */
	private short MM[] = new short[2048];
	private Slot cache[] = new Slot[16];
	private int showValue;
	
	
	public void Driver()
	{
		
				
				
				//initialize main memory array
				for(short i = 0; i<8; i++)
				{
					for(short j = 0; j<256; j++)
					{
							MM[j+(i*256)]=j;
						
					}
				}
				
				//create array to hold value 0 
				int[] initialValues = new int[16];
				
				//initialize the array with 0
				for(int i = 0; i<16; i++)
				{
					initialValues[i] = 0;
				}
				
				/*
				 * For loop that creates slot objects and initializes them to 0 values
				 * and then adds them to the cache array
				 */
				for(int i = 0; i<16 ; i++)
				{
					Slot temp = new Slot();
					
					temp.setSlot(i);
					temp.setTag(0);
					temp.setValidBit(0);
					temp.setData(initialValues);
					
					cache[i] = temp;
					
				}
				
				//String array to hold operations from text file
				String[] operations = new String[50];
				
				/*
				 * Try catch block. goes through file and adds each line to
				 * the String array
				 */
				try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
				    String line;
					int i = 0;
					line = br.readLine();
					while(line != null)
					{
						line = br.readLine();
						operations[i] = line;
						i++;
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//used to determine when program is done
				boolean success = false;
				//used to hold to use input from the file
				String userInput;
				
				//used to know which instruction to get from array
				int count = 0;
				
				
				while(!success)
				{
					//display prompt for command
					System.out.print("(R)ead, (W)rite, (D)isplay or (Q)uit: ");
					//print command from string array
					System.out.println(operations[count]);
					//set user input to operation displayed
					userInput = operations[count];
					//declare string to hold the hexstring when its created
					String hexString;
					//declare int to hold parsed hex string
					int address;
					//switch statement for commands
					switch(userInput)
					{
					case "R":
						//ask for address
						System.out.print("Enter Address: ");
						//increment count
						count++;
						//get input from operation array using the given location
						System.out.println(operations[count]);
						userInput = operations[count];
						
						//add the what is needed to the input string so that it is
						//a hex string
						hexString = "0x00" + userInput;
						//convert hex string to int and store in address
						address = Integer.decode(hexString);
						
					    /* 
					     * if else statement used to determine if the given address was a cache hit or miss
					     * The if statement calls a boolean method that accepts an address and returns true 
					     * if no miss or false if there is a miss
					     * 
					     */
						if(!readCache(address))
						{
							System.out.printf("At that byte there is the value %x (Cache Miss)\n", showValue);
						}
						else{
							System.out.printf("At that byte there is the value %x (Cache Hit)\n", showValue);
						}
						break;
					case "W":
						//same operation as read
						System.out.print("Enter Address: ");
						count++;
						System.out.println(operations[count]);
						userInput = operations[count];
						
						//same operation as read
						hexString = "0x0" + userInput;
						address = Integer.decode(hexString);
						
						//get value
						System.out.print("Enter Value: ");
						count++;
						System.out.println(operations[count]);
						userInput = operations[count];
						
						
						hexString = "0x0" + userInput;
						int val = Integer.decode(hexString);
						
						 /* 
					     * if else statement used to determine if the given address was a cache hit or miss
					     * The if statement calls a boolean method that accepts an address and a value then
					     *  returns true if no miss or false if there is a miss. 
					     * 
					     */
						if(!writeCache(address, val))
						{
							System.out.printf("Value %x has been written at location %x (Cache Miss)\n", showValue, address);
						}
						else{
							System.out.printf("Value %x has been written at location %x (Cache Hit)\n", showValue, address);
						}
						
						break;
					case "D":
						//calls method to display cache
						display();
						
						break;
					case "Q":
						//finish program
						success = true;
						break;
					default:
						//user entered wrong command
						System.out.println("");
						System.out.println("Wrong Selection");
						
					}
					
					//increment counter
					count++;
					
					
					
				}
				
			
	}
	

	public boolean readCache(int addr)
	{
		
		
		//get the offset, last 4 digits
		int offset = addr & 0x00F;
		
		//get the start of the address
		int beginAddr = addr & 0xFF0; 
		
		//get the tag, just shift right 8 digits
		int tag = addr>>8;
		
		//get the slot number, separate the middle 4 digits. 
		int slotNum = (addr&0x0F0)>>4;
		
		/*
		 * if the valid bit at the given location in the cache is equal to zero 
		 * or the tag number at the given location in the cache is equal to the 
		 * tag number from the address user entered, the it is a miss cause the
		 * address is not in the cache.
		 * 	
		 */
		if(cache[slotNum].getValidBit() == 0 || cache[slotNum].getTag() != tag)
		{
			//create Slot object. 
			Slot temp = new Slot();
			
			//set values
			temp.setSlot(slotNum);
			temp.setTag(tag);
			temp.setValidBit(1);
			
			//temporary array to hold address from main memory
			int tempArray[] = new int [16];
			
			/*
			 * loop through array and add the value for Main memory
			 * start at the beginning address and increment until 15(F)
			 */
			for(int i = 0; i<16 ; i++)
			{
				tempArray[i] = MM[beginAddr+i];
				//System.out.println(Integer.toHexString(tempArray[i]));
			}
			
			//set array in the slot object to the array where all the
			//data from main memory was saved
			temp.setData(tempArray);
			
			//add slot object to cache array
			cache[slotNum] = temp;
			
			//get the value user requested and set it to
			//showValue to display later
			showValue = cache[slotNum].getValue(offset);
			
			//return false so it is known to be a miss
			return false;
			
		}
		else
		{
			//get the value user requested and set it to
			//showValue to display later
			showValue = cache[slotNum].getValue(offset);
			
			//return true so it is known to be a hit
			return true;
		}
		
		
		
	}
	
	private boolean writeCache(int addr, int value)
	{
		
				
				//get the offset, last 4 digits
				int offset = addr & 0x00F;
				
				
				//get the start of the address
				int beginAddr = addr & 0xFF0; 
				
				
				//get the tag, just shift right 8 digits
				int tag = addr>>8;
				
				//separate the middle 4 digits. 
				int slotNum = (addr&0x0F0)>>4;
				
				/*
				 * if the valid bit at the given location in the cache is equal to zero 
				 * or the tag number at the given location in the cache is equal to the 
				 * tag number from the address user entered, then it is a miss cause the
				 * address is not in the cache.
				 * 	
				 */
				if(cache[slotNum].getValidBit() == 0 || cache[slotNum].getTag() != tag)
				{
					//create slot object. 
					Slot temp = new Slot();
					
					//set values
					temp.setSlot(slotNum);
					temp.setTag(tag);
					temp.setValidBit(1);
					
					//temporary array to hold address from main memory
					int tempArray[] = new int [16];
					
					/*
					 * loop through array and add the value for Main memory
					 * start at the beginning address and increment until 15(F)
					 */
					for(int i = 0; i<16 ; i++)
					{
						tempArray[i] = MM[beginAddr+i];
						//System.out.println(Integer.toHexString(tempArray[i]));
					}
					
					//set array in the slot object to the array where all the
					//data from main memory was saved
					temp.setData(tempArray);
					
					
					cache[slotNum] = temp;
					
					//set the value user entered and at the location
					//user requested
					cache[slotNum].setValue(offset, value);
					
					////get the value user changed and set it to
					//showValue to display later
					showValue = cache[slotNum].getValue(offset);
					
					//return false so it is known to be a miss
					return false;
					
				}
				else
				{
					cache[slotNum].setValue(offset, value);
					showValue = cache[slotNum].getValue(offset);
					
					//return true so it is known to be a hit
					return true;
				}
		
		//return false;
	}
	
	//display cache
	private void display()
	{
	
		System.out.println("Slot Valid Tag         Data");
		
		for(int i = 0; i<16; i++)
		{
			//use tostring method created in slot class
			System.out.println(cache[i].toString());
		}
	}
	

}
