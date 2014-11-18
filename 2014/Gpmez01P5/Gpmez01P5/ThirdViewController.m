//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import "ThirdViewController.h"

@interface ThirdViewController ()

@end



@implementation ThirdViewController


@synthesize urlTextField, pinTextField, pdb2;

- (void)viewDidLoad
{
    
    self.title = NSLocalizedString(@"Edit", @"");
    pdb2 = [PinDatabase sharedDB];
    
    
    for(UITextField *pin in pinTextField)
    {
        
        if(pin.tag == 1)
        {
            pin.text = @"1111";
            pin.delegate = self;
            pin.returnKeyType = UIReturnKeyDone;

        }
        else if(pin.tag == 2)
        {
            pin.text = @"2222";
            pin.delegate = self;
            pin.returnKeyType = UIReturnKeyDone;

        }
        else if(pin.tag == 3)
        {
            pin.text = @"3333";
            pin.delegate = self;
            pin.returnKeyType = UIReturnKeyDone;

        }
        else{
            
            pin.delegate = self;
            pin.placeholder = @"Enter Pin";
            pin.returnKeyType = UIReturnKeyDone;
        }
    }
    
    for(UITextField *url in urlTextField)
    {
        if(url.tag == 1)
        {
            url.text = [pdb2 getURL:@"1111"];
        }
        else if(url.tag == 2)
        {
            url.text = [pdb2 getURL:@"2222"];
        }
        else if(url.tag == 3)
        {
            url.text = [pdb2 getURL:@"3333"];
        }
    }
 
    
    for (UITextField *url in urlTextField)
    {
        url.delegate = self;
        url.placeholder = @"Enter a URL in http format";
        url.returnKeyType = UIReturnKeyDone;
        url.keyboardType = UIKeyboardTypeURL;	// this makes the keyboard more friendly for typing URLs
        url.autocapitalizationType = UITextAutocapitalizationTypeNone;	// don't capitalize
        url.autocorrectionType = UITextAutocorrectionTypeNo;	// we don't like autocompletion while typing
        url.clearButtonMode = UITextFieldViewModeAlways;

        
    }
    
    
    
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}



 - (BOOL)textFieldShouldReturn:(UITextField *)textField
 {
     

     [textField resignFirstResponder];
     
     [pdb2 removeUrl];
     
     for(UITextField *pin in pinTextField)
     {
         for(UITextField *url in urlTextField)
         {
             if(pin.tag == url.tag)
             {
                 
                 if(![pin.text  isEqual: @""] && ![url.text  isEqual: @""])
                 {
                     [pdb2 addPins:pin.text :url.text];
                 }
             }
         }
         
     }
     

 
 return YES;
 }

@end
