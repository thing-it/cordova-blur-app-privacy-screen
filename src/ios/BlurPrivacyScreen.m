#import "AppDelegate.h"

@interface AppDelegate (BlurAppPrivacyScreen) {}
@end

@implementation AppDelegate (BlurAppPrivacyScreen)

  - (void)applicationWillResignActive:(UIApplication *)application {
    NSLog(@"Start Adding Blurred Subview");

    self.window.backgroundColor = [UIColor clearColor];

    UIBlurEffect *blurEffect = [UIBlurEffect effectWithStyle:UIBlurEffectStyleExtraLight];
    UIVisualEffectView *blurEffectView = [[UIVisualEffectView alloc] initWithEffect:blurEffect];
    blurEffectView.frame = self.window.bounds;
    blurEffectView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;

    blurEffectView.tag = 1234;
    blurEffectView.alpha = 0;
    [self.window addSubview:blurEffectView];
    [self.window bringSubviewToFront:blurEffectView];

    // fade in the view
    [UIView animateWithDuration:0.5 animations:^{
      blurEffectView.alpha = 1;
    }];
  } 

- (void)applicationDidBecomeActive:(UIApplication *)application {
  NSLog(@"Start Removing Blur");

  NSArray *subViews = [self.window subviews];
  for (UIView *subview in subViews) { 
    if (subview.tag == 1234) {
      // grab a reference to our custom blur view
      UIView *blurEffectView = subview;
        if (blurEffectView != nil) {
          // fade away blurred view from main view
          [UIView animateWithDuration:0.5 animations:^{
            blurEffectView.alpha = 0;
          } completion:^(BOOL finished) {
            // remove when finished fading
            [blurEffectView removeFromSuperview];
            NSLog(@"Blur removed");
          }];
        }else {
          NSLog(@"Skipped - Blur doesn't exist anymore");
        }
    } else {
          NSLog(@"Skipped - SubView is not our blurred one");
    }
  }
}

@end
