//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import <UIKit/UIKit.h>
#import "FirstViewController.h"

@interface SecondViewController : UIViewController <UITextFieldDelegate, UIWebViewDelegate>

//declare webview
@property (weak, nonatomic) IBOutlet UIWebView *myWebView;

//declare label for url
@property (weak, nonatomic) IBOutlet UILabel *urlLabel;


@property PinDatabase *pdb3;


@end

