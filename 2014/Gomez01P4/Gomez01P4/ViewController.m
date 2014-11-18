//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Address Book
//  DUE:            Thursday 10/14/14
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

//sythesize variables
@synthesize ab, nameField, emailField, count, newCard;

- (void)viewDidLoad
{
    //Create string for the 3 cards
    NSString *aName = @"Robert Gomez";
    NSString *aEmail = @"rob@rob.com";
    NSString *bName = @"John Doe";
    NSString *bEmail = @"john@rob.com";
    NSString *cName = @"Dwyane Wade";
    NSString *cEmail = @"dwade@rob.com";
    
    //make instance of address book
    ab = [[AddressBook alloc]
            initWithName: @"Rob's Address Book"];
    
    //create instances of address card
    AddressCard *card1 = [[AddressCard alloc] init];
    AddressCard *card2 = [[AddressCard alloc] init];
    AddressCard *card3 = [[AddressCard alloc] init];
    
    //set cards with strings made before
    [card1 setName: aName andEmail: aEmail];
    [card2 setName: bName andEmail: bEmail];
    [card3 setName: cName andEmail: cEmail];
    
    //add cards to book (NSMutableArray)
    [ab addCard: card1];
    [ab addCard: card2];
    [ab addCard: card3];
    
    //sort array alphabetically
    [ab sort2];
    //create instance of address card to display in text fields
    AddressCard *test = ab.book.firstObject;
    //set text fields to name and email from address book instance
    nameField.text = test.name;
    emailField.text = test.email;
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
   
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)pressedNext:(id)sender {
    
    //used to know what object is being displayed
    count++;
    
    //set count to 0
    if(count > ab.book.count - 1)
    {
        count = 0;
    }
    
    //loop through array
    for(AddressCard *test in ab.book)
    {
        
        if(count == [ab.book indexOfObject:test])
        {
            nameField.text = test.name;
            emailField.text = test.email;
        }
        
        
    }
    //set new button counter to 0 to make sure it wasn't pressed
    newCard = 0;
}

- (IBAction)pressedUpdate:(id)sender {
    
    //address card instance used ot add an object
    AddressCard *add = [[AddressCard alloc] init];
    
    //prompts user to enter text in the field
    if([nameField.text  isEqual: @""] || [emailField.text  isEqual: @""])
    {
        nameField.placeholder = @"Enter Name";
        emailField.placeholder = @"Enter Email";
    }
    else{
        
        //checks if new button was pressed
        if(newCard == 0)
        {
            //removes card
            AddressCard *remove =[[AddressCard alloc] init];
            remove = [ab.book objectAtIndex:count];
            [ab removeCard:remove];
        }
        
        //ads card
        [add setName:nameField.text andEmail:emailField.text];
        [ab addCard:add];
        //sorts array with new objects
        [ab sort2];
        //sets counter to 0 to tell program that new button needs to be pressed again
        newCard = 0;
        
    }
    
}

- (IBAction)pressedPrev:(id)sender {
    
    //decrement count
    --count;
    
    //sets count to last object
    if(count < 0)
    {
        count = ab.book.count - 1;
    }
    
    //loop through array backwards
    for(AddressCard *previous in [ab.book reverseObjectEnumerator])
    {
        
        if(count == [ab.book indexOfObject:previous])
        {
            nameField.text = previous.name;
            emailField.text = previous.email;
        }
    }
    
    //make sure new button wasn't pressed
    newCard = 0;
}


- (IBAction)pressedNew:(id)sender {
    
    //set fields to blank
    nameField.text = @"";
    emailField.text = @"";
    //new button was pressed, used in update method to differentiate between
    //adding a new object or editing one
    newCard++;
    
}

-(IBAction)textFieldReturn:(id)sender
{
    //resign first responder from both text fields
    [sender resignFirstResponder];
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    //intantiate a touch event
    UITouch *touch = [[event allTouches] anyObject];
    //if name field is firstresponder then resign it
    if ([nameField isFirstResponder] && [touch view] != nameField) {
        [nameField resignFirstResponder];
    }//if emailfield is first responder than resign it
    else if ([emailField isFirstResponder] && [touch view] != emailField) {
        [emailField resignFirstResponder];
    }
    [super touchesBegan:touches withEvent:event];
}

@end
