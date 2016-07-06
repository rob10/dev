
public class EightQueens {
	
	//initialize linked stack object
	LinkedStack stack = new LinkedStack();
	
	public void driver()
	{
		//boolean value to determine completion of program
		boolean success = false;
		
		
		//set first location
		String firstLocation = "1,1";

		//push first location onto stack
		stack.push(firstLocation);
		
		
		//Node m = new Node();
		
		//m = stack.head;
		
		//System.out.println(m.getData());
		
		//keep running until solution found
		while(!success && !stack.stackEmpty())
		{
			
			
			/*
			 * First check if there is a match. If there is a match then initialize a temporary node
			 * and set it to head. split the data into ints, if the column is greater than 8 then pop
			 * the the head off the stack. then set n to the new head, get the values of the new head,
			 * add 1 to the column, and then set the data top of the head to same row and the newly 
			 * incremented column. If the column is not greater than 8 then increment column by 1
			 * and set head data with same row or incremented column
			 */
			if(!checkForMatch())
			{
				Node stackHead = new Node();
				
				stackHead=stack.head;
				
				int row = getRow(stackHead.getData());
				int col = getCol(stackHead.getData());
				
				
					if(col>7)
					{
						
						stack.pop();
						
						stackHead=stack.head;
						row = getRow(stackHead.getData());
						col = getCol(stackHead.getData());
						
						
						col += 1;
						
						stackHead.setData("" + row + "," + col);
				
					}
					
					
					col += 1;
					
					stackHead.setData("" + row + "," + col);
				
				
			}
			//if there is no match and stack depth is 8 then set success to true to exit loop
			else if(checkForMatch() && stack.stackDepth() == 8){
				//stack.push(chosenLocation);
				
					success=true;
			}
			/*
			 * If there is no conflict and stackdepth is not 8 then get next location to add
			 * row would be stack.size +1 and column would equal one. push this location onto
			 * the stack.
			 */
			else{
				
				int nextRow = stack.stackDepth + 1;
				String nextLocation = "" + nextRow + "," + 1;
				stack.push(nextLocation);
				
			}
			
			
			
		}
		
		//call method that displays chessboard with the Queens on it
		showBoard();
		
		
	}
	
	private boolean checkForMatch()
	{
		
		
		 //if stack size is 1 then return true because it is the only one in the stack. this prevents the
		//head from checking against itself
		if(stack.stackDepth() == 1)
		{
			return true;
		}
		/*
		 * Walk through the stalk.Get the data of the head and the get the row and col.
		 * if column is greater than 8 then return false so that locations with col>8 don't
		 * get pushed on stack. Create temp Node and set it to head.next. Get data of Node and
		 * compare it to the head. if rol, columns or diagonal are equal then return false. if not
		 * then set tempnode to tempnode.next and compare again. if for loop done and no matches then
		 * return true. Used a while loop to avoid comparing head to a null node and causing a null 
		 * pointer exception.
		 * 
		 * 
		 */
		else{
			
			Node stackHead = stack.head;
			
			int row = getRow(stackHead.getData());
			int col = getCol(stackHead.getData());
			
			if(col>8)
			{
				return false;
			}
			
			
			Node tempNode = stackHead.getNext();
			
			//System.out.println(stack.toString());
			
			while(tempNode!=null)
			{
				int tempRow = getRow(tempNode.getData());
				int tempCol = getCol(tempNode.getData());
				
				int checkdiagonal1 = Math.abs(tempRow - row);
				int checkdiagonal2 = Math.abs(tempCol - col);
				
				
				
				
				if(row == tempRow || col == tempCol || checkdiagonal1 == checkdiagonal2 )
				{
					return false;
				}
				
				tempNode=tempNode.getNext();
			}
		}
		
		
		
		
		
		return true;
	}
	
	private void showBoard()
	{
		//set node to head
		Node stackHead = stack.head;
		
		
		/*
		 *String 2darray to save the locations of the Queens to then
		 *be able then print on the board
		 */
		String[][] queenLocations = new String [9][9];
		
		//walk through the stalk and get the data from the Node and split the strings
		//and then parse to ints. use the ints to indicate where in the 2dArray to enter
		//the Q String to indicate where the queens are supposed to be located in the chessboard
		for(int i = 0; i<stack.stackDepth(); i++)
		{
			
			int row = getRow(stackHead.getData());
			int col = getCol(stackHead.getData());
			
			queenLocations[row][col] = "Q";
			
			stackHead=stackHead.getNext();
			
		}
		
		/*
		 * Nested for loop to print chessboard with the queen pieces.	
		 */
		for (int i = 1; i<9; i++)
		{
			
			System.out.println("");
		    System.out.println("- - - - - - - - - - - - - - - -");
			
			for(int j = 1; j<9; j++)
			{
				if ( queenLocations[i][j] != null) {
			        System.out.print(" Q |");
			    }
			    else { 
			        System.out.print("   |");
			    }
			}
			
			
		}
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - -");
	}
	//Get Node data, split the string using the comma. the first element in the split string array is 
	//the row. parse it to int and return
	private int getRow(String location)
	{
		String[] tempSplit = location.split(",");
		int row = Integer.parseInt(tempSplit[0]);
		
		return row;
	}
	//same as getrow but return col
	private int getCol(String location)
	{
		String[] tempSplit = location.split(",");
		int col = Integer.parseInt(tempSplit[1]);
		
		return col;
	}

}
