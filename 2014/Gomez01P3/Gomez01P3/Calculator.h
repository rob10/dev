//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #3 - Fraction Calculator
//  DUE:            Thursday 09/25/14
//

#import <Foundation/Foundation.h>
#import "Fraction.h"

@interface Calculator : NSObject

//declare properties for calculator class
//which are instances of fraction class
@property (strong, nonatomic) Fraction *operand1;
@property (strong, nonatomic) Fraction *operand2;
@property (strong, nonatomic) Fraction *accumulator;

//declare method for calculator class
-(Fraction *) performOperation: (char) op;
-(void) clear;



@end
