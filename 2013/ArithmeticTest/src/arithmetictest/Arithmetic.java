/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetictest;

/**
 *
 * @author Robert
 */
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Arithmetic {
    Stack stk;
    String expression , postfix;
    int length;
    
    Arithmetic(String s)
    {
        expression = s;
        postfix = "";
        length = expression.length();
        stk = new Stack();
    }
    boolean isBalance()
    {
        Scanner balanced = new Scanner(expression);
        int open = 0;
        
        while(balanced.hasNext())
        {
            String token = balanced.next();
            switch (token) {
                case "(":
                    open++;
                    break;
                case ")":
                    open--;
                    break;
            }
        }
        if(open == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    void postfixExpression()
    {
        Scanner scan = new Scanner(expression);
        char current;
        while(scan.hasNext())
        {
            String token = scan.next();
            
            if(isNumber(token))
                postfix = postfix + token + " ";
            else
            {
                current = token.charAt(0);
                
                if(isParentheses(current))
                {
                    if(stk.empty() || current == Constants.LEFT_NORMAL)
                    {
                        //push this element on the stack
                        stk.push(current);
                    }
                    else if (current == Constants.RIGHT_NORMAL)
                    {
                        try
                        {
                            //some details ... whatever is popped from the
                            //stack is an object, hence you must cast this
                            //object to its proper type, then extract its 
                            //primitive data (type) value.
                            Character ch = (Character)stk.pop();
                            char top = ch.charValue();
                            
                            while(top != Constants.LEFT_NORMAL)
                            {
                                postfix = postfix + top + " ";
                                ch = (Character)stk.pop();
                                
                                top = ch.charValue();
                            }
                        }
                        catch(EmptyStackException e)
                        {
                            
                        }
                    }
                }//Bullet #2 ends
                else if (isOperator(current))//Bullet #3 begins
                {
                    if(stk.empty())
                        stk.push(new Character(current));
                    else
                    {
                        try
                        {
                            //Remember the method peek simply looks at the top
                            //element on the stack, but does not remove it
                            //see class note API
                            char top = (Character)stk.peek();
                            boolean higher = hasHigherPrecedence(top, current);
                            
                            while(top != Constants.LEFT_NORMAL && higher)
                            {
                                postfix = postfix + stk.pop() + " ";
                                top = (Character)stk.peek();
                            }
                            stk.push(new Character(current));
                        }
                        catch(EmptyStackException e)
                        {
                            stk.push(new Character(current));
                        }
                    }
                }//Bullet #3 ends
            }
        }//Outer loop ends
        
        try
        {
            while(!stk.empty()) //Bullet #4
                //complete
        }
        catch(EmptyStackException e)
        {
            
        }
    }
    boolean isNumber(String str)
    {
        if("(".equals(str) || ")".equals(str) || "*".equals(str) || "/".equals(str) ||
           "+".equals(str) || "-".equals(str) || "%".equals(str) || "{".equals(str) ||
           "}".equals(str) || "[".equals(str) || "]".equals(str))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    boolean isParentheses(char current)
    {
        if(current == '(' || current == ')')
        {
            return true;
        }
        else
        {
            return false;
        }
        
            
    }
    boolean isOperator(char ch)
    {
        if(ch == '*' || ch == '+' || ch == '-' || ch == '/' || ch == '%')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    boolean hasHigherPrecedence(char top, char current)
    {
        //define this method
    }
    String getPostfix()
    {
        //define method
    }

    void evaluateRPN() 
    {
        
    }

    String getResult() 
    {
        
    }
   }
}
