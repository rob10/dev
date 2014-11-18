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

#import <UIKit/UIKit.h>
#import "GameBoard.h"

@interface ViewController : UIViewController

@property (strong, nonatomic) IBOutletCollection(UIButton) NSArray *buttonCollection;

- (IBAction)pressedReset:(id)sender;

- (IBAction)buttonPressed:(id)sender;


@end
