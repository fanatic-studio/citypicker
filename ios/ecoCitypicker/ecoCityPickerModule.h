#import <Foundation/Foundation.h>
#import "WeexSDK.h"

@interface ecoCityPickerModule : NSObject <WXModuleProtocol>

- (void)select:(NSDictionary*)params callback:(WXModuleKeepAliveCallback)callback;

@end
