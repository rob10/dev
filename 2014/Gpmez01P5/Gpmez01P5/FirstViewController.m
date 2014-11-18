//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import "FirstViewController.h"


@interface FirstViewController ()

@end

@implementation FirstViewController

//synthesize properties
@synthesize label1, label2, label3, label4, pinButtons, pdb;


- (void)viewDidLoad
{
    //declare singleton database
    pdb = [PinDatabase sharedDB];
    
    self.title = NSLocalizedString(@"Pin", @"");
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)buttonPressed:(UIButton *)sender
{
    //declare local variable
    NSString *pinn;
    
    //self.label1.text = [NSString stringWithFormat:@"%i", sender.tag];
    
    
    //if else block to type on empty labels
    if([label1.text  isEqual: @""])
    {
        label1.text = [NSString stringWithFormat:@"%i", sender.tag];
    }
    else if([label2.text  isEqual: @""])
    {
        label2.text = [NSString stringWithFormat:@"%i", sender.tag];
    }
    else if([label3.text  isEqual: @""])
    {
        label3.text = [NSString stringWithFormat:@"%i", sender.tag];
    }
    else if([label4.text  isEqual: @""])
    {
        label4.text = [NSString stringWithFormat:@"%i", sender.tag];
        
        //merge into one string
        pinn = [NSString stringWithFormat:@"%@%@%@%@", label1.text, label2.text, label3.text, label4.text];
        
        //send pin to model class
        
        [pdb setWeb:pinn];
    
    }
    else{
        
        //sets them all to blank for the next input of string
        label1.text = [NSString stringWithFormat:@""];
        label2.text = [NSString stringWithFormat:@""];
        label3.text = [NSString stringWithFormat:@""];
        label4.text = [NSString stringWithFormat:@""];
        
    }    
}



@end
