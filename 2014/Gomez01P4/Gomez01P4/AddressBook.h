//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Address Book
//  DUE:            Thursday 10/14/14
//

#import <Foundation/Foundation.h>
#import "AddressCard.h"

@interface AddressBook : NSObject <NSCopying, NSCoding>

@property (nonatomic, copy) NSString *bookName;
@property (nonatomic, strong) NSMutableArray *book;


-(id) initWithName: (NSString *) name;
-(void) sort;
-(void) sort2;
-(void) addCard: (AddressCard *) theCard;
-(void) removeCard: (AddressCard *) theCard;
-(NSUInteger) entries;
-(void) list;
-(AddressCard *) lookup: (NSString *) theName;


@end
