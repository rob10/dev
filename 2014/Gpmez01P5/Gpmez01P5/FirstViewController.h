//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import <UIKit/UIKit.h>
#import "PinDatabase.h"
#import "SecondViewController.h"

@interface FirstViewController : UIViewController


//declare labels for the digits
@property (strong, nonatomic) IBOutlet UILabel *label1;
@property (strong, nonatomic) IBOutlet UILabel *label2;
@property (weak, nonatomic) IBOutlet UILabel *label3;
@property (weak, nonatomic) IBOutlet UILabel *label4;
//declare database instance
@property (nonatomic, retain)PinDatabase *pdb;
//make an outlet collection for the buttons
@property (strong, nonatomic) IBOutletCollection(UIButton) NSArray *pinButtons;
//declare action method for button pressed
-(IBAction)buttonPressed:(id)sender;


@end
