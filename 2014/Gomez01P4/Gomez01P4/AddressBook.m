//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #4 Address Book
//  DUE:            Thursday 10/14/14
//

#import "AddressBook.h"

@implementation AddressBook

@synthesize book, bookName;

-(instancetype) initWithName:(NSString *)name
{
    self = [super init];
    
    if(self) {
        bookName = [NSString stringWithString: name];
        book = [NSMutableArray array];
    }
    
    return self;
}


-(instancetype) init
{
   
    return [self initWithName: @"Unnamed Book"];
    
}

-(void) setBook: (NSArray *) theBook
{
    book = [theBook mutableCopy];
}

-(void) sort
{
    [book sortUsingSelector: @selector(compareNames:)];
}

-(void) sort2
{
    [book sortUsingComparator:
     ^(id obj1, id obj2) {
         return [[obj1 name] compare: [obj2 name]];
     }];
    
}

-(void) addCard: (AddressCard *) theCard
{
    [book addObject: theCard];
}

-(void) removeCard: (AddressCard *) theCard
{
    [book removeObjectIdenticalTo: theCard];
}
-(NSUInteger) entries
{
    return [book count];
}
-(void) list
{
    NSLog (@"====== Contents of: %@ ========", bookName);
    
    for(AddressCard *theCard in book)
        NSLog(@"%-20s    %-32s", [theCard.name UTF8String],
              [theCard.email UTF8String]);
    
    NSLog(@"=================================");
    
}

-(AddressCard *) lookup: (NSString *) theName
{
    for( AddressCard *nextCard in book)
        if ( [[nextCard name] caseInsensitiveCompare:theName]
            == NSOrderedSame)
            return nextCard;
    
    return nil;
}

-(void) encodeWithCoder: (NSCoder *) encoder
{
    [encoder encodeObject:bookName forKey: @"AddressBookBookName"];
    [encoder encodeObject:book  forKey:@"AddressBookBoook"];
    
}
-(id) initWithCoder:(NSCoder *) decoder
{
    bookName = [decoder decodeObjectForKey:@"AddressBookBookName"];
    book = [decoder decodeObjectForKey:@"AddressBookBook"];
    return self;
}

-(id) copyWithZone:(NSZone *)zone
{
    id newBook = [[[self class] allocWithZone: zone] init];
    
    [newBook setBookName: bookName];
    
    [newBook setBook: book];
    
    return self;
}

@end
