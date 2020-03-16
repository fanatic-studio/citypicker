//
//  vdCitypicker.m
//  Pods
//
//  Created by 高一 on 2019/3/4.
//

#import "vdCitypicker.h"
#import "vdCitypickerBridge.h"
#import "WeexInitManager.h"
#import <WebKit/WKWebView.h>

WEEX_PLUGIN_INIT(vdCitypicker)
@implementation vdCitypicker

+ (instancetype) sharedManager {
    static dispatch_once_t onceToken;
    static vdCitypicker *instance;
    dispatch_once(&onceToken, ^{
        instance = [[vdCitypicker alloc] init];
    });
    return instance;
}

- (void) setJSCallModule:(JSCallCommon *)callCommon webView:(WKWebView*)webView
{
    [callCommon setJSCallAssign:webView name:@"vdCitypicker" bridge:[[vdCitypickerBridge alloc] init]];
}

@end
