//
//Programmer: Robert Gomez
//PantherID: 4646026
//Class: COP 4655
//Instructor: Steve Luis ECS 282
//Assignment: Program Assignment #2
//Due: 09/16/14
//
//
//  Tic Tac Toe
//
//  Created by Robert on 9/4/14.
//  Copyright (c) 2014 fiu. All rights reserved.
//

#import "ViewController.h"


@interface ViewController ()

@end



@implementation ViewController


@synthesize buttonCollection;

- (void)viewDidLoad
{
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


- (IBAction)pressedReset:(id)sender {
    
    
    for (UIButton *button in buttonCollection)
    {
        [button setTitle:@" " forState:UIControlStateNormal];
    }
    
    
    

    
}

- (IBAction)buttonPressed:(id)sender {
  
   
    GameBoard *gb = [[GameBoard alloc] init];
    //gb setButton:2:2];
    
    //GameBoard *gb = [[GameBoard alloc] init];
    
    
    
    
    for (UIButton *button in buttonCollection)
    {
        if(sender == button)
        {
            
            if([button.currentTitle  isEqual: @" "])
            {
                gb.buttonIndex = button.tag;
                gb.buttonState = @"X";
                [gb setStates];
                
                [button setTitle:gb.buttonState forState:UIControlStateNormal];
            }
            else if([button.currentTitle  isEqual: @"X"])
            {
                gb.buttonIndex = button.tag;
                gb.buttonState = @"O";
                [gb setStates];
                
                [button setTitle:gb.buttonState forState:UIControlStateNormal];
                
                //[sender setTitle:@"o" forState:UIControlStateNormal];
            }
            else if([button.currentTitle  isEqual: @"O"])
            {
                gb.buttonIndex = button.tag;
                gb.buttonState = @" ";
                [gb setStates];
                
                [button setTitle:gb.buttonState forState:UIControlStateNormal];
                
                //[sender setTitle:@" " forState:UIControlStateNormal];
            }
            else{
                [button setTitle:@" " forState:UIControlStateNormal];
            }

        }
        
    }
    

   

    
}


@end
