//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import <Foundation/Foundation.h>

@interface PinDatabase : NSObject{
    
    NSMutableDictionary *pins;
    NSString *web;
    
}

@property (nonatomic, retain) NSMutableDictionary *pins;
@property (nonatomic,retain)NSString *web;

+ (id)sharedDB;

-(void)addPins:(NSString *) p : (NSString *) u;

-(NSString *)getURL:(NSString *) p;

-(void)setWeb:(NSString *) p;
-(NSString *)web;
-(void)removeUrl;
@end
