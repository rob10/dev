//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Address Book
//  DUE:            Thursday 10/14/14
//

#import "AddressCard.h"

@implementation AddressCard

@synthesize name, email;

-(void) setName: (NSString *) theName andEmail: (NSString *) theEmail
{
    self.name = theName;
    self.email = theEmail;
}

-(NSComparisonResult) compareNames: (id) element
{
    return [name compare: [element name]];
}

-(void) print
{
    NSLog (@"============================");
    NSLog(@"|                            |");
    NSLog(@"|   %-31s|", [name UTF8String]);
    NSLog(@"|   %-31s|", [email UTF8String]);
    NSLog (@"                            ");
    NSLog (@"                            ");
    NSLog (@"                            ");
    NSLog (@"     O             O        ");
    NSLog (@"============================");
    
}

-(id) copyWithZone:(NSZone *)zone
{
    id newCard = [[[self class] allocWithZone: zone] init];
    [newCard assignName: name andEmail: email];
    return newCard;
    
}

-(void) assignName: (NSString *) theName andEmail:(NSString *)theEmail
{
    name = theName;
    email = theEmail;
}

-(void) encodeWithCoder: (NSCoder *) encoder
{
    [encoder encodeObject:name forKey:@"AddressCardName"];
    [encoder encodeObject:email forKey:@"AddressCardEmail"];

}

-(id) initWithCoder: (NSCoder *) decoder
{
    name = [decoder decodeObjectForKey: @"AddressCardName"];
    email = [decoder decodeObjectForKey: @"AddressCardEmail"];
    
    return self;
    
}

@end
