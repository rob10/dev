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

#import <Foundation/Foundation.h>

@interface GameBoard : NSObject

@property (nonatomic)NSInteger buttonIndex;
@property (nonatomic)NSString* buttonState;

@property NSMutableArray *states;


-(void) setButtonIndex:(NSInteger)buttonIndex;
-(void) setButtonState:(NSString *)butonState;
-(void) setStates;



@end
