//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #3 - Fraction Calculator
//  DUE:            Thursday 09/25/14
//

#import <UIKit/UIKit.h>
#import "Calculator.h"

@interface ViewController : UIViewController

//declare label
@property (strong, nonatomic) IBOutlet UILabel *display;

//extra methods to help
//your action methods process
//the data
-(void) processDigit: (int) digit;
-(void) processOp: (char) theOp;
-(void) storeFracPart;

//Action method for every time a number
//is pressed
-(IBAction)clickDigit:(UIButton *)sender;

//action methods for when
//operators are pressed
-(IBAction) clickPlus;
-(IBAction) clickMinus;
-(IBAction) clickMultiply;
-(IBAction) clickDivide;

//action methods for when
//misc buttons are pressed
-(IBAction) clickOver;
-(IBAction) clickEquals;
-(IBAction) clickClear;
-(IBAction) convert;

@end
