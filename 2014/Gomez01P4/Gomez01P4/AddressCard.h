//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Address Book
//  DUE:            Thursday 10/14/14
//

#import <Foundation/Foundation.h>

@interface AddressCard : NSObject <NSCopying, NSCoding>

@property (nonatomic, copy) NSString *name, *email;

-(void) setName: (NSString *) theName andEmail: (NSString *) theEmail;
-(void) assignName: (NSString *) theName andEmail: (NSString *) theEmail;
-(NSComparisonResult) compareNames: (id) element;

-(void) print;


@end
