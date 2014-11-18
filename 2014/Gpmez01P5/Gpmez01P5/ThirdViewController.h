//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import <UIKit/UIKit.h>
#import "SecondViewController.h"


@interface ThirdViewController : UIViewController <UITextFieldDelegate, UIScrollViewAccessibilityDelegate>

@property (strong, nonatomic) IBOutletCollection(UITextField) NSArray *pinTextField;
@property (strong, nonatomic) IBOutletCollection(UITextField) NSArray *urlTextField;

@property (nonatomic, retain) PinDatabase *pdb2;

@end
