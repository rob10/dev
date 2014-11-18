/**********
 * 
 * Robert Gomez
 * COP3804
 * 
 * 
 * 
 * 
 * 
 * ************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

/**
 *
 * @author Robert
 */
class RPN
{
	public static void main(String[] arg)
	{
		String s[] = {"5 + ) * ( 2"," 2 + ( - 3 * 5 ) ","( ( 2 + 3 ) * 5 ) * 8 ",
                    "5 * 10 + ( 15 - 20 ) )  - 25 "," 5 + ( 5 *  10 + ( 15 - 20 )  - 25 ) * 9 ",
                    "2 + { 2 * ( 10 – 4 ) / [ { 4 * 2 / ( 3 + 4 ) } + 2 ] – 9 } ",
                    "2 + } 2 * ( 10 – 4 ) / [ { 4 * 2 / ( 3 + 4) } + 2 ] – 9 { "};
                
		for (int i = 0; i < s.length; i++)
		{

			Arithmetic a = new Arithmetic(s[i]);
			if (a.isBalance())
			{
				System.out.println("Expression " + s[i] + " is balanced\n");
				a.postfixExpression();
                                
				System.out.println("The post fixed expression is " + a.getPostfix());
				a.evaluateRPN();
				System.out.println("The result is : " + a.getResult()  + "\n" );
                                
                                
			}
			else
				System.out.println("Expression is not balanced\n");
		}
	}
}