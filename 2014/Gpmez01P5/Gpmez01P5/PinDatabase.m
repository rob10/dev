//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import "PinDatabase.h"

@implementation PinDatabase


@synthesize pins;



+(id)sharedDB
{
    static PinDatabase *sharedDB = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        sharedDB = [[self alloc]init];
    });
    return sharedDB;
    
    
}


-(id) init
{
    
    //NSLog(@"test");
    if(self =[super init])
    {
        pins = [NSMutableDictionary dictionary];
        
        pins[@"1111"] = @"http://www.google.com/";
        pins[@"2222"] = @"http://www.fiu.edu/";
        pins[@"3333"] = @"http://www.yahoo.com/";
        
        //NSLog (@"%@", [pins objectForKey: @"1111"]);
        
    }
    
    
    
    return self;
}


-(void)addPins:(NSString *) p :(NSString *) u
{
    
    pins[p] = u;
    
    
    NSLog(@"%@", pins);
    
}

-(NSString *)getURL:(NSString *) p
{
    return [pins objectForKey: p];
    
}

-(void)setWeb:(NSString *)p
{
    web = p;
}
-(NSString *)web
{
    return [pins objectForKey:web];
}
-(void)removeUrl
{
 
    [pins removeAllObjects];
    
    
}

/*-(NSString *)getPin:(int)n
{
    return [pins ]
}*/

@end
