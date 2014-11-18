//  PROGRAMMER: Robert Gomez
//  PANTHERID: 4646026
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     Program #5
//  DUE:            11/06/2014
//

#import "SecondViewController.h"



@interface SecondViewController ()

@end

@implementation SecondViewController

//synthesize properties
@synthesize myWebView, urlLabel, pdb3;


- (void)viewDidLoad
{
    //singleton of model class
    pdb3 = [PinDatabase sharedDB];
    
    //NSLog(@"vfl");
    [super viewDidLoad];
	
    //
	self.title = NSLocalizedString(@"WebTitle", @"");
    

    
     //set label text to url
     urlLabel.text = [pdb3 web];
     
    
	//
	[self.myWebView loadRequest:[NSURLRequest requestWithURL:[NSURL URLWithString:[pdb3 web]]]];
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}



- (void)viewWillAppear:(BOOL)animated
{
    NSLog(@"test for vdl2");
	self.myWebView.delegate = self;	// setup the delegate as the web view is shown
    NSLog(@"%@", [pdb3 web]);
    urlLabel.text = [pdb3 web];
    [self.myWebView loadRequest:[NSURLRequest requestWithURL:[NSURL URLWithString:[pdb3 web]]]];
    
    
}




@end
