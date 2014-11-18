//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #3 - Fraction Calculator
//  DUE:            Thursday 09/25/14
//

#import "Calculator.h"

@implementation Calculator

//synthesize variables
@synthesize operand1, operand2, accumulator;

//initialize variables
-(id) init
{
    self = [super init];
    
    if (self)
    {
        operand1 = [[Fraction alloc] init];
        operand2 = [[Fraction alloc] init];
        accumulator = [[Fraction alloc] init];
        
    }
    return self;
}

//clear values of accumulator
//which holds the answer of
//the expression
-(void) clear
{
    accumulator.numerator = 0;
    accumulator.denominator = 0;
    
}

//takes a char variable from clickEquals method in controller
//and uses switch statement decide with fraction operation method to
//call. Then initializes accumulator to the result of the operations and
//returns it.
-(Fraction *) performOperation:(char)op
{
    Fraction *result;
    switch(op) {
            case '+':
            result = [operand1 add: operand2];
            break;
            case '-':
            result = [operand1 subtract: operand2];
            break;
            case '*':
            result = [operand1 multiply: operand2];
            break;
            case '/':
            result = [operand1 divide: operand2];
    
    }
    
    accumulator.numerator = result.numerator;
    accumulator.denominator = result.denominator;
    
    return accumulator;
    
    
}


@end
