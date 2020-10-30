//
//  ecoCitypickerBridge.m
//  ecoApp
//
//  Created by 高一 on 2019/1/6.
//

#import "ecoCitypickerBridge.h"
#import "ecoCityPickerModule.h"

@interface ecoCitypickerBridge ()

@property (nonatomic, strong) ecoCityPickerModule *city;

@end

@implementation ecoCitypickerBridge

- (void)initialize
{
    if (self.city == nil) {
        self.city = [[ecoCityPickerModule alloc] init];
    }
}

- (void)select:(NSDictionary*)params callback:(WXModuleKeepAliveCallback)callback
{
    [self.city select:params callback:callback];
}

@end
