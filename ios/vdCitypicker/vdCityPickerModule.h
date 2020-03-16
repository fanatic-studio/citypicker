#import <Foundation/Foundation.h>
#import "WeexSDK.h"

@interface vdCityPickerModule : NSObject <WXModuleProtocol>

- (void)select:(NSDictionary*)params callback:(WXModuleKeepAliveCallback)callback;

@end
