package io.github.zhangwei1989.zwconfig.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description for this class.
 *
 * @Author : zhangwei(331874675@qq.com)
 * @Create : 2024/5/5
 */
@Data
@ConfigurationProperties(prefix = "zw")
public class ZWDemoConfig {

    String a;

}
