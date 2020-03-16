//
//  vdCitypickerBridge.m
//  vdApp
//
//  Created by 高一 on 2019/1/6.
//

#import "vdCitypickerBridge.h"
#import "vdCityPickerModule.h"

@interface vdCitypickerBridge ()

@property (nonatomic, strong) vdCityPickerModule *city;

@end

@implementation vdCitypickerBridge

- (void)initialize
{
    if (self.city == nil) {
        self.city = [[vdCityPickerModule alloc] init];
    }
}

- (void)select:(NSDictionary*)params callback:(WXModuleKeepAliveCallback)callback
{
    [self.city select:params callback:callback];
}

@end
