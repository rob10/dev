//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #3 - Fraction Calculator
//  DUE:            Thursday 09/25/14
//

#import <Foundation/Foundation.h>

@interface Fraction : NSObject

//declare variables for fraction class
@property int numerator, denominator;

//declare methods for Fraction class
-(void) print;
-(void) setTo: (int) n over: (int) d;
-(Fraction *) add: (Fraction *) f;
-(Fraction *) subtract: (Fraction *) f;
-(Fraction *) multiply: (Fraction *) f;
-(Fraction *) divide: (Fraction *) f;


-(void) reduce;

-(double) convertToNum;
-(NSString *) convertToString;


@end
