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

#import "GameBoard.h"

@implementation GameBoard


@synthesize buttonIndex;
@synthesize buttonState;
@synthesize states;


-(void)setButtonState:(NSString *)bState
{
    
    buttonState = bState;
    
    }

-(void)setButtonIndex:(NSInteger)bIndex
{
    buttonIndex = bIndex;
    
}

-(void)setStates
{
    states = [[NSMutableArray alloc] initWithCapacity:9];
    for(int i=0; i<9; i++)
    {
        [states addObject:@" "];
    }
    
    NSUInteger nsi = (NSUInteger) buttonIndex;
    
    [states insertObject:buttonState atIndex:nsi];
    
}


@end
