package com.amazon.plugins.grok;

import com.amazon.common.CommonConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan
@Import(CommonConfig.class)
public class GrokConfig {
}
