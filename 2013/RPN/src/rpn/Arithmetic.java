/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

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
    double result = 0;;
    
    Arithmetic(String s)
    {
        expression = s;
        postfix = " ";
        length = expression.length();
        stk = new Stack();
    }
    boolean isBalance()
    {
        Scanner scan = new Scanner(expression);
        Stack balance = new Stack();
        Stack balance2 = new Stack();
        Stack balance3 = new Stack();
        boolean balanced = true;
        
        while(scan.hasNext())
        {
            String token = scan.next();
            char ch = token.charAt(0);
        
            if(isParentheses(ch))
            {
                if(Constants.LEFT_NORMAL == ch)
                {
                    balance.push(ch);
                    balanced = false;
                }
                else if(Constants.RIGHT_NORMAL == ch)
                {
                    try
                    {
                    balance.pop();
                    balanced = true;
                    }
                    catch(EmptyStackException e)
                    {
                        //balance.push(ch);
                        balanced = false;
                    }
                }
            }
            else if(isBrace(ch))
            {
                if(Constants.LEFT_BRACE == ch)
                {
                    balance2.push(ch);
                    balanced = false;
                }
                else if(Constants.RIGHT_BRACE == ch)
                {
                    try
                    {
                        balance2.pop();
                        balanced = true;
                    }
                    catch(EmptyStackException e)
                    {
                        //balance2.push(ch);
                        balanced = false;
                    }
                }
            }
            else if(isCurly(ch))
            {
                if(Constants.LEFT_CURL == ch)
                {
                    balance3.push(ch);
                    balanced = false;
                }
                else if(Constants.RIGHT_CURL == ch)
                {
                    try
                    {
                        balance3.pop();
                        balanced = true;
                    }
                    catch(EmptyStackException e)
                    {
                        //balance3.push(ch);
                        balanced = false;
                    }
                }
            }
            
        }
        if( balanced == true )
        {
            return balanced;
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
                        stk.push(new Character(current));
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
                else if(isBrace(current))
                {
                    if(stk.empty() || current == Constants.LEFT_BRACE)
                    {
                        //push this element on the stack
                        stk.push(new Character(current));
                    }
                    else if (current == Constants.RIGHT_BRACE)
                    {
                        try
                        {
                            
                            Character ch = (Character)stk.pop();
                            char top = ch.charValue();
                            
                            while(top != Constants.LEFT_BRACE)
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
                }
                else if(isCurly(current))
                {
                    if(stk.empty() || current == Constants.LEFT_CURL)
                    {
                        //push this element on the stack
                        stk.push(new Character(current));
                    }
                    else if (current == Constants.RIGHT_CURL)
                    {
                        try
                        {
                            
                            Character ch = (Character)stk.pop();
                            char top = ch.charValue();
                            
                            while(top != Constants.LEFT_CURL)
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
                }
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
                }
                
            }
        }//Outer loop ends
        
        try
        {
            while(!stk.empty())//Bullet#4
            {
                postfix = postfix + stk.pop() + " ";
                //complete
            }
               
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
        if(current == Constants.LEFT_NORMAL || current == Constants.RIGHT_NORMAL)
        {
            return true;
        }
        else
        {
            return false;
        } 
    }
    boolean isBrace(char current)
    {
        if(current == Constants.LEFT_BRACE || current == Constants.RIGHT_BRACE)
        {
            return true;
        }
        else
        {
            return false;
        } 
    }
    boolean isCurly(char current)
    {
        if(current == Constants.LEFT_CURL || current == Constants.RIGHT_CURL)
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
        boolean operator;
        switch(ch)
        {
            case '*':
                operator = true;
                break;
            case '/':
                operator = true;
                break;
            case '+':
                operator = true;
                break;
            case '-':
                operator = true;
                break;
            default:
                operator = false;
        }
        return operator;
        }
    
    boolean hasHigherPrecedence(char top, char current)
    {
        boolean higher;
        
        switch (current)
        {
            case '*':
                switch(top)
                {
                    case '+':
                        higher = true;
                        break;
                    case '-':
                        higher = true;
                        break;
                    case '/':
                        higher = true;
                        break;
                    default:
                        higher = false;
                }
            case '/':
                switch(top)
                {
                    case '+':
                        higher = true;
                        break;
                    case '-':
                        higher = true;
                        break;
                    case '*':
                        higher = false;
                        break;
                    default:
                        higher = false;
                }
            case '+':
                switch(top)
                {
                    case '/':
                        higher = false;
                        break;
                    case '-':
                        higher = true;
                        break;
                    case '*':
                        higher = false;
                        break;
                    default:
                        higher = false;
                }
            case '-':
                switch(top)
                {
                    case '/':
                        higher = false;
                            break;
                    case '+':
                            higher = false;
                            break;
                    case '*':
                            higher = false;
                            break;
                    default:
                            higher = false;
                }
            default:
                higher = false;
        }
        
        return higher;
    }
    String getPostfix()
    {
        return postfix;
    }
    void evaluateRPN() 
    {
        Scanner scan = new Scanner(postfix);
        char current;
        int store;
        Stack stk2 = new Stack();
        while(scan.hasNext())
        {
            String token = scan.next();
            try
            {
                
            if (isNumber(token))
            {
                store = Integer.parseInt(token);
                stk2.push(new Integer(store));
            }
            else
            {
                current = token.charAt(0);
                if (isOperator(current))
                {
                    
                        try
                        {
                            int t1 = (Integer)stk2.pop();
                            int t2 = (Integer)stk2.pop();
                            int t3 = 0;
                            switch(current)
                            {
                                case'+':
                                    t3 = t1 + t2;
                                    stk2.push(t3);
                                    break;
                                case'-':
                                    t3 = t1 - t2;
                                    stk2.push(t3);
                                    break;
                                case'*':
                                    t3 = t1 * t2;
                                    stk2.push(t3);
                                    break;
                                case '/':
                                    t3 = t1/t2;
                                    stk2.push(t3);
                                    break;
                                default:
                                    
                            }
                        }
                        catch(ClassCastException | EmptyStackException e)
                        {
                            
                        }
                    }
            }
            }
            catch(NumberFormatException e)
            {
                
            }
        }
        try
        {
            while(!stk2.empty())
            {
                result = (Integer)stk2.pop();
            }
        }
        catch(EmptyStackException e)
        {
            
        }
    }
    double getResult() 
    {
        return result;
    }
   }


