//
//  ecoCitypicker.m
//  Pods
//
//  Created by 高一 on 2019/3/4.
//

#import "ecoCitypicker.h"
#import "ecoCitypickerBridge.h"
#import "WeexInitManager.h"
#import <WebKit/WKWebView.h>

WEEX_PLUGIN_INIT(ecoCitypicker)
@implementation ecoCitypicker

+ (instancetype) sharedManager {
    static dispatch_once_t onceToken;
    static ecoCitypicker *instance;
    dispatch_once(&onceToken, ^{
        instance = [[ecoCitypicker alloc] init];
    });
    return instance;
}

- (void) setJSCallModule:(JSCallCommon *)callCommon webView:(WKWebView*)webView
{
    [callCommon setJSCallAssign:webView name:@"ecoCitypicker" bridge:[[ecoCitypickerBridge alloc] init]];
}

@end
