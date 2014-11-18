//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #3 - Fraction Calculator
//  DUE:            Thursday 09/25/14
//

#import "ViewController.h"
#import "Calculator.h"
@interface ViewController ()

@end

@implementation ViewController
{
    //initialize variables that are
    //going to be used later
    
    //used to store Operator character
    char op;
    //used to store current number being entered
    int currentNumber;
    //firstOperand - used to differentiate from operands
    //isNumerator - used to differentiate from Numerator and Denominator
    //isAccumulator - used to check if user did an operation and then wants to convert
    BOOL firstOperand, isNumerator, isAccumulator;
    //instance of Calculator
    Calculator *myCalculator;
    //NSMutableString used to modify the String and then send ti to label
    NSMutableString *displayString;
}

@synthesize display;

- (void)viewDidLoad
{
    //[super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    //set variables when the program starts
    firstOperand = YES;
    isNumerator = YES;
    displayString = [NSMutableString stringWithCapacity:40];
    myCalculator = [[Calculator alloc] init];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

//holds the digit pressed in current number
//and displays it in the label
-(void) processDigit:(int)digit
{
    currentNumber = currentNumber * 10  + digit;
   
    [displayString appendString:
     [NSString stringWithFormat:@"%i", digit]];
    
    display.text = displayString;
}

//gets tag of digit pressed and then
//sends it to processDigit
-(IBAction)clickDigit: (UIButton *) sender
{
    int digit = sender.tag;
    
    [self processDigit: digit];
    
    
}

//receives a char of the button that was
//pressed and then appends the string to
//the label
-(void) processOp:(char)theOp
{
    NSString *opStr;
    
    op=theOp;
    
    switch (theOp)
    {
        case '+' :
            opStr = @" + ";
            break;
        case '-' :
            opStr = @" - ";
            break;
        case '*' :
            opStr = @" * ";
            break;
        case '/' :
            opStr = @" / ";
            break;
            
    }
    
    [self storeFracPart];
    firstOperand = NO;
    isNumerator = YES;
    
    [displayString appendString: opStr];
    display.text = displayString;
    
}

//used to store numerator and denominators
-(void) storeFracPart
{
    
    if (firstOperand) {
        if(isNumerator){
            myCalculator.operand1.numerator = currentNumber;
            myCalculator.operand1.denominator = 1;
            
        }
        else
            myCalculator.operand1.denominator = currentNumber;
        
    }
    else if (isNumerator)
    {
        myCalculator.operand2.numerator = currentNumber;
        myCalculator.operand2.denominator = 1;
        
    }
    else{
        myCalculator.operand2.denominator = currentNumber;
        firstOperand = YES;
    }
    
    currentNumber = 0;

}

//calls store fraction method and appends
// the / in the string
-(IBAction)clickOver
{
    [self storeFracPart];
    isNumerator = NO;
    [displayString appendString:@"/"];
    display.text = displayString;
}

//it sends the plus char to processOp
-(IBAction)clickPlus
{
    [self processOp: '+'];
}
//it sends the minus char to processOp
-(IBAction)clickMinus
{
    [self processOp: '-'];
}
//it sends the multiply char to processOp
-(IBAction)clickMultiply
{
    [self processOp: '*'];
}
//it sends the divide char to processOp
-(IBAction)clickDivide
{
    [self processOp: '/'];
}

//calls the Calculator method that does the operation
//then appends answer to string and displays it
//and finally it reinitializes all the variables
//to the default except for isAccumulator
-(IBAction)clickEquals
{
    if (firstOperand == NO)
    {
        [self storeFracPart];
        [myCalculator performOperation: op];
        
        [displayString appendString: @" = "];
        [displayString appendString: [myCalculator.accumulator
                                      convertToString]];
        display.text = displayString;
        
        currentNumber = 0;
        isNumerator = YES;
        firstOperand = YES;
        [displayString setString:@""];
        isAccumulator = YES;
        
    }
}

//initializes variables to default
-(IBAction)clickClear
{
    isNumerator = YES;
    firstOperand = YES;
    currentNumber = 0;
    isAccumulator = NO;
    [myCalculator clear];
    
    [displayString setString:@""];
    display.text = displayString;
}

//it takes either the answer of an operation or a fraction entered
//then converts it to decimal and then displays it on the label
-(IBAction)convert
{
    [self storeFracPart];
    
    if(isAccumulator)
        [displayString appendString: [NSString stringWithFormat:@" = %f", myCalculator.accumulator.convertToNum]];
    else
        [displayString appendString: [NSString stringWithFormat:@" = %f", myCalculator.operand1.convertToNum]];
    display.text = displayString;

    
}
@end
