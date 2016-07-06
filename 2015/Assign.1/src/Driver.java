
public class Driver {

	public static void main(String[] args) {
        
		Driver me = new Driver();
		me.startProg();
	}
	
	public void startProg()
	{
		EightQueens chessboard = new EightQueens();
		
		chessboard.driver();
	}

}
