//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Address Book
//  DUE:            Thursday 10/14/14
//

#import <UIKit/UIKit.h>
#import "AddressBook.h"

@interface ViewController : UIViewController


//make instance of address book
@property (strong , nonatomic) AddressBook *ab;
//declare counters
@property int count;
@property int newCard;
//declare text fields
@property (weak, nonatomic) IBOutlet UITextField *nameField;
@property (weak, nonatomic) IBOutlet UITextField *emailField;
//declare actions
- (IBAction)pressedNext:(id)sender;
- (IBAction)pressedUpdate:(id)sender;
- (IBAction)pressedPrev:(id)sender;
- (IBAction)pressedNew:(id)sender;
-(IBAction)textFieldReturn:(id)sender;
//declare event to dismiss keyboard
-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event;



@end
