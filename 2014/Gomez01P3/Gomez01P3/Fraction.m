//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #3 - Fraction Calculator
//  DUE:            Thursday 09/25/14
//

#import "Fraction.h"

@implementation Fraction

//synthesie variables
@synthesize numerator, denominator;

//sets local variables to the values that were sent by controller
-(void) setTo: (int) n over:(int)d
{
    numerator = n;
    denominator = d;
    
}

//print out denominator and numerator
-(void) print
{
    NSLog(@"%i/%i",numerator,denominator);
}

//converts the fraction to decimal value
-(double) convertToNum
{
    
    if(denominator != 0)
    {
       
        return (double) numerator / denominator;
        
    }
    
    else
        return NAN;
}

//converts the fraction to a string to be able
//to be called by controller and display on label
-(NSString *) convertToString
{
    
    if(numerator == denominator)
        if(numerator == 0)
            return @"0";
        else
        return @"1";
    else if(denominator == 1)
        return [NSString stringWithFormat:@"%i", numerator];
    else{
        return [NSString stringWithFormat:@"%i/%i",
                numerator,denominator];
    }
    
}

//adds fractions
-(Fraction *) add:(Fraction *)f
{
    Fraction *result = [[Fraction alloc] init];
    
    result.numerator = numerator * f.denominator +
    denominator * f.numerator;
    
    result.denominator = denominator * f.denominator;
    
    [result reduce];
    return result;
    
}

//subtract fractions
-(Fraction *) subtract:(Fraction *)f
{
    Fraction *result = [[Fraction alloc] init];
    
    result.numerator = numerator * f.denominator -
    denominator * f.numerator;
    
    result.denominator = denominator * f.denominator;
    
    [result reduce];
    return result;
    
}

//multiply fractions
-(Fraction *) multiply:(Fraction *)f
{
    Fraction *result = [[Fraction alloc] init];
    
    result.numerator = numerator * f.numerator;
    result.denominator = denominator * f.denominator;
    [result reduce];
    
    return result;
}

//divide fractions
-(Fraction *) divide:(Fraction *)f
{
    Fraction *result = [[Fraction alloc] init];
    
    result.numerator = numerator * f.denominator;
    result.denominator = denominator * f.numerator;
    
    [result reduce];
    
    return result;
}

//reduce the value of the numerator and denominator
-(void) reduce
{
    int u = numerator;
    int v = denominator;
    int temp;
    
    if(u==0)
        return;
    else if(u<0)
        u = -u;
    
    while ( v != 0)
    {
        temp = u % v;
        u = v;
        v = temp;
        
    }
    
    numerator /= u;
    denominator /= u;
}


@end
